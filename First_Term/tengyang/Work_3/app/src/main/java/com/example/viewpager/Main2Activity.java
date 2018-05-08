package com.example.viewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    public static void actionStart(Context context, Fruit data) {
        Intent intent = new Intent(context, Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", data);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Fruit fruit = (Fruit) getIntent().getBundleExtra("data").getSerializable("data");
        Log.e("Main2", fruit.getName());

        initMsgs();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });

    }

    private void initMsgs() {
        Msg msg1 = new Msg("你好美女", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好帅哥", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("很高兴见到你", Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }

}