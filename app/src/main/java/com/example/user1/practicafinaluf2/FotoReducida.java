package com.example.user1.practicafinaluf2;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
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

public class FotoReducida extends AppCompatActivity {

    private static final int APP_CAMERA = 0;
    Button btnFoto;
    Uri identificadorImatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_reducida);
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

    //Método en el que le pasamos la imagen y el tamaño que queremos obtener
    public static Bitmap cropBitmap(Bitmap original, int height, int width) {
        Bitmap croppedImage = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(croppedImage);

        Rect srcRect = new Rect(0, 0, original.getWidth(), original.getHeight());
        Rect dstRect = new Rect(0, 0, width, height);

        int dx = (srcRect.width() - dstRect.width()) / 2;
        int dy = (srcRect.height() - dstRect.height()) / 2;

        // If the srcRect is too big, use the center part of it.
        srcRect.inset(Math.max(0, dx), Math.max(0, dy));

        // If the dstRect is too big, use the center part of it.
        dstRect.inset(Math.max(0, -dx), Math.max(0, -dy));

        // Draw the cropped bitmap in the center
        canvas.drawBitmap(original, srcRect, dstRect, null);

        original.recycle();

        return croppedImage;
    }
}
