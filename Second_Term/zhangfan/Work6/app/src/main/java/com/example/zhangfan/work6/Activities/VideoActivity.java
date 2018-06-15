package com.example.zhangfan.work6.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.HttpUtil.HttpUtil;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.RecyclerView.ContactsAdapter;
import com.example.zhangfan.work6.RecyclerView.OnItemClickListener1;
import com.example.zhangfan.work6.RecyclerView.ScendItemAdapter;
import com.example.zhangfan.work6.WebActivities.WebActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class VideoActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private int lastVisibleItem;
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private List<JsonHttp.Results> androidItems = new ArrayList<>();
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Button backButton = findViewById(R.id.btn_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (VideoActivity.this).finish();
            }
        });
        Intent intent = getIntent();
        String tit = intent.getStringExtra("title");
        TextView title = findViewById(R.id.title_text);
        title.setText(tit);

        swipeRefreshLayout = findViewById(R.id.video_swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                okHttpSendRequest("http://gank.io/api/data/休息视频/20/1");
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.scend_video_recyclerview);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ContactsAdapter(androidItems);
        okHttpSendRequest("http://gank.io/api/data/休息视频/20/1");
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener1() {
            @Override
            public void onItemClick(View view, int position, String str) {
                Toast.makeText(VideoActivity.this, "click" + str, Toast.LENGTH_SHORT).show();
//                WebActivity.actionStart(AllActivity.this, androidItems.get(position));
                Intent intent1 = new Intent(VideoActivity.this,WebActivity.class);
                intent1.putExtra("itemurl",androidItems.get(position).getUrl());
                startActivity(intent1);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==
                        adapter.getItemCount()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //把要刷新的实例化
                            inits(adapter.getItemCount());
                            Toast.makeText(VideoActivity.this, "更新了10条数据...",
                                    Toast.LENGTH_SHORT).show();
                        }
                    },1000);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //找到最后一个的位置
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });

    }

    private void showResponse() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void okHttpSendRequest(String address) {
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                JsonHttp jsonHttp = gson.fromJson(responseData, JsonHttp.class);
                List<JsonHttp.Results> results = jsonHttp.getResults();
                androidItems.addAll(results);
                showResponse();
            }
        });
    }
    private void inits(int position){
        String url = "http://gank.io/api/data/休息视频/10/"+(position/10 +1);
        okHttpSendRequest(url);
    }
}
