package com.example.administrator.list_recycleview;

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

public class MyListViewAdapt extends ArrayAdapter<Item> {
    private int resourceId;

    public MyListViewAdapt(@NonNull Context context, int resource, @NonNull List<Item> mlist) {
        super(context, resource, mlist);
        this.resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item item=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView) view.findViewById(R.id.textView);
            viewHolder.imageView=(ImageView)view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();

        }
        viewHolder.imageView.setImageResource(item.getImage());
        viewHolder.textView.setText(item.getTextView());
        return view;
    }


    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
