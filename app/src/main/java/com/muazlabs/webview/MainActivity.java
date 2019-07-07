package com.muazlabs.webview;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebViewClient;
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
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Github");
        webview = findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.clearCache(true);
        webview.clearHistory();
        webview.setVerticalScrollBarEnabled(true);
        webview.setHorizontalFadingEdgeEnabled(true);

        try {
            webview.setWebViewClient(new WebViewClient());
//           webview.setWebChromeClient(new WebChromeClient());
            webview.loadUrl(url);
            //testing with google link
//            webview.loadUrl("https://www.google.com/");
        } catch (Exception e) {
            //load url google instead of any error message which user get confuse!!
            webview.loadUrl("www.google.com");
            Log.i("error", e.toString());
        }
    }

    public void goBack() {
        finish();
    }
}
