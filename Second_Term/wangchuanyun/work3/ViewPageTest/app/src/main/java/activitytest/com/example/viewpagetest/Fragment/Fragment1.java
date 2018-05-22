package activitytest.com.example.viewpagetest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import activitytest.com.example.viewpagetest.Adapter.Message;
import activitytest.com.example.viewpagetest.R;

/**
 * Created by 问荆 on 2018/5/10.
 */

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pic1, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.message_recycler1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MessageAdapter messageAdapter= new MessageAdapter(getData());
        recyclerView.setAdapter(messageAdapter);
        return view;
    }
    private List<Message> getData(){
        List<Message>messageList = new ArrayList<>();
        Message mingren = new Message("鸣人",R.drawable.mingren,"你好!");
        messageList.add(mingren);
        Message zuozhu = new Message("佐助",R.drawable.zuozhu,"你好!");
        messageList.add(zuozhu);
        Message sishen = new Message("死神",R.drawable.sishen,"你好！");
        messageList.add(sishen);
        Message wukong = new Message("悟空",R.drawable.wukong,"你好！");
        messageList.add(wukong);
        return messageList;
    }

    public  class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
        private List<Message> myMessage;
         class ViewHolder extends RecyclerView.ViewHolder{
             View messageView;
            ImageView messagerView;
            TextView messageName;
             TextView messageMes;
            public ViewHolder(View view){
                super(view);
                messageView = view;
                messagerView = (ImageView)view.findViewById(R.id.image1);
                messageName = (TextView)view.findViewById(R.id.text1);
                messageMes = (TextView)view.findViewById(R.id.text2);
            }
        }
        public MessageAdapter(List<Message>messageList){
            myMessage = messageList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Message message = myMessage.get(position);
            holder.messagerView.setImageResource(message.getImageId());
            holder.messageName.setText(message.getName());
            holder.messageMes.setText(message.getMes());
        }

        @Override
        public int getItemCount() {
            return myMessage.size();
        }
    }
}
