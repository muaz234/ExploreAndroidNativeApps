package com.sample.listjson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String result  = "";
            URL url;
            HttpURLConnection connection = null;
            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream input = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);
                        int data  = reader.read();
                while (data != 1 ){
                    char current = (char) data;
                    result  = result + current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "Error";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadTask task = new DownloadTask();
        String URL = "https://www.youtube.com/";
        try {
            task.execute(URL);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
