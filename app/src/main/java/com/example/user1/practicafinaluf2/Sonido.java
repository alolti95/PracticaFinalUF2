package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sonido extends AppCompatActivity {

    Button btnGrabar, btnReproducir, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        btnGrabar = (Button)findViewById(R.id.btnGrabar);
        btnReproducir = (Button)findViewById(R.id.btnReproducir);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        btnGrabar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Grabacion2.class);
                startActivity(i);
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Reproduccion2.class);
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
