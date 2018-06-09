package com.example.hp.ourgank.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.ourgank.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/7 0:12
 * @简述:  福利碎片的recyclerciew的adapter
 */
public class WelFareRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> images;

    private Activity context = null;

    private int width,height;

    private static final int LASTITEM = 1;      //最后一个item标志
    private static final int MAINITEM = 0;      //之前的额item标志

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == MAINITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.welfare_recy_item
                    , parent, false);
            return new MainViewHolder(view);
        }else {
            View lastView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weifare_bottom_bar
                    , parent, false);
            return new LastViewHolder(lastView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder h, int position) {
        if(h instanceof LastViewHolder){
            ((LastViewHolder) h).textView.setText("上拉加载更多...");
        }else {
            MainViewHolder holder = (MainViewHolder)h;

            holder.imageView.setImageResource(R.drawable.white);      //占位

            Picasso.with(context)
                    .load(images.get(position))
                    //.networkPolicy(NetworkPolicy.NO_CACHE,NetworkPolicy.NO_STORE)    //不进行文件存储与读取
                    .resize(width,height)                   //设置宽高，瀑布流不设置宽高会崩
                    .centerCrop()                           //图片填充方式
                    .placeholder(R.drawable.jiazai)         //加载时显示的图片
                    .error(R.drawable.fail)                 //下载失败显示的图片
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return images.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()){
            return LASTITEM;
        }else {
            return MAINITEM;
        }
    }

    public WelFareRecyAdapter(List<String>images,Activity context){
        this.images = images;
        this.context = context;

        WindowManager manager = context.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);

        width = (int)outMetrics.widthPixels/2;
        height = width*1327/1024;
    }

     public static class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MainViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.welfare_item_image);
        }
    }

    public static class LastViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public LastViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.welfare_bottom_text);
        }
    }

    public void bottomAddData(List<String>list){
        images.addAll(list);
        notifyDataSetChanged();
    }

    public void topAddData(List<String>list){
        images.addAll(0,list);
        notifyDataSetChanged();
    }
}
