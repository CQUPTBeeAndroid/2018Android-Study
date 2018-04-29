package com.example.pengfeiteng.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button m_intentButton;
    private TextView returnDataTextView;
    private String data = "This is the data from the firstActivity";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (requestCode == RESULT_OK){
                    returnDataTextView.setText(data.getStringExtra("returnData"));
                    Toast.makeText(MainActivity.this,"caonima",Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_intentButton = (Button)findViewById(R.id.IntentButton);
        returnDataTextView = findViewById(R.id.getReturnData);
        m_intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.ACTION_START");
                intent.addCategory("com.example.activity.MY_CATEGORY");
                intent.putExtra("fromFirstActivity", data);
                startActivityForResult(intent,1);
            }
        });

    }
}
