package com.example.administrator.mywork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyListViewAdapter extends ArrayAdapter<PeopleList> {
    private int resourceID;
    public MyListViewAdapter(@NonNull Context context, int resource, @NonNull List<PeopleList> peopleLists) {
        super(context, resource,  peopleLists);
        this.resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PeopleList peopleList=getItem(position);
        View view;
        final ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.peoplename=(TextView) view.findViewById(R.id.peoplename);
            viewHolder.peoplepic=(ImageView)view.findViewById(R.id.peoplepic);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }

        viewHolder.peoplepic.setImageResource(peopleList.getPeoplepics());
        viewHolder.peoplename.setText(peopleList.getPeopleName());
        return view;
    }
    class ViewHolder{
        ImageView peoplepic;
        TextView peoplename;

    }
}
