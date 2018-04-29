package com.example.super_chao.mythirdwork_listview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
        initApps();
        AppAdapter adapter = new AppAdapter(MainActivity.this,R.layout.app_item,appList);
        ListView listView = (ListView)findViewById(R.id.List_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                App app = appList.get(position);
                Toast.makeText(MainActivity.this,app.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.Swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshApps();
            }
        });
    }
    private  void  refreshApps(){
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
                        initApps();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
    private void initApps() {
        for (int i = 0; i < 4; i++) {
            App ecilipse = new App("ecilipse", R.drawable.ecilipse);
            appList.add(ecilipse);
            App qq = new App("qq", R.drawable.qq);
            appList.add(qq);
            App android = new App("android", R.drawable.android);
            appList.add(android);

        }
    }
}
