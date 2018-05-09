package com.example.administrator.signin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<UserInfo> {
    private int resourceID;
    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<UserInfo> objects) {
        super(context, resource, objects);
        this.resourceID=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserInfo userInfo=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.listviewitem,null);
            viewHolder=new ViewHolder();
            viewHolder.name=(TextView)view.findViewById(R.id.name);
            viewHolder.password=(TextView)view.findViewById(R.id.password);
            view.getTag();
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.password.setText(userInfo.getPassword());
        viewHolder.name.setText(userInfo.getName());
        return view;
    }
    class ViewHolder{
        TextView name;
        TextView password;
    }
}
