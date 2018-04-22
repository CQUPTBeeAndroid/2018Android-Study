package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.mainactivity.ACTION_START");
                intent.addCategory("com.example.mainactivity.MY_CATEGORY");
                startActivity(intent);
            }
        });
        Button button1=(Button)findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.mainactivity.ACTION_STARTH");
                intent.addCategory("com.example.mainactivity.MY_CATEGORYH");
                startActivity(intent);
            }
        });
    }
}




