package com.example.acoli.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SeconActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secon_layout);
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);
    }
}
