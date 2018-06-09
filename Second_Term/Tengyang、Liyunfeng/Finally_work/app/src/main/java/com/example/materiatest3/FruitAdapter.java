package com.example.materiatest3;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private ArrayList<Fruit> mFruitList;
    private OnItemClickListener1 mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener1 onItemClickListener1) {
        this.mOnItemClickListener = onItemClickListener1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(ArrayList<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder1,final int position) {
        Fruit fruit = mFruitList.get(position);
        holder1.fruitImage.setImageResource(fruit.getImageId());
        holder1.fruitName.setText(fruit.getName());


        if (mOnItemClickListener != null) {
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position1 = holder1.getAdapterPosition();
                    Log.e("TAG", position1 + "");

                    mOnItemClickListener.onItemClick(holder1.itemView, position, "",position1);//这里的holder.itemView可以换成view

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
