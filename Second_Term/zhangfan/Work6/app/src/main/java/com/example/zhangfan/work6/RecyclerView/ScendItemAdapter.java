package com.example.zhangfan.work6.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhangfan.work6.Activities.AllActivity;
import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.WebActivities.WebActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ScendItemAdapter extends RecyclerView.Adapter<ScendItemAdapter.ViewHolder>  {
private List<JsonHttp.Results> mAndroidItems;
private String url;



    public ScendItemAdapter(List<JsonHttp.Results> androidItemList){
        mAndroidItems = androidItemList;

    }


    @NonNull
    @Override
    public ScendItemAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.viewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",mAndroidItems.get(position).getUrl());
                parent.getContext().startActivities(new Intent[]{intent});
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScendItemAdapter.ViewHolder holder, int position) {
holder.writerText.setText(mAndroidItems.get(position).getWho());
holder.titleText.setText(mAndroidItems.get(position).getDesc());
holder.dataText.setText(mAndroidItems.get(position).getPublishedAt());

    }
    public void setNetworkBitmap(ImageView imageView,final String url) {
        final Bitmap[] bitmap = {null};
        Runnable networkImg = new Runnable() {
            @Override
            public void run() {
                try {
                    URL httpUrl = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                    conn.setConnectTimeout(8000);
                    conn.setDoInput(true);
                    conn.setUseCaches(false);
                    InputStream in = conn.getInputStream();
                    bitmap[0] = BitmapFactory.decodeStream(in);
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(networkImg).start();
        while(bitmap[0] == null)
            continue;
        imageView.setImageBitmap(bitmap[0]);
    }


    @Override
    public int getItemCount() {
        return mAndroidItems.size();
    }





   static class ViewHolder extends RecyclerView.ViewHolder
    {
        View viewItem;
        TextView titleText;
        TextView writerText;
        TextView dataText;
        ImageView imageView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            viewItem = itemView;
            titleText = itemView.findViewById(R.id.scend_item_title);
            writerText = itemView.findViewById(R.id.scend_item_writer);
            dataText = itemView.findViewById(R.id.scend_item_data);
            imageView = itemView.findViewById(R.id.scend_item_imageview);
        }
    }
}
