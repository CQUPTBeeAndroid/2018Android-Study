package com.example.pengfeiteng.listview;

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

public class DogAdapter extends ArrayAdapter {
    private final int resourceId;

    public DogAdapter(Context context, int textViewResourceId, List<Dog> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Dog mdog = (Dog) getItem(position);
        View mview = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView dogImageView = (ImageView) mview.findViewById(R.id.dog_image);
        TextView dogTextView = (TextView)mview.findViewById(R.id.dog_name);
        dogImageView.setImageResource(mdog.getImageId());
        dogTextView.setText(mdog.getName());
        return mview;
    }
}
