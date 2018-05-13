package com.example.administrator.mywork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyFragment1 extends Fragment{
    private List<PeopleList> peopleLists=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pager1,null);
        getpeople();
        MyListViewAdapter myListViewAdapter=new MyListViewAdapter(view.getContext(),R.layout.people_item,peopleLists);
        ListView listView=(ListView)view.findViewById(R.id.MyLiseView);
        listView.setAdapter(myListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PeopleList peopleList=peopleLists.get(position);
                String name=peopleList.getPeopleName();
                Intent intent=new Intent(getContext(),ChatActivity.class);
                intent.putExtra(name,"name");
                startActivity(intent);
            }
        });
        return view;

    }
    private List<PeopleList> getpeople() {
        for (int i=1;i<=20;i++){

            PeopleList peopleList=new PeopleList();
            peopleList.setPeopleName("联系人"+i);
            peopleList.setPeoplepics(R.drawable.taibeimor);
            peopleLists.add(peopleList);
        }
        return peopleLists;
    }
}

