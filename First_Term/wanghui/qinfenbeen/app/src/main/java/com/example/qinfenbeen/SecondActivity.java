package com.example.qinfenbeen;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {
    private Button b1;
    private List<Her> list =new ArrayList<>();
    private HerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1 =(Button)findViewById(R.id.button2);
        buttonnext buttonnext =new buttonnext();
        b1.setOnClickListener(buttonnext);
        initHer();
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        final GridLayoutManager layoutManager =new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HerAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new EndLessOnScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               Her eleven = new Her("Day11",R.mipmap.i11);
               Her twelve = new Her("Day12",R.mipmap.i12);
                Her thirteen = new Her("Day13",R.mipmap.i13);
                Her fourteen = new Her("Day14",R.mipmap.i14);
                Her fifiteen = new Her("Day15",R.mipmap.i15);
               list.add(0,eleven);
               list.add(1,twelve);
                list.add(2,thirteen);
                list.add(3,fourteen);
                list.add(4,fifiteen);
               swipeRefreshLayout.setRefreshing(false);
            }

    });


    }

    private void loadMoreData() {
        Her sixteen = new Her("Day16",R.mipmap.i16);
        Her seventeen = new Her("Day17",R.mipmap.i17);
        Her eighteen = new Her("Day18",R.mipmap.i18);
        Her nineteen = new Her("Day19",R.mipmap.i19);
        Her twenty = new Her("Day20",R.mipmap.i20);
        Her twentyone = new Her("Day21",R.mipmap.i21);
        Her twentytwo = new Her("Day22",R.mipmap.i22);
        list.add(sixteen);
        list.add(seventeen);
        list.add(eighteen);
        list.add(nineteen);
        list.add(twenty);
        list.add(twentyone);
        list.add(twentytwo);
        adapter.notifyDataSetChanged();
    }

    private void initHer(){
        for (int i=0;i<2;i++){
            Her one =new Her("Day1",R.mipmap.i1);
            list.add(one);
            Her two =new Her("Day2",R.mipmap.i2);
            list.add(two);
            Her three =new Her("Day3",R.mipmap.i3);
            list.add(three);
            Her four =new Her("Day4",R.mipmap.i4);
            list.add(four);
            Her five =new Her("Day5",R.mipmap.i5);
            list.add(five);
            Her six =new Her("Day6",R.mipmap.i6);
            list.add(six);
            Her seven =new Her("Day7",R.mipmap.i7);
            list.add(seven);
            Her eight =new Her("Day8",R.mipmap.i8);
            list.add(eight);
            Her nine =new Her("Day9",R.mipmap.i9);
            list.add(nine);
            Her ten =new Her("Day10",R.mipmap.i10);
            list.add(ten);
        }
    }
    class buttonnext implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent =new Intent();
            intent.setClass(SecondActivity.this,ThirdActivity.class);
            Bundle bundle = new Bundle();
            String str ="chuandi";
            bundle.putString("Data",str);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
