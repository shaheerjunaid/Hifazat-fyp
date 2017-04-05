/*package com.example.shaheer.hifazat;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;



public class Position extends ActivityCompat {
    private boolean GPSPosition;
    private boolean networkPosition;
    private boolean SavedPosition;
    private Context context;
    private LatLng latLng;
    private double latitude;
    private double longitude;
    private LocationManager locationManager;
    private LocationListener listener;
    static public final int GPS = 2;
    static public final int NETWORK = 1;
    private float minDistance = 5000;
    private long updateTime = 0;


    public Position(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        setListener();

    }

    public Position(Context context, float minDistance, long updateTime) {
        this.context = context;
        this.minDistance = minDistance;
        this.updateTime = updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public void setMinDistance(float minDistance) {
        this.minDistance = minDistance;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void getLocation(int source) {
        if (source == GPS) {
//            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//
//                return;
//            }
            //else
            //{
            if (ActivityCompat.checkSelfPermission(this.context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, updateTime, minDistance, listener);
  //          }
        }
        else if(source==NETWORK)
        {

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,updateTime,minDistance,listener);
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    private void setListener()
    {
        listener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                latitude=location.getLatitude();
                longitude=location.getLongitude();
                latLng=new LatLng(latitude,longitude);
                Log.d("Your position",latitude+"    "+longitude);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent settingsActivity = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(settingsActivity);

            }
        };
    }
}

*/