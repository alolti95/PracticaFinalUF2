package com.example.user1.practicafinaluf2;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class FotoNormal extends AppCompatActivity {

    private static final int APP_CAMERA = 0;
    Button btnFoto;
    Uri identificadorImatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_normal);
        btnFoto = (Button) findViewById(R.id.btnFoto);

        //En este botón llamamos al método que realiza la foto
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fesfoto();
            }
        });
    }

    //Método que abrirá la cámara de fotos
    public void fesfoto(){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File foto = new File(Environment.getExternalStorageDirectory(), "fotos.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        identificadorImatge = Uri.fromFile(foto);
        startActivityForResult(intent, APP_CAMERA);
    }

    //Método en el qeu cargará la foto en un ImageView
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.e("requestCode", "requestCide:" + requestCode);
        Log.e("RESULT_OK","RESULT_OK"+RESULT_OK);

        switch(requestCode){
            case APP_CAMERA:
                if(resultCode == RESULT_OK){
                    ContentResolver contRes = getContentResolver();
                    contRes.notifyChange(identificadorImatge, null);

                    //Declaramos el ImageView donde se cargará la foto
                    ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                    Bitmap bitmap;

                    try{
                        bitmap = android.provider.MediaStore.Images.Media.getBitmap(contRes, identificadorImatge);

                        //Especificamos el formato de la imagen con un Bitmap
                        int alt = (int) (bitmap.getHeight() * 1080 / bitmap.getWidth());
                        Bitmap reduit = Bitmap.createScaledBitmap(bitmap, 1080, alt, true);

                        imageView.setImageBitmap(reduit);
                    }catch(Exception e){//Excepción que saltará en caso de que la imagen no pueda cargarse
                        Toast.makeText(this, "No se puede cargar la imagen" +
                                identificadorImatge.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}
