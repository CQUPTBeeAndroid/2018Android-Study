package com.example.administrator.mywork;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgRecyclerAdapter adapter;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_main);
        Intent intent=getIntent();

        String name=intent.getStringExtra("name");
        ActionBar actionBar=getActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        initMsgs();
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(ChatActivity.this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgRecyclerAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=inputText.getText().toString();
                if (!"".equals(data)){
                    Msg msg=new Msg(data,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                }
            }
        });

    }
    private  void initMsgs(){
        Msg msg1=new Msg("hello,gay.",Msg.Type_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("hello",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3=new Msg("Fuck me gay",Msg.Type_RECEIVED);
        msgList.add(msg3);
    }
}
