package com.example.zhangfan.work6.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhangfan.work6.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.image_view);
        Intent intent = getIntent();
        String data = intent.getStringExtra("itemurl1");
//
        Glide.with(this).load(data).into(imageView);
    }
//    private void setNetworkBitmap(final String url) {
//        URL httpUrl = null;
//        final Bitmap[] bitmap = {null};
//        Runnable networkImg = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL httpUrl = new URL(url);
//                    HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
//                    conn.setConnectTimeout(6000);
//                    conn.setDoInput(true);
//                    conn.setUseCaches(false);
//                    InputStream in = conn.getInputStream();
//                    bitmap[0] = BitmapFactory.decodeStream(in);
//                    in.close();
//                    conn.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        new Thread(networkImg).start();
//        while(bitmap[0] == null)
//            continue;
//        imageView.setImageBitmap(bitmap[0]);
//
//    }
}
