package com.example.user1.practicafinaluf2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimInterpolacion extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_interpolacion);
        ImageView imagen = (ImageView) findViewById(R.id.imgGoku);
        imagen.setOnClickListener(this);

    }

    public void onClick(View v){
        //Referenciamos la imagen que queremos utilizar
        ImageView imagen = (ImageView)findViewById(R.id.imgGoku);
        //Cargará la imagen asignada y el fichero con la animación que debe realizar
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.venir);
        //Iniciamos la animación
        imagen.startAnimation(animacion);
    }
}
