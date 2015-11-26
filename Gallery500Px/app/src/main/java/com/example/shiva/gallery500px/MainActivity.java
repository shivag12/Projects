package com.example.shiva.gallery500px;

import android.app.ProgressDialog;
import android.content.AsyncQueryHandler;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText eTxtSearch;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //https://api.500px.com/v1/photos/search?term=nature&consumer_key=xHkW9aeTnoYk4k1lUYicCjbKY9VXjYOWxE3OsBt8

        eTxtSearch = (EditText) findViewById(R.id.EtxtSearch);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SearchPicsBackground().execute("https://api.500px.com/v1/photos/search?term=" + eTxtSearch.getText() + "&consumer_key="+getString(R.string.ApplicationKey_500Px));
            }
        });


    }

    private class SearchPicsBackground extends AsyncTask<String,Void,String>{
        ProgressDialog pDialog;
        ArrayList<ImagePx> imagePxArrayList = new ArrayList<ImagePx>();

        @Override
        protected String doInBackground(String... params) {

            try {
                Log.d("500PxURL",params[0].toString());
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                //Converting the input stream to buffered reader.
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bufferedReader = new BufferedReader(isr);
                //Reading line by line from teh buffered reader and appeding into String builder.
                StringBuilder sb = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line != null){
                    sb.append(line);
                    line = bufferedReader.readLine();
                }
                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pDialog.dismiss();
            imagePxArrayList =  JsonParsingImagePx.JsonParsersearchResults(s);

            for(ImagePx px : imagePxArrayList){
                Log.d("MainActivity",px.toString());
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Processing..");
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setIndeterminate(true);
            pDialog.show();
        }
    }
}
