package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAnimacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnimacion = (Button)findViewById(R.id.btnAnimacion);

        btnAnimacion.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Animaciones.class);
                startActivity(i);
            }
        });
    }
}
