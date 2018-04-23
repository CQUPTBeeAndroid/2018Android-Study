package com.example.zhangfan.androidwork01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScendActivity extends AppCompatActivity {
    private TextView getmassage;
    private EditText writemassage;
    private Button sendmassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scend);
        getmassage = (TextView) findViewById(R.id.tet_getmessage);
        writemassage = (EditText)findViewById(R.id.edt_writemassage);
        sendmassage = (Button)findViewById(R.id.btn_sendmassage);

        final Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data01");
        getmassage.setText(data);

        sendmassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(ScendActivity.this,MainActivity.class);
                intent1.putExtra("extra_data02",writemassage.getText().toString());
                startActivity(intent1);
            }
        });
    }
}
