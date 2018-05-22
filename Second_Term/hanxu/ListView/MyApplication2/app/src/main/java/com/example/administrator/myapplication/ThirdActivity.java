package com.example.administrator.myapplication;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_lmage_view);
        CircleImageView circleImageView=(CircleImageView)findViewById(R.id.ccc);


    }
}
