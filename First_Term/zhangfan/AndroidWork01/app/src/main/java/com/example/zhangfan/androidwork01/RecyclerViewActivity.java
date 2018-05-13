package com.example.zhangfan.androidwork01;

import android.annotation.SuppressLint;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private DrawerLayout mDrawerLayout;
    private FruitRecyclerViewAdapter recyclerViewAdapter;
    private List<Fruit> fruitList = new ArrayList<>();
    private Fruit[] fruits={
            new Fruit("苹果",R.drawable.apple),
            new Fruit("香蕉", R.drawable.banana),
            new Fruit("橘子", R.drawable.orange),
            new Fruit("西瓜", R.drawable.watermlon),
            new Fruit("梨子", R.drawable.pear),
            new Fruit("葡萄", R.drawable.grape),
            new Fruit("菠萝", R.drawable.pineapple),
            new Fruit("草莓", R.drawable.strawberry),
            new Fruit("樱桃", R.drawable.cherry),
            new Fruit("樱桃", R.drawable.cherry)
    };
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initfruits();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new FruitRecyclerViewAdapter(fruitList);
        recyclerView.setAdapter(recyclerViewAdapter);
        swipeRefreshLayout =(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });


    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
          try {
              Thread.sleep(2000);
          }catch (InterruptedException e){
              e.printStackTrace();
          }
          runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  initfruits();
                  recyclerViewAdapter.notifyDataSetChanged();
                  swipeRefreshLayout.setRefreshing(false);
              }
          });
            }
        }).start();
    }

    private void initfruits() {
        fruitList.clear();
        for (int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }

}
