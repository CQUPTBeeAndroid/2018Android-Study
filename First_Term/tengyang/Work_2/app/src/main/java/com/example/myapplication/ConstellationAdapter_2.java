package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ConstellationAdapter_2 extends RecyclerView.Adapter<ConstellationAdapter_2.ViewHolder> {
    private List<Constellation_2> mConstellationList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView constellationImage;
        TextView constellationName;
        View constellationView;

        public ViewHolder(View view) {
            super(view);
            constellationView=view;
            constellationImage = (ImageView) view.findViewById(R.id.fruit_image);
            constellationName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public ConstellationAdapter_2(List<Constellation_2> constellationList) {
        mConstellationList = constellationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);

        final ViewHolder holder=new ViewHolder(view);
        holder.constellationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Constellation_2 constellation_2=mConstellationList.get(position);;
                Toast.makeText(v.getContext(), ""+constellation_2.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.constellationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Constellation_2 constellation_2=mConstellationList.get(position);
                Toast.makeText(v.getContext(), ""+constellation_2.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Constellation_2 con = mConstellationList.get(position);
        holder.constellationImage.setImageResource(con.getImageId());
        holder.constellationName.setText(con.getName());
    }

    @Override
    public int getItemCount() {
        return mConstellationList.size();
    }

}