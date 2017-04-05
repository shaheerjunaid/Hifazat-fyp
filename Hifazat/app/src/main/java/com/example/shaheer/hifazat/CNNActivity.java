package com.example.shaheer.hifazat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CNNActivity extends Activity implements AdapterView.OnItemSelectedListener {

    List<String> headlines;
    List<String> links;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnn);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            header = (TextView) findViewById(R.id.head_lbl);
            Spinner spinner = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.cnn_array,
                    android.R.layout.simple_spinner_item);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapterSpinner);
            spinner.setOnItemSelectedListener(this);
        } catch (Exception e) {
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try {
            String item = parent.getItemAtPosition(position).toString();
            if (item.equals("CNN Top Stories")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

            } else if (item.equals("CNN World")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition_world.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition_world.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN Money")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/money_news_international.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/money_news_international.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN Technology")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition_technology.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition_technology.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN Science And Space")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition_space.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition_space.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN Entertainment")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition_entertainment.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition_entertainment.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN Travel")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition_travel.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition_travel.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN World Sport")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/edition_sport.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/edition_sport.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Uri uri = Uri.parse(links.get(position));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            } else if (item.equals("CNN Most Recent")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://rss.cnn.com/rss/cnn_latest.rss");
                links = Links.returnLinks("http://rss.cnn.com/rss/cnn_latest.rss");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(CNNActivity.this,
                        android.R.layout.simple_list_item_1, headlines);

                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);
                list.deferNotifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }
}
