package com.example.hp.level4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 解析json数据，异步加载图片
 */
public class LoadImage extends AsyncTask<Void,Integer,Boolean> {

    JsonBean jsonBean = new JsonBean();

    Bitmap bitmap;

    ImageView imageView;

    public LoadImage(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate();
    }

    @Override
    protected void onCancelled(Boolean b) {
        super.onCancelled(b);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        String type = null;
        String all = null;

        try {
//                        将汉字转化为标准网址
            type = java.net.URLEncoder.encode("美女", "utf-8");
            all = java.net.URLEncoder.encode("全部", "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.d("TAG", "错误1");
        }

        String apiUrl = String.format("http://image.baidu.com/channel/listjson?pn=0" +
                "&rn=8&tag1=%s&tag2=%s&ie=utf8", type, all);

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .build();
            Response response = client.newCall(request).execute();
            String responesDate = response.body().string();
//                        responesDate即是获取的json数据流。

//                        转化为JsonBean对象
            Gson gson = new Gson();
            try {
                jsonBean = gson.fromJson(responesDate, JsonBean.class);
            } catch (Exception e) {
                Log.d("TAG", "错误2");
                return false;
            }
        } catch (Exception e) {
            Log.d("TAG", "错误3");
            return false;
        }


        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(jsonBean.getData().get(0).getImage_url())
                    .build();
            Response r = client.newCall(request).execute();
            bitmap =  BitmapFactory.decodeStream(r.body().byteStream());
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
