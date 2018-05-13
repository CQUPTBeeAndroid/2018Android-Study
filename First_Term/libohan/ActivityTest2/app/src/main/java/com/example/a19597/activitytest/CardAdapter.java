package com.example.a19597.activitytest;

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

public class CardAdapter extends ArrayAdapter<Card> {

    private int resourceId;

    public CardAdapter(Context context, int textViewResourceId, List<Card> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Card card = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else {
            view = convertView;
        }
        ImageView cardImage = (ImageView) view.findViewById(R.id.card_image);
        TextView cardName = (TextView) view.findViewById(R.id.card_name);
        cardImage.setImageResource(card.getImageId());
        cardName.setText(card.getName());
        return view;
    }
}
