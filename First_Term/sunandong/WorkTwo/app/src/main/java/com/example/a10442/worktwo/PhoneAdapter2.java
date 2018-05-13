package com.example.a10442.worktwo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 10442 on 2018/4/27.
 */

public class PhoneAdapter2 extends RecyclerView.Adapter<PhoneAdapter2.ViewHolder>{
    private List<Phone> mPhoneList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View phoneView;
        ImageView phoneImage;
        TextView phoneName;
        public ViewHolder(View view){
            super(view);
            phoneView = view;
            phoneImage = (ImageView) view.findViewById(R.id.image);
            phoneName = (TextView)view.findViewById(R.id.name);
        }
    }
    public PhoneAdapter2(List<Phone>phoneList){
        mPhoneList = phoneList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Phone phone = mPhoneList.get(position);
                Toast.makeText(v.getContext(),"you clicked view"+phone.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Phone phone = mPhoneList.get(position);
                Toast.makeText(v.getContext(),"you clicked view"+phone.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int position){
        Phone phone = mPhoneList.get(position);
        holder.phoneImage.setImageResource(phone.getImageId());
        holder.phoneName.setText(phone.getName());
    }
    public int getItemCount(){
        return mPhoneList.size();
    }
}
