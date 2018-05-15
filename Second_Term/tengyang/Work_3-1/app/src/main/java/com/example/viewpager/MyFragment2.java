package com.example.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyFragment2 extends Fragment {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page2, null);
        view2();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void view2() {

        Fruit w = new Fruit("新的朋友", R.drawable.xin);
        fruitList.add(w);
        Fruit e = new Fruit("群聊", R.drawable.qun);
        fruitList.add(e);
        Fruit r = new Fruit("标签", R.drawable.biao);
        fruitList.add(r);
        Fruit t = new Fruit("公众号", R.drawable.gong);
        fruitList.add(t);
    }
}

