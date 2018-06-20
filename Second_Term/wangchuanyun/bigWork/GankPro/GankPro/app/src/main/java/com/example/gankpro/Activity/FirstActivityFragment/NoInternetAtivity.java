package com.example.gankpro.Activity.FirstActivityFragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gankpro.Activity.FirstActivity;
import com.example.gankpro.R;

public class NoInternetAtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet_ativity);
        Button button = (Button)findViewById(R.id.no_internet);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoInternetAtivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
