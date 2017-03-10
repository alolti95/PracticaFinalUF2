package com.example.user1.practicafinaluf2;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class Grabacion2 extends AppCompatActivity {

    private static String mNombreFichero1 = null;
    private static String mNombreFichero2 = null;

    private boolean mGrabando = false;
    private boolean mReproduciendo = false;

    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNombreFichero1 = Environment.getExternalStorageDirectory() + "/gravacio1.3gp";
        mNombreFichero2 = getExternalFilesDir(null) + "/gravacio2.3gp";
    }

    public void onClickBotonGrabar(View v){
        if(mGrabando){
            pararGrabacion();
        }else{
            empiezaGrabacion();
        }
        mGrabando = !mGrabando;
    }

    private void empiezaGrabacion(){
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mNombreFichero1);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mRecorder.start();
    }

    private void pararGrabacion(){
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }
}
