package com.example.administrator.list_recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{
        private List<Item> mlist;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item,parent,false);
            ViewHolder holder=new ViewHolder(view);
            return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item=mlist.get(position);
        holder.textView.setText(item.getTextView());
        holder.imageView.setImageResource(item.getImage());
}


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public   MyRecyclerViewAdapter(List<Item> mlist){
        this.mlist=mlist;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            textView=(TextView)itemView.findViewById(R.id.textView);
        }
    }
    private AdapterView.OnItemClickListener mOnItemClickListener;//声明接口
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
