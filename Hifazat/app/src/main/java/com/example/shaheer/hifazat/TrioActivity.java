package com.example.shaheer.hifazat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TrioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trio);

        final Button crime=(Button) findViewById(R.id.crimesec);
        final Button med=(Button) findViewById(R.id.medemer);
        final Button disaster=(Button) findViewById(R.id.disalert);
        final Button map=(Button) findViewById(R.id.btnmap);
        final Button newsfeed=(Button) findViewById(R.id.btnnewsfeed) ;

        crime.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent crimeIntent = new Intent(TrioActivity.this, CrimeActivity.class);
                TrioActivity.this.startActivity(crimeIntent);

            }
        });
        med.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent medIntent = new Intent(TrioActivity.this, MedicalEmergencyActivity.class);
                TrioActivity.this.startActivity(medIntent);

            }
        });
        disaster.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent disasterIntent = new Intent(TrioActivity.this, DisasterAlert.class);
                TrioActivity.this.startActivity(disasterIntent);

            }
        });
        map.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(TrioActivity.this, MapsActivity.class);
                TrioActivity.this.startActivity(mapIntent);

            }
        });

        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsfeedIntent=new Intent(TrioActivity.this, NewsFeedActivity.class);
                TrioActivity.this.startActivity(newsfeedIntent);
            }
        });
    }
}