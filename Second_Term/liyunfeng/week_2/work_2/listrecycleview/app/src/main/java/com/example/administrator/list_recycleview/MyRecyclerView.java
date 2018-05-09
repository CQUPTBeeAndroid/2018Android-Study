package com.example.administrator.list_recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerView extends AppCompatActivity{
    private List<Item> mlist=new ArrayList<>();
    private int num=0;
    private int num1=0;
    private int LastVisibleItem=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);
        init();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.RecyclerView);
        final LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(mlist);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        final SwipeRefreshLayout swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.RecyclerViewSwip);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState==RecyclerView.SCROLL_STATE_IDLE){
                    if (LastVisibleItem==adapter.getItemCount()-1){
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    Thread.sleep(1000);
                                }catch (Exception e){
                                    e.printStackTrace();

                                }runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        for (int i=0;i<2;i++){
                                            Item item1=new Item();
                                            item1.setImage(R.drawable.ic_launcher_background);
                                            item1.setTextView("加载数据第"+num1+"条");
                                            mlist.add(item1);
                                            num1++;
                                        }
                                        adapter.notifyDataSetChanged();
                                    }
                                });
                            }
                        }).start();
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LastVisibleItem=layoutManager.findLastVisibleItemPosition();
            }
        });
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark
                                                    ,R.color.colorPrimary
                                                    ,R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                                e.printStackTrace();
                        }runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i=0;i<2;i++){
                                    Item item2=new Item();
                                    item2.setImage(R.drawable.ic_launcher_background);
                                    item2.setTextView("刷新数据第"+num+"条");
                                    mlist.add(0,item2);
                                    num++;
                                }
                                adapter.notifyDataSetChanged();
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });
    }

    public void init(){
        for (int i=0;i<2;i++){
            Item item3=new Item();
            item3.setImage(R.drawable.ic_launcher_background);
            item3.setTextView("原数据");
            mlist.add(item3);
        }

    }
}
