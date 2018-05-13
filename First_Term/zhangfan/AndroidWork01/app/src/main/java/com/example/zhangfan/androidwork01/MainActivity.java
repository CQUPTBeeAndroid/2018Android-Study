package com.example.zhangfan.androidwork01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn_Intent01;
    private Button btn_Intent02;
    private EditText edt_infor;
    private Button sendmassage;
    private Button btn_mlistview;
    private Button btn_mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Intent01 = (Button)findViewById(R.id.btn_intent01);
        btn_Intent02 = (Button)findViewById(R.id.btn_intent02);
        edt_infor = (EditText)findViewById(R.id.edt_message);
        sendmassage = (Button)findViewById(R.id.btn_send_massage);
        btn_mlistview = (Button)findViewById(R.id.btn_list_view);
        btn_mRecyclerView = (Button)findViewById(R.id.btn_recycler_view);

        btn_mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_Intent01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ScendActivity.class);
                startActivity(intent);
            }
        });

        btn_Intent02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.zhangfan.androidwork01.ACTION_START");
                intent.addCategory("com.example.zhangfan.androidwork01.FIRST_CATEGORY");
                startActivity(intent);
            }
        });
        sendmassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ScendActivity.class);
                intent.putExtra("extra_data01",edt_infor.getText().toString());
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data02");
        edt_infor.setText(data);
        btn_mlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
