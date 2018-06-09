package com.example.materiatest3;

import android.app.Application;
import android.content.Context;

/**
 * Created by 滕扬 on 2018/5/29.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;
    public static Context getInstance(){
        if(mInstance==null){
            mInstance=new MyApplication();
        }
        return mInstance;
    }
}
