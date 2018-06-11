package com.example.zhangfan.work6.RecyclerView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.WebActivities.WebActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 14512
 */

public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JsonHttp.Results> mAndroidItems;
    private ArrayList<AndroidItem> mAndroidItem;
    private OnItemClickListener1 mOnItemClickListener;

    private static int Main_Item=1;
    private int Last_Item_state = 100;

    public void setOnItemClickListener(OnItemClickListener1 onItemClickListener1) {
        this.mOnItemClickListener = onItemClickListener1;
    }

    public ContactsAdapter(List<JsonHttp.Results> contacts) {
        this.mAndroidItems = contacts;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Last_Item_state) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_footer_view, parent, false);
            return new LastViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.type_item, parent, false);
            return new ContactViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LastViewHolder) {
            ((LastViewHolder) holder).tvBottom.setText("上拉加载更多...");

        } else {
            final ContactViewHolder holder1 = (ContactViewHolder) holder;
            final JsonHttp.Results contact = mAndroidItems.get(position);
            holder1.titleText.setText(mAndroidItems.get(position).getDesc());
            holder1.writerText.setText(mAndroidItems.get(position).getWho());
            holder1.dataText.setText(mAndroidItems.get(position).getPublishedAt());
            //如果设置了回调，则设置点击事件
            if (mOnItemClickListener != null) {
                holder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position  = holder1.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder1.itemView, position,
                                contact.getDesc());
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return mAndroidItems.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return Last_Item_state;
        }else {
            return Main_Item;
        }
    }

    public void swipeAddData(List<JsonHttp.Results> addData) {
       mAndroidItems.addAll(0, addData);
       notifyDataSetChanged();
    }

    public void upAddData(List<JsonHttp.Results>addData) {
        mAndroidItems.addAll(addData);
        notifyDataSetChanged();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView titleText;
        TextView writerText;
        TextView dataText;
        ImageView imageView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            titleText = itemView.findViewById(R.id.scend_item_title);
            writerText = itemView.findViewById(R.id.scend_item_writer);
            dataText = itemView.findViewById(R.id.scend_item_data);
            imageView = itemView.findViewById(R.id.scend_item_imageview);
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
