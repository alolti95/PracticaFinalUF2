package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class animaciones extends AppCompatActivity {

    Button btnInterpolacion, btnFotogramas, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaciones);

        btnInterpolacion = (Button)findViewById(R.id.btnInterpolacion);
        btnFotogramas = (Button)findViewById(R.id.btnFotogramas);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        btnInterpolacion.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),AnimInterpolacion.class);
                startActivity(i);
            }
        });
    }
}
