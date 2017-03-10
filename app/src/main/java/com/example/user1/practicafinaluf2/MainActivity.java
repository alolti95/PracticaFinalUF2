package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAnimacion, btnCamara, btnGeolocalizacion, btnSonido, btnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnimacion = (Button)findViewById(R.id.btnAnimacion);
        btnGeolocalizacion = (Button)findViewById(R.id.btnGeolocalizacion);
        btnCamara = (Button)findViewById(R.id.btnCamara);
        btnSonido = (Button)findViewById(R.id.btnSonido);
        btnVideo = (Button)findViewById(R.id.btnVideo);

        btnAnimacion.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Animaciones.class);
                startActivity(i);
            }
        });

        btnGeolocalizacion.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Geolocalizacion.class);
                startActivity(i);
            }
        });

        btnCamara.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Camara.class);
                startActivity(i);
            }
        });

        btnSonido.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Sonido.class);
                startActivity(i);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Video.class);
                startActivity(i);
            }
        });
    }
}
