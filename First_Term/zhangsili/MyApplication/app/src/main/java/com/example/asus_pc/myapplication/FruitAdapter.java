package com.example.asus_pc.myapplication;

/**
 * Created by asus-pc on 2018/5/2.
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit Fruit = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);

        } else {
            view = convertView;
        }
        ImageView FruitImage = (ImageView) view.findViewById(R.id.Fruit_image);
        TextView FruitName = (TextView) view.findViewById(R.id.Fruit_name);
        FruitImage.setImageResource(Fruit.getImageId());
        FruitName.setText(Fruit.getName());
        return view;

    }
}



