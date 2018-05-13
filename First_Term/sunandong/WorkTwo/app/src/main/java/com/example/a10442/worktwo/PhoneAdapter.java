package com.example.a10442.worktwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by 10442 on 2018/4/26.
 */

public class PhoneAdapter extends ArrayAdapter<Phone> {
    private int resourceId;

    public PhoneAdapter(Context context, int textViewResourceId, List<Phone> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Phone phone = getItem(position);
        View view;
        if (convertView ==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }
        ImageView phoneImage = (ImageView) view.findViewById(R.id.image);
        TextView phoneName = (TextView) view.findViewById(R.id.name);
        phoneImage.setImageResource(phone.getImageId());
        phoneName.setText(phone.getName());
        return view;
    }
}
