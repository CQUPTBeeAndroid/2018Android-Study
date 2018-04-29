package com.example.super_chao.mythirdwork_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Super_chao on 2018/4/29.
 */

public class AppAdapter extends ArrayAdapter<App> {
    private  int resourceId;
    public AppAdapter(Context context, int textViewResorceId, List<App>object){
        super(context,textViewResorceId,object);
        resourceId = textViewResorceId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        App app = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView appImage = (ImageView) view.findViewById(R.id.app_image);
        TextView appName = (TextView) view.findViewById(R.id.app_name);
        appImage.setImageResource(app.getImageId());
        appName.setText(app.getName());
        return view;
    }


}
