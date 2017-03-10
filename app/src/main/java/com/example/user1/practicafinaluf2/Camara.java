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

public class Camara extends AppCompatActivity {

    Button btnFoto1, btnFoto2, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        btnFoto1 = (Button)findViewById(R.id.btnFoto1);
        btnFoto2 = (Button)findViewById(R.id.btnFoto2);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        btnFoto1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),FotoNormal.class);
                startActivity(i);
            }
        });

        btnFoto2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),AnimFotogramas.class);
                startActivity(i);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }


}
