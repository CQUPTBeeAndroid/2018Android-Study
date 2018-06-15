package com.example.zhangfan.work6.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.Gson.NewsJsonBean;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.WebActivities.WebActivity;

import java.util.List;

/**
 * Created by Super_chao on 2018/6/6.
 */

public class NewsAdapter extends ArrayAdapter<NewsBean> {

    private int resourceID;

    public NewsAdapter(Context context, int textViewResourceID, List<NewsBean> objects){
        super(context,textViewResourceID,objects);
        resourceID=textViewResourceID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        NewsBean newsBean = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        // ImageView imageView = (ImageView)view.findViewById(R.id.iv_icon);
        TextView textView=(TextView)view.findViewById(R.id.tv_title);
        TextView textView1=(TextView)view.findViewById(R.id.tv_content);
        TextView textView2 = (TextView)view.findViewById(R.id.tv_time);
        textView.setText(newsBean.getNewsTitle());
        textView1.setText(newsBean.getNewsContent());
        textView2.setText(newsBean.getNewsTime());

        return view;
    }
}
