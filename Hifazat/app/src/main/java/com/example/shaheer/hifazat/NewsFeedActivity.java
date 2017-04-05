package com.example.shaheer.hifazat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class NewsFeedActivity extends Activity implements OnClickListener {
    ImageView img_cnn;
    ImageView img_geo;
    ImageView img_bbc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);


        try {
            img_cnn = (ImageView) findViewById(R.id.imageView1);
            img_geo = (ImageView) findViewById(R.id.imageView2);
            img_bbc = (ImageView) findViewById(R.id.imageView4);

            img_cnn.setOnClickListener(this);
            img_geo.setOnClickListener(this);
            img_bbc.setOnClickListener(this);

        } catch (Exception e) {
        }
    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.imageView1) {
                Intent intent = new Intent(this, CNNActivity.class);
                startActivity(intent);
            } else if (v.getId() == R.id.imageView2) {
                Intent intent = new Intent(this, GeoActivity.class);
                startActivity(intent);
            }  else if (v.getId() == R.id.imageView4) {
                Intent intent = new Intent(this, BBCActivity.class);
                startActivity(intent);
            }
        } catch (Exception e) {
        }
    }
}
