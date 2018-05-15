package com.example.pengfeiteng.recyclerviewtest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Data> mData = new ArrayList<>();
    private ArrayList<Data> mAddMoreData;
    private int lastVisibleItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    private void getData() {
        initDatas(15);
        adapter = new MyAdapter(mData);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //上拉
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem +1 == adapter.getItemCount()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initDatas(3);
                            adapter.upAddData(mAddMoreData);
                            Toast.makeText(MainActivity.this,"加载了三条数据....",Toast.LENGTH_SHORT).show();
                        }
                    },1000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });


        adapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String str) {
                Toast.makeText(MainActivity.this,"你点击了" + str,Toast.LENGTH_SHORT).show();
                Detail.startAction(MainActivity.this,mData.get(position));
            }
        });


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initDatas(4);
                        adapter.swipeAddData(mAddMoreData);
                        Toast.makeText(MainActivity.this,"更新了四条数据",Toast.LENGTH_SHORT).show();
                    }
                },1000);

                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }


    @SuppressLint("ResourceAsColor")
    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshView);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));

        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent);
    }

    private void initDatas(int n) {
        mAddMoreData = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n ==4){
                Data data = new Data(i + "这是上拉刷新的数据",R.mipmap.ic_launcher,"内容：" + i + "这是上拉刷新的数据");
                mAddMoreData.add(data);
            }else if (n ==3){
                Data data = new Data(i + "这是下拉刷新的数据",R.mipmap.ic_launcher,"内容：" + i + "这是下拉刷新的数据");
                mAddMoreData.add(data);
            }else {
                Data data = new Data("这是普通数据" + i, R.mipmap.ic_launcher_round,
                        "  content:" + i + "这是普通数据");
                mData.add(data);
            }
        }
    }

}
