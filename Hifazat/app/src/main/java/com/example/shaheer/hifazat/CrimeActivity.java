package com.example.shaheer.hifazat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class CrimeActivity extends AppCompatActivity implements LocationListener, GoogleApiClient.ConnectionCallbacks{


    CrimeInsertSQLite myDB;

    private GoogleMap mMap;
    //private  Position position;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    GoogleApiClient mGoogleApiClient;
    protected Context context;
    String mprovider;

    //ImageView imageViewLoad;
    Button btnimage,btnsubmit;
    EditText etlatitude,etlongitude,etlandmark,etcrimes,etdescription;
    //TextView tvlatitude,tvlongitude;
    ImageView imageView;
    Intent intent;
    boolean isInternetConeected = ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        etlatitude = (EditText)findViewById(R.id.etlatitude);
        etlongitude =(EditText)findViewById(R.id.etlongitude);
        etlandmark =(EditText)findViewById(R.id.etlandmark);
        etcrimes =(EditText)findViewById(R.id.etcrime);
        etdescription =(EditText)findViewById(R.id.etdescription);

        //imageView  = (ImageView) findViewById(R.id.imageView);

        //new work done for MySQL n SQLite..
        //ButtonSaving();

        //addCrimeDetail();
        //insertCrimeImage();

        Criteria criteria = new Criteria();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mprovider = locationManager.getBestProvider(criteria,false);

        if (mprovider != null && !mprovider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(mprovider);
            locationManager.requestLocationUpdates(mprovider, 15000, 1, this);
            if (location != null){
                onLocationChanged(location);}
            else {
                Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_SHORT).show();
            }
        }
        insertCrimeDetail();
    }
    /*public void insertCrimeImage(){
        btnimage=(Button) findViewById(R.id.btnimage);
        btnimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crimeimageIntent=new Intent(CrimeActivity.this, CrimeImageActivity.class);
                CrimeActivity.this.startActivity(crimeimageIntent);
            }
        });
    }*/
    public void addCrimeDetail(){
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(etlatitude.getText().toString(),
                        etlongitude.getText().toString(), etlandmark.getText().toString(),
                        etcrimes.getText().toString(), etdescription.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(CrimeActivity.this, "Data inserted in SQLite successfully..", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CrimeActivity.this, "Fail to insert data in SQLite..", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void insertCrimeDetail() {
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> resplsn = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResp = new JSONObject(response);
                            boolean success = jsonResp.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(CrimeActivity.this, TrioActivity.class);
                                CrimeActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(CrimeActivity.this);
                                builder.setMessage("Could not submit!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                CrimeInsert crimeInsert = new CrimeInsert(etlongitude.getText().toString(),
                        etlatitude.getText().toString(), etlandmark.getText().toString(),
                        etcrimes.getText().toString(), etdescription.getText().toString(), resplsn);
                RequestQueue queue = Volley.newRequestQueue(CrimeActivity.this);
                queue.add(crimeInsert);
            }
        });
    }

    public void ButtonSaving(){
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInternetConeected = true ){
                    //save in MySQL..
                    insertCrimeDetail();
                }
                else{
                    //save in SQLite..
                    addCrimeDetail();
                }
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
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
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
        //tvlongitude = (TextView) findViewById(R.id.etlongitude);
        //tvlatitude = (TextView) findViewById(R.id.etlatitude);
        etlongitude.setText(""+location.getLongitude());
        etlatitude.setText("" + location.getLatitude());
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
