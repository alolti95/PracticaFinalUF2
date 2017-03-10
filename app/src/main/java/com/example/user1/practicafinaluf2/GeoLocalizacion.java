package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Geolocalizacion extends AppCompatActivity {

    Button btnGPS, btnGMaps, btnEventos, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geolocalizacion);

        btnGPS = (Button)findViewById(R.id.btnGPS);
        btnGMaps = (Button)findViewById(R.id.btnGMaps);
        btnEventos = (Button)findViewById(R.id.btnEventos);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        btnGPS.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),GPS.class);
                startActivity(i);
            }
        });

        btnGMaps.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),GMaps.class);
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
