package com.example.zhangfan.work6.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ImageLoader {
    private ImageView mImageView;
    private String mURL;
   private android.os.Handler handler = new android.os.Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
//           if (mImageView.getTag().equals(mURL)){
//               mImageView.setImageBitmap((Bitmap) msg.obj);
//           }

       }
   };
    public void showImageByThread(ImageView imageView, final String url){
        mImageView = imageView;
//        mURL = url;
        new Thread(new Runnable() {
            @Override
            public void run() {
              Bitmap bitmap = getBitmapFormUrl(url);
//              Message massage = Message.obtain();
//              massage.obj = bitmap;
            }
        }).start();
    }
    public Bitmap getBitmapFormUrl(String urlString){
        Bitmap bitmap;
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(httpURLConnection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            httpURLConnection.disconnect();
            return  bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            }
            finally {
                try {
                    is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
