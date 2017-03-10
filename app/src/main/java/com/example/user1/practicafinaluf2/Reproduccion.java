package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class Reproduccion extends AppCompatActivity {

    final static int INTENT_GRABAR_VIDEO = 1;
    Uri uriVideo = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            if(requestCode == INTENT_GRABAR_VIDEO){
                uriVideo = data.getData();
                Toast.makeText(this, uriVideo.getPath(), Toast.LENGTH_LONG).show();
                Button btnReproducir = (Button) findViewById(R.id.btnReproducir);
                btnReproducir.setEnabled(true);
            }
        }else if(resultCode == RESULT_CANCELED){
            uriVideo = null;
            Toast.makeText(this, "Grabación cancelada!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickBotonReproducir(View view){
        Toast.makeText(this, "Reproduciendo: " + uriVideo.getPath(), Toast.LENGTH_LONG).show();

        VideoView visorVideo = (VideoView) findViewById(R.id.visorVideo);
        visorVideo.setVideoURI(uriVideo);
        visorVideo.start();
    }
}