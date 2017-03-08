package com.example.user1.practicafinaluf2;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class AnimFotogramas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_fotogramas);

        ImageView imagen = (ImageView) findViewById(R.id.imgClick);
        AnimationDrawable animacion = (AnimationDrawable) imagen.getDrawable();
        animacion.start();
    }
}
