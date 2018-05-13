package com.example.hp.homework_view;

import android.content.Context;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @date:2018/4/18
 * 我的RecyclerView适配器
 */
public class MyRecyAdapater extends RecyclerView.Adapter<MyRecyAdapater.ViewHodler>{

    private JsonBean jsonBean = null;

//    申明网址容器，图片的宽高容器
    private List<String>imagesId = new ArrayList<>();
    private List<Integer>imagesHeight = new ArrayList<>();
    private List<Integer>imagesWidth = new ArrayList<>();

//    屏幕的宽度
    private int windowWidth = 0;

    private Context context;

    /**
     * 包括imageview 的对象类
     */
    static class ViewHodler extends RecyclerView.ViewHolder{
        ImageView imageView;

        public ViewHodler(View view) {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.item_image);
        }
    }

    /**
     * 传入jsonbean对象、屏幕宽度、context，并且将网址、宽高放入容器
     * @param jsonBean
     * @param windowWidth
     * @param context
     */
    public MyRecyAdapater(JsonBean jsonBean, int windowWidth, Context context){
        this.jsonBean = jsonBean;
        this.windowWidth = windowWidth;
        this.context = context;

//        json的数据最后有一个空的data，所以要减一
        for(int i = 0;i < (jsonBean.getData().size()-1);i++){
            imagesId.add(jsonBean.getData().get(i).getShare_url());
            imagesHeight.add(jsonBean.getData().get(i).getImage_height());
            imagesWidth.add(jsonBean.getData().get(i).getImage_width());
        }
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent,int viewtype){

//        申明一个item对象
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent
                ,false);
        ViewHodler hodler = new ViewHodler(view);
        return hodler;
    }

    /**
     * 实现获取图片（以及缓存），修改图片展示的大小
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {

//        获取并且展示图片
        Glide.with(context).load(imagesId.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

//        改变图片展示的大小
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.imageView.getLayoutParams();
        params.width = 10*windowWidth / 30;

//        防止图片变形
        params.height = params.width*imagesHeight.get(position)/imagesWidth.get(position);
        holder.imageView.setLayoutParams(params);
    }

    /**
     * 防止加载错位
     * @param holder
     */
    @Override
    public void onViewRecycled(@NonNull ViewHodler holder) {
        if(holder != null){
            Glide.clear(holder.imageView);
        }
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount(){
        return imagesId.size();
    }

    /**
     * 在底部实现加载的功能
     * @param jsonBeanFooter
     */
    public void AddFooterItem(JsonBean jsonBeanFooter){
        List<String>imagesIdFooter = new ArrayList<>();
        jsonBean = jsonBeanFooter;
        for(int i = 0;i < 8;i++){
            imagesIdFooter.add(jsonBeanFooter.getData().get(i).getShare_url());
            imagesHeight.add(jsonBeanFooter.getData().get(i).getImage_height());
            imagesWidth.add(jsonBeanFooter.getData().get(i).getImage_width());

        }
//        导入网址的数组
        imagesId.addAll(0,imagesIdFooter);
        notifyDataSetChanged();
    }

    /**
     * 在顶部刷新，未将这个方法完成
     * @param jsonBeanHeader
     */
    public void AddHeaderItem(JsonBean jsonBeanHeader){
        List<String>imagesIdHeader = new ArrayList<>();
        jsonBean = jsonBeanHeader;
        for(int i = 0;i < 10;i++){
            imagesIdHeader.add(jsonBeanHeader.getData().get(i).getShare_url());

        }
        imagesId = imagesIdHeader;
        notifyDataSetChanged();
    }
}
