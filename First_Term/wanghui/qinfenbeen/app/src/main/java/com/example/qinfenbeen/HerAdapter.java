package com.example.qinfenbeen;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 王辉 on 2018/4/22.
 */

public class HerAdapter extends RecyclerView.Adapter<HerAdapter.ViewHolder> {
    private List<Her>  herlist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView herimage;
        TextView herday;
        public ViewHolder(View view){
            super(view);
            herimage=(ImageView)view.findViewById(R.id.her_image);
            herday=(TextView) view.findViewById(R.id.her_day);
        }
    }
    public HerAdapter (List<Her> herlist){
        this.herlist = herlist;
    }
    public HerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.her,parent,false);
        final ViewHolder holder =new ViewHolder(view);
        holder.herimage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                int postion =holder.getAdapterPosition();
                Her her =herlist.get(postion);
                Toast.makeText(view.getContext(),"我和她的"+her.getDay(),0).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(HerAdapter.ViewHolder holder, int position) {
        Her her =herlist.get(position);
        holder.herimage.setImageResource(her.getImageId());
        holder.herday.setText(her.getDay());
    }

    @Override
    public int getItemCount() {
        return herlist.size();
    }
}
