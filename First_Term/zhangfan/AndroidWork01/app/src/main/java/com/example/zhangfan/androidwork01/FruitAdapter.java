package com.example.zhangfan.androidwork01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourseId;

    public FruitAdapter( Context context, int textViewResourceId,  List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourseId= textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView,  ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        ImageView fruitImage =(ImageView)view.findViewById(R.id.fruit_image);
        TextView fruitNmae = (TextView)view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitNmae.setText(fruit.getName());
        return  view;
    }


    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
