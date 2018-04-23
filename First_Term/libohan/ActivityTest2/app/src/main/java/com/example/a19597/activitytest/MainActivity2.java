package com.example.a19597.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,MainActivity2.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
        Log.d("MainActivity2",data1);
        Log.d("MainActivity2",data2);
    }
}
