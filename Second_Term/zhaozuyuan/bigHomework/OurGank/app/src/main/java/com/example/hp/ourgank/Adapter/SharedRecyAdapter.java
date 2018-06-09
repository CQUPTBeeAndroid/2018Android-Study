package com.example.hp.ourgank.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.ourgank.Bean.SharedTextViewDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/7 23:48
 * @简述: 通用的一个RecyclerViewAdapter
 */
public class SharedRecyAdapter extends RecyclerView.Adapter<SharedRecyAdapter.SharedHolder> {

    List<SharedTextViewDataBean>strings = null;

    static int textId1,textId2;

    static int layoutId;

    private SetItemOnClickListener onClickListener = null;

    @NonNull
    @Override
    public SharedRecyAdapter.SharedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);
        SharedHolder holder = new SharedHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SharedHolder holder, final int position) {
        try {
            holder.textView1.setText(strings.get(position).getString1());
            holder.textView2.setText(strings.get(position).getString2());
        } catch (NullPointerException npe) {}

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return strings.size();
    }

     static class SharedHolder extends  RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;

        public SharedHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(textId1);
            textView2 = itemView.findViewById(textId2);
        }
    }

    public SharedRecyAdapter(int textViewId1,int textViewId2,int layoutId, List<SharedTextViewDataBean> strings) {
        this.strings = strings;
        this.textId1 = textViewId1;
        this.layoutId = layoutId;
        this.textId2 = textViewId2;
    }

    public void addTopData(List<SharedTextViewDataBean>strings){
        this.strings.addAll(0,strings);
        notifyDataSetChanged();
    }

    public void shuaXin(List<SharedTextViewDataBean>strings){
        this.strings = new ArrayList<>();
        this.strings = strings;
        notifyDataSetChanged();
    }

    public interface SetItemOnClickListener{
        void onClick(int position);
    }

    public void setOnClickListener(SetItemOnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}
