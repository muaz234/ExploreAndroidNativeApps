package com.muazlabs.webview;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    WebView webview;
    TextView title;
    String url = "https://github.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        toolbar = findViewById(R.id.toolbar);
        title = findViewById(R.id.title);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Github");
        webview = findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.clearCache(true);
        webview.clearHistory();
        try {
            webview.loadUrl(url);
//            webview.loadUrl("https://www.google.com/");
        } catch (Exception e) {
            webview.loadUrl("www.google.com");
            Log.i("error", e.toString());
        }
    }

    public void goBack() {
        finish();
    }
}
