package com.ebaryice.basicrecyclerview.ui;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ebaryice.basicrecyclerview.R;
import com.ebaryice.basicrecyclerview.adapter.MyRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    SwipeRefreshLayout refreshLayout;
    RecyclerView recyclerView;
    MyRecycleAdapter adapter;
    LinearLayoutManager manager;
    List<String> datas;
    private int lastVisibleItemPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        recyclerView = findViewById(R.id.recyclerView);
        init();
    }

    private void init() {
        datas = new ArrayList<>();
        for (int i = 1; i <= 200; i++){
            datas.add(""+i);
        }
        adapter = new MyRecycleAdapter(this,datas);
        adapter.setOpenItemAnimationEnable(true);
        adapter.setItemAnimationDuration(500);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == adapter.getItemCount()){
                    adapter.changeLoadMoreStatus(MyRecycleAdapter.LOADING_MORE);
                    loadMoreData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = manager.findLastVisibleItemPosition();
            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //do something
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void loadMoreData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> loadMoreData = new ArrayList<>();
                for (int i = 1;i < 200; i++){
                    loadMoreData.add(""+i);
                }
                adapter.addMoreItem(loadMoreData);
                adapter.changeLoadMoreStatus(MyRecycleAdapter.SHOW_FOOTER);
            }
        },2000);
    }
}
