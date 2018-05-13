package activitytest.com.example.viewpagetest.Msg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import activitytest.com.example.viewpagetest.R;

public class MsgActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyClerview;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg_main);
        initMsgs();
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgRecyClerview = (RecyclerView)findViewById(R.id.msg_view);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        msgRecyClerview.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyClerview.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);
                    msgRecyClerview.scrollToPosition(msgList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }
    private void initMsgs(){
        Msg msg1 = new Msg("Hello guy",Msg.TYPE_RECEVIED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello.Who is that?",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tom.Nice talking to you.",Msg.TYPE_RECEVIED);
        msgList.add(msg3);
    }
}
