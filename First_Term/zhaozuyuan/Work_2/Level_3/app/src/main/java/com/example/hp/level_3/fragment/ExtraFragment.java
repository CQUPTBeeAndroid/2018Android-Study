package com.example.hp.level_3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.hp.level_3.R;

/**
 * 里面放置了一个webView，一个按钮。
 */
public class ExtraFragment extends android.support.v4.app.Fragment{

    private static final String baidu = "https://www.baidu.com/";

    private WebView webView;

    private Button btn;

    private Animation animation;        //动画

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.extra_fragment,container,false);
        webView = (WebView)view.findViewById(R.id.extra_web);
        btn = (Button) view.findViewById(R.id.extra_web_btn);

//        动画设计
        animation=new AlphaAnimation(1.0f,0.3f);
        animation.setDuration(80);

        showWeb();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(baidu);
                btn.startAnimation(animation);
            }
        });

        return view;

    }

    private void showWeb(){
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(baidu);
    }
}
