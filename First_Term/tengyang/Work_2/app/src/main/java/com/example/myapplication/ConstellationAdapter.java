package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ConstellationAdapter extends ArrayAdapter<Constellation> {
    private int resourceId;

    public ConstellationAdapter(Context context, int textViewResourceId,
                                List<Constellation> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Constellation fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.constellationImage=(ImageView)view.findViewById(R.id.constellation_image);
            viewHolder.constellationName=(TextView)view.findViewById(R.id.constellation_name);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.constellationImage.setImageResource(fruit.getImageId());
        viewHolder.constellationName.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView constellationImage;
        TextView constellationName;
    }
}
