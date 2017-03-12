package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Animaciones extends AppCompatActivity {

    //Declaramos los botones que nos llevaran a cada tipo de animación y a la actividad principal
    Button btnInterpolacion, btnFotogramas, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaciones);

        btnInterpolacion = (Button)findViewById(R.id.btnInterpolacion);
        btnFotogramas = (Button)findViewById(R.id.btnFotogramas);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        //Métodos de cada botón.

        //Botón que nos llevará a la animación de Interpolación
        btnInterpolacion.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),AnimInterpolacion.class);
                startActivity(i);
            }
        });

        //Botón que nos llevará a los fotogramas
        btnFotogramas.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),AnimFotogramas.class);
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
