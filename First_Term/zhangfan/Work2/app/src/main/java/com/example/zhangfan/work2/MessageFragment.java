package com.example.zhangfan.work2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {
    private List<Message> messageList = new ArrayList<>();
    static class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
        private List<Message> mMessageList;

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Message message = mMessageList.get(position);
            holder.messageTime.setText(message.getTime());
            holder.messageName.setText(message.getName());
            holder.messageMessage.setText(message.getMessage());
            holder.messageId.setImageResource(message.getImageId());

        }

        @Override
        public int getItemCount() {
            return mMessageList.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView messageId;
            TextView messageName, messageMessage, messageTime;

            public ViewHolder(View view) {
                super(view);
                messageId = (ImageView) view.findViewById(R.id.message_image);
                messageMessage = (TextView) view.findViewById(R.id.message_text);
                messageName = (TextView) view.findViewById(R.id.name_text);
                messageTime = (TextView) view.findViewById(R.id.time_text);

            }
        }

        public MessageAdapter(List<Message> messageList) {
            mMessageList = messageList;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.message_layout, container, false);
        initMessage();
        RecyclerView recyclerView = (RecyclerView) messageLayout.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(),DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        MessageAdapter adapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(adapter);
        return messageLayout;
    }




    private void initMessage() {
        for (int i=0;i<1;i++){
            Message apple = new Message( R.drawable.apple,"苹果","苹果最好吃","下午14：17");
            messageList.add(apple);
            Message banana = new Message( R.drawable.banana,"香蕉","香蕉最好吃","下午14:20");
            messageList.add(banana);
            Message orange = new Message( R.drawable.orange,"橘子","橘子最好吃","下午14:23");
            messageList.add(orange);
            Message watermalon = new Message( R.drawable.watermlon,"西瓜","西瓜最好吃","下午14:27");
            messageList.add(watermalon);
            Message pear = new Message( R.drawable.pear,"梨子","梨子最好吃","星期五");
            messageList.add(pear);
            Message grape = new Message( R.drawable.grape,"葡萄","葡萄最好吃","星期四");
            messageList.add(grape);
            Message pineapple = new Message( R.drawable.pineapple,"菠萝","菠萝最好吃","星期四");
            messageList.add(pineapple);
            Message strawberry = new Message( R.drawable.strawberry,"草莓","草莓最好吃","星期三");
            messageList.add(strawberry);
            Message cherry = new Message( R.drawable.cherry,"樱桃","樱桃最好吃","星期二");
            messageList.add(cherry);
            Message mango = new Message( R.drawable.mango,"芒果","芒果最好吃","星期一");
            messageList.add(mango);
        }
    }

}
