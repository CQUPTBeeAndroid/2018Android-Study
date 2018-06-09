package com.example.materiatest3;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 滕扬 on 2018/5/29.
 */

public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.ViewHolder> {
    private Context mContext;
    private List<Meizi>mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView meiziImage;
        TextView meiziName;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            meiziName=(TextView)view.findViewById(R.id.meizi_name);
            meiziImage=(ImageView)view.findViewById(R.id.meizi_image);
        }
    }
    public MeiziAdapter(List<Meizi>mz){
        mList=mz;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.meizi,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Meizi meizi=mList.get(position);
        holder.meiziName.setText(meizi.getName());
        Glide.with(mContext).load(meizi.getImageId()).into(holder.meiziImage);
    }
    @Override
    public int getItemCount(){
        return mList.size();
    }
}
