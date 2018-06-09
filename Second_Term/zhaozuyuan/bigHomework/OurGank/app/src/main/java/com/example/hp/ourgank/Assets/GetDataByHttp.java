package com.example.hp.ourgank.Assets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/4 20:08
 * @简述: 发送get请求，得到数据。
 */
public class GetDataByHttp {
    private String url = null;

    private String getRawData = null;       //原始json数据

    private Object bean = null;

    private Class context = null;

    private Handler handler = null;

    private static final int SUCCESS = 1;
    private static final int FAIL = 0;


    /**
     * @param url 网址
     * @param handler 异步的handler
     * @param bean josn种子
     * @param context 种子类
     */
    public GetDataByHttp(String url, Handler handler,Object bean, Class context){
        this.url = url;
        this.bean = bean;
        this.context = context;
        this.handler = handler;
    }

    private void sendOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();

                Request request = new Request.Builder().url(url).build();

                Message message = new Message();

                try {
                    Response response = okHttpClient.newCall(request).execute();
                    getRawData = response.body().string();

                    Gson gson = new Gson();
                    bean = gson.fromJson(getRawData, context);

                    message.what = SUCCESS;
                } catch (Exception e) {
                    message.what = FAIL;
                }
                handler.sendMessage(message);
            }
        }).start();
    }

    public void startSendRequest(){
        sendOkHttp();
    }

    public Object getBean() {
        return bean;
    }

    public String getGetRawData() {
        return getRawData;
    }
}
