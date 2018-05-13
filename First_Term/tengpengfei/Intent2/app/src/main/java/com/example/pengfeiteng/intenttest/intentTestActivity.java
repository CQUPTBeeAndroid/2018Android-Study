package com.example.pengfeiteng.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class intentTestActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        final Intent intent = getIntent();
        final String data = intent.getStringExtra("fromFirstActivity");
        mButton = (Button) findViewById(R.id.myButton);
        mTextView = findViewById(R.id.IntentDataOutput);
        mEditText = findViewById(R.id.InputText);
        mTextView.setText(data);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newintent = new Intent();
                newintent.putExtra("returnData",/*mEditText.getText()*/"hahhaa");
                setResult(RESULT_OK, newintent);
                finish();
            }
        });
    }
}
