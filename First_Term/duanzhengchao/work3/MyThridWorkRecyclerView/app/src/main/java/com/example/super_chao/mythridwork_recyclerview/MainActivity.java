package com.example.super_chao.mythridwork_recyclerview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<App> appList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApps(); // 初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AppAdapter adapter = new AppAdapter(appList);
        recyclerView.setAdapter(adapter);





        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });

    }
    private  void  refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initApps();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


    private void initApps() {
        for (int i = 0; i < 5; i++) {
            App ecilipse = new App("ecilipse", R.drawable.ecilipse);
            appList.add(ecilipse);
            App qq = new App("qq", R.drawable.qq);
            appList.add(qq);
            App android = new App("android", R.drawable.android);
            appList.add(android);

        }
    }

}