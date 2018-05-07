package com.example.hp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHodler> {

    private List<Integer>mList;

    static class ViewHodler extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHodler(View view) {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.item_image);
        }
    }

    public MyAdapter(List<Integer> imageId){
        this.mList = imageId;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent,int viewtype){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent
                ,false);
        ViewHodler hodler = new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.imageView.setImageResource(mList.get(position));
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) holder.imageView
                .getLayoutParams();         //制作image的参数布局
        params.height = 232;
        holder.imageView.setLayoutParams(params);
    }

    @Override
    public int getItemCount(){
        return mList.size();
    }

}
