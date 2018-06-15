package com.example.zhangfan.work6.HttpUtil;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}

