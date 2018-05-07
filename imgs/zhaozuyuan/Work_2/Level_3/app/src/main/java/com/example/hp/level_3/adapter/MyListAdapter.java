package com.example.hp.level_3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.level_3.R;
import com.example.hp.level_3.fragment.ContactFragment;

import java.util.ArrayList;

/**
 * ListView适配器
 */
public class MyListAdapter extends BaseAdapter {

    private ArrayList<ContactFragment.Person> people;

    private Context context;

    public MyListAdapter(ArrayList<ContactFragment.Person> people,Context context){
        this.people = people;
        this.context =  context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DataHolder dataHolder = null;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup
                    ,false);

            dataHolder = new DataHolder();

            dataHolder.name = (TextView)view.findViewById(R.id.item_people_name);
            dataHolder.num = (TextView)view.findViewById(R.id.item_people_number);

            view.setTag(dataHolder);
        }else {
            dataHolder = (DataHolder) view.getTag();
        }

        dataHolder.name.setText(people.get(i).getName());
        dataHolder.num.setText("电话:"+people.get(i).getPhoneNumb());

        return view;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return people.get(i);
    }

    @Override
    public int getCount() {
        return people == null ? 0:people.size();
    }

    public static class DataHolder{
        TextView name;
        TextView num;
    }
}
