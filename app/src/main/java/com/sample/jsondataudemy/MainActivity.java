package com.sample.jsondataudemy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView text;
    public class DownloadonBackground extends AsyncTask<String, Void, String> {
        String result = "";
        @Override
        protected String doInBackground(String... strings) {
           try {
               URL url = new URL(strings[0]);
               HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
               InputStream input = urlConnection.getInputStream();
               InputStreamReader reader = new InputStreamReader(input);
               int data = reader.read();
               while (data!= -1) {
                   char currentLetter = (char) data;
                   result = result + currentLetter;
                   data = reader.read();

               }
               return result;
           } catch(Exception e){
               e.printStackTrace();
               return null;
           }
        }
    }


    public void MakeQuery(View view) {
         btn = findViewById(R.id.queryBtn);
         text = findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DownloadonBackground background = new DownloadonBackground();
                try {
                    String content = background.execute("https://www.boredapi.com/api/activity/").get();
                    text.setText(content);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MakeQuery(btn);
    }
}
