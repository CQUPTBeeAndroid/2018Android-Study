package com.example.super_chao.myfirstapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    public Fragment2() {
        // Required empty public constructor
    }

    private List<People> peopleList = new ArrayList<People>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        initPeoples();
        PeopleAdapter adapter = new PeopleAdapter(getActivity(), R.layout.fragment_2_people, peopleList);
        ListView listView = (ListView) view.findViewById(R.id.list_view2);
        listView.setAdapter(adapter);
        return view;
    }

    private void initPeoples() {
        People title1 = new People("新的朋友",R.drawable.banana_pic);
        peopleList.add(title1);
        People title2 = new People("群聊",R.drawable.strawberry_pic);
        peopleList.add(title2);
        People title3 = new People("标签",R.drawable.pear_pic);
        peopleList.add(title3);
        People title4 = new People("公众号",R.drawable.mango_pic);
        peopleList.add(title4);
        for (int i = 1; i < 20; i++) {
            People apple = new People("联系人"+i, R.drawable.apple_pic);
            peopleList.add(apple);
        }

    }
}