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

        //Métodos de cada uno de los botones
        //Botón que nos llevará a la actividad del GPS
        btnGPS.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),GPS.class);
                startActivity(i);
            }
        });

        //Botón que nos llevará a la actividad de GoogleMaps
        btnGMaps.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),GMaps.class);
                startActivity(i);
            }
        });

        //Botón que nos llevará a la actividad de los eventos del mapa
        btnEventos.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),EventosMapa.class);
                startActivity(i);
            }
        });

        //Botón que nos llevará a la actividad principal
        btnVolver.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
