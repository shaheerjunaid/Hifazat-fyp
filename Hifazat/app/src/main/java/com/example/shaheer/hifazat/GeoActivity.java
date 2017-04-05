package com.example.shaheer.hifazat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GeoActivity extends Activity implements OnItemSelectedListener {

    TextView header;
    List<String> headlines;
    List<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            header = (TextView) findViewById(R.id.head_lbl);
            Spinner spinner = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.geo_array,
                    android.R.layout.simple_spinner_item);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapterSpinner);
            spinner.setOnItemSelectedListener(this);
        } catch (Exception e) {
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        try {
            String item = parent.getItemAtPosition(pos).toString();
            if (item.equals("Geo Headlines")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/geo/dTwR");
                links = Links.returnLinks("http://feeds.feedburner.com/geo/dTwR");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo Pakistan")) {
                header.setText(item);

                headlines = new ArrayList<String>();
                links = new ArrayList<String>();

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/geo/GiKR");
                links = Links.returnLinks("http://feeds.feedburner.com/geo/GiKR");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo World")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/geo/wUIl");
                links = Links.returnLinks("http://feeds.feedburner.com/geo/wUIl");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo Business")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/geo/hegG");
                links = Links.returnLinks("http://feeds.feedburner.com/geo/hegG");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo Sports")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/GeoSport-GeoTvNetwork");
                links = Links.returnLinks("http://feeds.feedburner.com/GeoSport-GeoTvNetwork");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo Entertainment")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/GeoEntertainment-GeoTvNetwork");
                links = Links.returnLinks("http://feeds.feedburner.com/GeoEntertainment-GeoTvNetwork");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo Health")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.feedburner.com/GeoHealth-GeoTvNetwork");
                links = Links.returnLinks("http://feeds.feedburner.com/GeoHealth-GeoTvNetwork");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("Geo Amazing And Interesting")) {
                header.setText(item);

                headlines = Headlines
                        .returnHeadlines("http://feeds.feedburner.com/GeoAmazingAndInteresting-GeoTvNetwork");
                links = Links.returnLinks("http://feeds.feedburner.com/GeoAmazingAndInteresting-GeoTvNetwork");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(GeoActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else {
                header.setText("");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}
