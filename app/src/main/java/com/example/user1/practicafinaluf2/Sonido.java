package com.example.user1.practicafinaluf2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class Sonido extends AppCompatActivity {

    Button btnVolver;

    private static String mNomFitxer1 = null;
    private static String mNomFitxer2 = null;

    private boolean mGravant = false;
    private boolean mReproduint = false;

    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;

    private File fichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);

        btnVolver = (Button)findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        mNomFitxer1 = Environment.getExternalStorageDirectory() + "/gravacio1.3gp";
        mNomFitxer2 = getExternalFilesDir(null) + "/gravacio2.3gp";
    }



    public void onClickBotonReproducir(View view){
        if(mReproduint) {
            //aturaReproduccio();
            pararReproduccion();

        }else{
            //comencaReproduccio();
            empezarReproduccion();
        }

        mReproduint = !mReproduint;
    }

    private void empezarGrabacion()  {
        //Crea el MediaREcorder i especifica la font d'audio, el format de sortida i el fitxer, i el codificador d'audio
        //fichero = new File(Environment.DIRECTORY_MUSIC,"sonido.3gp");



        //Crea el MediaREcorder
        mRecorder = new MediaRecorder();
        //especifica la font d'audio


        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //el format de sortida
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //el codificador d'audio
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //el fitxer
        File path = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());
        try {
            fichero = File.createTempFile("temporal", ".3gp", path);
        } catch (IOException e) {
        }

        mRecorder.setOutputFile(fichero.getAbsolutePath());


        //Enllestim la gravació
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Si s'ha pogut disposar tot correctament, es comença a gravar
        mRecorder.start();

    }

    public void onClickBotonGrabar(View view){
        if(mGravant) {
            //aturaGravacio();
            pararGrabacion();
        }else{
            //comencaGravacio();
            empezarGrabacion();
        }

        mGravant = !mGravant;
    }


    private void pararGrabacion(){
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }



    private void empezarReproduccion(){
        mPlayer = new MediaPlayer();


        try {
            mPlayer.setDataSource(fichero.getAbsolutePath());
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void pararReproduccion(){
        mPlayer.release();
        mPlayer = null;
    }

}
