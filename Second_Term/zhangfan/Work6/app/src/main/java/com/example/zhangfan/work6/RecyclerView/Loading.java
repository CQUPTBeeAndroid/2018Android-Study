package com.example.zhangfan.work6.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Loading {
        public void showImageFormThread(ImageView imageView, String url){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                }
            }.start();
        }
        public Bitmap bitmapFromUrl(String urlString)  {
            Bitmap bitmap;
            InputStream is = null;
            try {
                URL url = new URL(urlString);
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    is = new BufferedInputStream(connection.getInputStream());
                    bitmap = BitmapFactory.decodeStream(is);
                    connection.disconnect();
                    return bitmap;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
