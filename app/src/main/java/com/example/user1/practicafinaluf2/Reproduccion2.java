package com.example.user1.practicafinaluf2;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class Reproduccion2 extends AppCompatActivity {

    private static String mNombreFichero1 = null;
    private static String mNombreFichero2 = null;

    private boolean mGrabando = false;
    private boolean mReproduciendo = false;

    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduccion2);
    }

    public void onClickBotonReproducir(View v){
        if(mReproduciendo){
            pararReproduccion();
        }else{
            empiezaReproduccion();
        }
        mReproduciendo = !mReproduciendo;
    }

    private void empiezaReproduccion(){
        mPlayer = new MediaPlayer();
        try{
            mPlayer.setDataSource(mNombreFichero1);
            mPlayer.prepare();
            mPlayer.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void pararReproduccion(){
        mPlayer.release();
        mPlayer = null;
    }
}
