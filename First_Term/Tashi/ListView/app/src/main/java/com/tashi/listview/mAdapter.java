package com.tashi.listview;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mAdapter extends RecyclerView.Adapter<mAdapter.mViewHolder>{
   private ArrayList<Integer> image;
   private ArrayList<String> texts;
  public  mAdapter(ArrayList<Integer> images,ArrayList<String> texts)
  {
      this.image = images;
      this.texts = texts;
  }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        CardView cardView = view.findViewById(R.id.item_view);
        cardView.setCardElevation(5);
        cardView.setCardBackgroundColor(view.getResources().getColor(R.color.colorAccent));
        return new mViewHolder(view);
  }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.imageView.setImageResource(image.get(position));
        holder.content.setText(texts.get(position));
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder{
      View mView = itemView;
     private TextView content ;
     private ImageView imageView;
        private mViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            content=itemView.findViewById(R.id.text);
        }
    }
}

