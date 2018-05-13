package com.example.qinfenbeen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textView =(TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Data");
        textView.setText(data);
    }
}
