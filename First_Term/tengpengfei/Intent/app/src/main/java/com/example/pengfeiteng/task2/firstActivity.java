package com.example.pengfeiteng.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class firstActivity extends AppCompatActivity {
    private Button m_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        m_button = (Button)findViewById(R.id.IntentButton1);
        m_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent finishIntent = new Intent(firstActivity.this, SecondActivity.class);
                startActivity(finishIntent);
            }
        });
    }
}
