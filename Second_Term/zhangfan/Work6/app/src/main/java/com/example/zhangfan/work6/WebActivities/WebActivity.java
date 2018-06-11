package com.example.zhangfan.work6.WebActivities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.R;

import java.io.Serializable;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        String data = intent.getStringExtra("itemurl");
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(data);
    }
//    public static void actionStart(Context context, JsonHttp.Results data) {
//        Intent intent = new Intent(context, WebActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("data", (Serializable) data);
//        intent.putExtra("data", bundle);
//        context.startActivity(intent);
    }
