package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Grabacion extends AppCompatActivity {

    final static int INTENT_GRABAR_VIDEO = 1;
    Uri uriVideo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabacion);
    }

    public void onClickBotonGrabar(View v){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, INTENT_GRABAR_VIDEO);
    }
}
