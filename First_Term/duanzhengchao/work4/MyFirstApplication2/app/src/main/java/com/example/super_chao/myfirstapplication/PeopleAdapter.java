package com.example.super_chao.myfirstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Super_chao on 2018/5/6.
 */

public class PeopleAdapter extends ArrayAdapter<People> {
    private int resourceId;

    public  PeopleAdapter(Context context, int textViewResourceId, List<People> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        People people = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView peopleImage = (ImageView)view.findViewById(R.id.fruit_image);
        TextView peopleName = (TextView)view.findViewById(R.id.fruit_name);
        peopleImage.setImageResource(people.getImageId());
        peopleName.setText(people.getName());
        return  view;
    }
}
