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

import java.util.List;

public class BBCActivity extends Activity implements OnItemSelectedListener {

    List<String> headlines;
    List<String> links;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbc);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            header = (TextView) findViewById(R.id.head_lbl);
            Spinner spinner = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.bbc_array,
                    android.R.layout.simple_spinner_item);
            adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapterSpinner);
            spinner.setOnItemSelectedListener(this);

            spinner.setOnItemSelectedListener(this);
        } catch (Exception e) {	}
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        try {

            String item = parent.getItemAtPosition(position).toString();
            if (item.equals("BBC News Front Page")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC World")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/world/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Business")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/business/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Politics")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/politics/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Health")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/health/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Education")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/education/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Science/Nature")) {
                header.setText(item);

                headlines = Headlines
                        .returnHeadlines("http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/science_and_environment/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Technology")) {
                header.setText(item);

                headlines = Headlines.returnHeadlines("http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/technology/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
            } else if (item.equals("BBC Entertainment")) {
                header.setText(item);

                headlines = Headlines
                        .returnHeadlines("http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");
                links = Links.returnLinks("http://feeds.bbci.co.uk/news/entertainment_and_arts/rss.xml?edition=uk");

                ListView list = (ListView) findViewById(R.id.listView1);
                // Binding data
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BBCActivity.this,
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
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }
}

