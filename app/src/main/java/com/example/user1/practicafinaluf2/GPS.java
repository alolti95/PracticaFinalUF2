package com.example.user1.practicafinaluf2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GPS extends AppCompatActivity implements LocationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        LocationManager gestorLoc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        gestorLoc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
    }

    //Método que nos indica la posición actual, latitud y longitud
    @Override
    public void onLocationChanged(Location location) {
        String text = "Posición actual:\n" + "Latitud = " + location.getLatitude() + "\n"
                + "Longitud = " + location.getLongitude();
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    //Método que nos muestra los distintos estados del GPS
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        String mensaje = "";
        switch (status) {
            case LocationProvider.OUT_OF_SERVICE:
                mensaje = "GPS status: Out of service";//Mensaje fuera de servicio
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                mensaje = "GPS status: Temporarily unavailable";//Mensaje de temporalmente no disponible
                break;
            case LocationProvider.AVAILABLE:
                mensaje = "GPS status: Available";//Mensaje de disponible
                break;
        }
    }

    //Método que nos mostrará un mensaje cuando activemos el GPS
    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getApplicationContext(),"GPS activado por el usuario", Toast.LENGTH_LONG).show();
    }

    //Método que nos mostrará un mensaje cuando desactivemos el GPS
    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getApplicationContext(),"GPS desactivado por el usuario", Toast.LENGTH_LONG).show();
    }
}
