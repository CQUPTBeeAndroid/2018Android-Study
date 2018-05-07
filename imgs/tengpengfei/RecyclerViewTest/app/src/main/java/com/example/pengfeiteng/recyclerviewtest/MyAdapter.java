package com.example.pengfeiteng.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Data> mData;
    private OnItemClickListener mOnItemClickListener;

    private static int MAIN_ITEM = 1;
    private int Last_Item_state = 100;

    public void setmOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public MyAdapter(ArrayList<Data> datas) {
        this.mData = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Last_Item_state) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.footview, parent, false);
            return new LastViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview, parent, false);
            return new DataViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LastViewHolder) {
            ((LastViewHolder) holder).tvBottom.setText("上拉加载更多...");

        } else {
            final DataViewHolder holder1 = (DataViewHolder) holder;
            final Data contact = mData.get(position);
            holder1.mImageView.setImageResource(contact.getImageID());
            holder1.mTextView.setText(contact.getName());

            //如果设置了回调，则设置点击事件
            if (mOnItemClickListener != null) {
                holder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position  = holder1.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder1.itemView, position,
                                contact.getName());
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return Last_Item_state;
        }else {
            return MAIN_ITEM;
        }
    }


    public void swipeAddData(ArrayList<Data> addData) {
        mData.addAll(0, addData);
        notifyDataSetChanged();
    }

    public void upAddData(ArrayList<Data> addData) {
        mData.addAll(addData);
        notifyDataSetChanged();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        View mView;
        ImageView mImageView;
        TextView mTextView;

        public DataViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = itemView.findViewById(R.id.imgPortrait);
            mTextView = itemView.findViewById(R.id.tvName);
        }
    }


    public class LastViewHolder extends RecyclerView.ViewHolder {
        TextView tvBottom;
        ProgressBar mProgressBar;
        public LastViewHolder(View itemView) {
            super(itemView);
            mProgressBar = itemView.findViewById(R.id.progressbar);
            tvBottom = itemView.findViewById(R.id.tvBottom);
        }
    }
}
