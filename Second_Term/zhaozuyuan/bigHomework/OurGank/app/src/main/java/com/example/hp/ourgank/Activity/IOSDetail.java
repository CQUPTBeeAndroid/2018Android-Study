package com.example.hp.ourgank.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.ourgank.Bean.AndroidIntentData;
import com.example.hp.ourgank.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/9 23:31
 * @简述:  IOS详情页面，展示webview，完全与安卓一样
 */
public class IOSDetail extends AppCompatActivity {

    private AndroidIntentData data = null;  //接受数据种子

    private TextView textView2;         //提示

    private List<WebView> webViews = new ArrayList<>();  //用于销毁使用

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosdetail);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        data = (AndroidIntentData)getIntent().getSerializableExtra("data");

        TextView textView = (TextView)findViewById(R.id.ios_detail_text);
        textView.setText("资源地址："+data.getUrl());
        textView.setTextSize(17);

        textView2 = findViewById(R.id.ios_detail_text2);

        addWebView();
    }

    /**
     * 动态添加webview
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void addWebView(){
        LinearLayout linearLayout = findViewById(R.id.ios_detail_ll);

        int n = 0;          //确定webview 的数量
        if(data.getImages() != null){
            n = data.getImages().size();
        }else {textView2.setText("当前无展示图片");}       //没有可以展示的webview时

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(40,0,40,20);

        for(int i = 0;i < n;i++){
            WebView webView = new WebView(this);
            webView.loadUrl(data.getImages().get(i));
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });

            webView.getSettings().setJavaScriptEnabled(true);       //支持javascript

            webView.setLayoutParams(params);        //设置webview 的ui参数

            linearLayout.addView(webView);          //添加webview到布局

            webViews.add(webView);                  //添加到容器
        }
    }

    //销毁Webview
    @Override
    protected void onDestroy() {
        for(WebView webView:webViews) {
            if (webView != null) {
                webView.loadDataWithBaseURL(null, "", "text/html"
                        , "utf-8", null);
                webView.clearHistory();

                ((ViewGroup) webView.getParent()).removeView(webView);
                webView.destroy();
                webView = null;
            }
        }

        super.onDestroy();
    }
}
