package com.example.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button button = (Button) findViewById(R.id.button_3);
        editText = (EditText) findViewById(R.id.edit_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_3:
                        String text = editText.getText().toString();
                        Toast.makeText(Main3Activity.this, text, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });


    }
}
