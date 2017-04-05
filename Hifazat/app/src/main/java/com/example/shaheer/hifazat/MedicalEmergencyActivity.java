package com.example.shaheer.hifazat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.shaheer.hifazat.MapsActivity.MY_PERMISSIONS_REQUEST_LOCATION;

public class MedicalEmergencyActivity extends AppCompatActivity implements LocationListener, GoogleApiClient.ConnectionCallbacks{

    private GoogleMap mMap;
    //private  Position position;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    GoogleApiClient mGoogleApiClient;
    protected Context context;
    String mprovider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_emergency);


        final EditText etlongitude=(EditText) findViewById(R.id.etlongitude);
        final EditText etlatitude=(EditText) findViewById(R.id.etlatitude);
        final EditText etlandmark=(EditText) findViewById(R.id.etlandmark);
        final EditText etstatus=(EditText) findViewById(R.id.etstatus);
        final EditText etdescription=(EditText) findViewById(R.id.etdescription);

        final Button btnsubmit=(Button) findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String longitude=etlongitude.getText().toString();
                final String latitude=etlatitude.getText().toString();
                final String landmark=etlandmark.getText().toString();
                final String status=etstatus.getText().toString();
                final String descriptions=etdescription.getText().toString();

                Response.Listener<String> resplsn=new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResp=new JSONObject(response);
                            boolean success=jsonResp.getBoolean("success");
                            if (success){
                                Intent intent=new Intent(MedicalEmergencyActivity.this, TrioActivity.class);
                                MedicalEmergencyActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(MedicalEmergencyActivity.this);
                                builder.setMessage("Could not submit!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                MedicalEmergencyInsert medicalEmergencyInsert=new MedicalEmergencyInsert(longitude, latitude, landmark, status, descriptions, resplsn);
                RequestQueue queue= Volley.newRequestQueue(MedicalEmergencyActivity.this);
                queue.add(medicalEmergencyInsert);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    @Override
    public void onLocationChanged(Location location)
    {
        TextView longitude = (TextView) findViewById(R.id.etlongitude);
        TextView latitude = (TextView) findViewById(R.id.etlatitude);

        longitude.setText(""+location.getLongitude());
        latitude.setText("" + location.getLatitude());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}
