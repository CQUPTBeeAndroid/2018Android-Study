package com.example.super_chao.mythridwork_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder>{

    private List<App> mAppList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View appView;
        ImageView appImage;
        TextView appName;

        public ViewHolder(View view) {
            super(view);
            appView = view;
            appImage = (ImageView) view.findViewById(R.id.app_image);
            appName = (TextView) view.findViewById(R.id.app_name);
        }
    }

    public AppAdapter(List<App> fruitList) {
        super();
        mAppList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.appView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                App fruit = mAppList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.appImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
               App fruit = mAppList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        App fruit = mAppList.get(position);
        holder.appImage.setImageResource(fruit.getImageId());
        holder.appName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mAppList.size();
    }

}