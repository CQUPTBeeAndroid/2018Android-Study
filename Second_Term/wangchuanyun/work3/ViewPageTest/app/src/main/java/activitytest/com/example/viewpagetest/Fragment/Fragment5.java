package activitytest.com.example.viewpagetest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import activitytest.com.example.viewpagetest.Msg.Msg;
import activitytest.com.example.viewpagetest.Msg.MsgAdapter;
import activitytest.com.example.viewpagetest.R;

/**
 * Created by 问荆 on 2018/5/11.
 */

public class Fragment5 extends Fragment {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyClerview;
    private MsgAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initMsgs();
        View view = inflater.inflate(R.layout.msg_main,container,false);
        inputText = (EditText)view.findViewById(R.id.input_text);
        send = (Button)view.findViewById(R.id.send);
        msgRecyClerview = (RecyclerView)view.findViewById(R.id.msg_view);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
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
        return inflater.inflate(R.layout.msg_main, container, false);
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
