package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class UriActivity extends AppCompatActivity {

    private final static String TAG = "UriActivity";
    private News news;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);

        Intent intent = this.getIntent();


        news = (News) intent.getSerializableExtra("news");

        Log.e(TAG,"url"+news.getURL());


        webView = findViewById(R.id.web_ID);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient()); //不調用系統瀏覽器
        webView.loadUrl(news.getURL());



        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.e(TAG,"url"+url);
                return true;
            }
        });


    }
}
