package com.example.hp.homework_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * ListView的适配器，包括图片、标题、内容
 * Created by hp on 2018/4/18.
 */

public class MyListAdapater extends BaseAdapter{

//    标题、文本、图片的id
    private String[] titles = null;
    private String[] texts = null;
    private int[] imageIds = null;

    private int windowHeight = 0;       //手机高度默认数值为0，用于改变照片的大小。
    private Context context ;

//    构造方法分别传入标题、内容、手机的高度、照片的地址、当前活动的上下文
    MyListAdapater(String[] titles,String[] texts,int windowHeight,int[] imageIds,Context context){
        this.titles = titles;
        this.context = context;
        this.texts = texts;
        this.windowHeight = windowHeight;
        this.imageIds = imageIds;
    }

    @Override
    public Object getItem(int i) {
        return titles.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return titles == null ? 0:titles.length;        //若数组读取失败，则记为0
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;       //申明一个持有者

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item,viewGroup
                    ,false);        //对这个布局进行实例赋值

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.color_image);
            viewHolder.title = (TextView)view.findViewById(R.id.color_title);
            viewHolder.text = (TextView)view.findViewById(R.id.color_text);
            view.setTag(viewHolder);        //标记当前的item
        }else {
            viewHolder = (ViewHolder) view.getTag();        //得到当前触动的item
        }

        setItemData(viewHolder,i);      //实现对数据的传入

        return view;
    }

//    将数据放入，并在前三个单独赋予值
    private void setItemData(ViewHolder viewHolder,int i){

        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) viewHolder.imageView
                .getLayoutParams();         //制作image的参数布局
        params.width = windowHeight /10 ;

        if(i <= 2) {
            viewHolder.title.setText(titles[i]);
            viewHolder.text.setText(texts[i]);
            viewHolder.imageView.setImageResource(imageIds[i]);

            viewHolder.imageView.setLayoutParams(params);
        }else {
            viewHolder.title.setText(null);             //可以传入空，即相当于未赋值
            viewHolder.text.setText(null);
            viewHolder.imageView.setImageResource(R.drawable.image);

            viewHolder.imageView.setLayoutParams(params);
        }
    }

    /**
     * 实现三个对象的控件持有者
     */
    public static class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView text;
    }

}
