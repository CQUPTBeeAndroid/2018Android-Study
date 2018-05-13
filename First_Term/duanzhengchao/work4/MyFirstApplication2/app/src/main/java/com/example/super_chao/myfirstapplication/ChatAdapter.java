package com.example.super_chao.myfirstapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Super_chao on 2018/5/7.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Chat> mChatList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView chatImage;
        TextView chatName;
        TextView chatTime;
        TextView chatContent;

        public ViewHolder(View view) {
            super(view);
            chatImage = (ImageView) view.findViewById(R.id.chat_image);
            chatName = (TextView) view.findViewById(R.id.chat_name);
            chatTime= (TextView)view.findViewById(R.id.chat_time);
            chatContent=(TextView)view.findViewById(R.id.chat_content);
        }

    }

    public ChatAdapter(List<Chat> fruitList) {
        mChatList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_1_chat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat fruit = mChatList.get(position);
        holder.chatImage.setImageResource(fruit.getImageId());
        holder.chatName.setText(fruit.getName());
        holder.chatTime.setText(fruit.getTime());
        holder.chatContent.setText(fruit.getContent());
    }
    @Override
    public int getItemCount() {
        return mChatList.size();
    }
}

