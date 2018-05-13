package com.example.administrator.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity{
    public TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        textView=(TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        String data=intent.getStringExtra("data");
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
