package com.example.zhangfan.work6.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.HttpUtil.HttpCallbackListener;
import com.example.zhangfan.work6.HttpUtil.HttpUtil;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.RecyclerView.AndroidItem;
import com.example.zhangfan.work6.RecyclerView.ContactsAdapter;
import com.example.zhangfan.work6.RecyclerView.GirlsAdapter;
import com.example.zhangfan.work6.RecyclerView.MyOkttp;
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

import static java.security.AccessController.getContext;

public class AllActivity extends AppCompatActivity {

  private ContactsAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private int page = 1;
    private int lastVisibleItem;
    private List<JsonHttp.Results> androidItems = new ArrayList<>();

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        okHttpSendRequest("http://gank.io/api/data/all/20/1");
        swipeRefreshLayout = findViewById(R.id.all_swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                okHttpSendRequest("http://gank.io/api/data/all/20/1");
            }
        });
         recyclerView = (RecyclerView) findViewById(R.id.all_recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Button backButton = findViewById(R.id.btn_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (AllActivity.this).finish();
            }
        });
        final Intent intent = getIntent();
        String tit = intent.getStringExtra("title");
        TextView title = findViewById(R.id.title_text);
        title.setText(tit);

        adapter = new ContactsAdapter(androidItems);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener1() {
            @Override
            public void onItemClick(View view, int position, String str) {
                Toast.makeText(AllActivity.this, "click" + str, Toast.LENGTH_SHORT).show();
//                WebActivity.actionStart(AllActivity.this, androidItems.get(position));
                Intent intent1 = new Intent(AllActivity.this,WebActivity.class);
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
                            inits(adapter.getItemCount());
                            Toast.makeText(AllActivity.this, "更新了10条数据...",
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

    private class GetData extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //设置swipeRefreshLayout为刷新状态
            swipeRefreshLayout.setRefreshing(true);
        }

        @Override
        protected String doInBackground(String... params) {

            return MyOkttp.get(params[0]);
        }
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



    private void urlHttpConnent(String address) {
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Gson gson = new Gson();
                JsonHttp jsonHttp = gson.fromJson(response, JsonHttp.class);
                List<JsonHttp.Results> results = jsonHttp.getResults();
                androidItems.addAll(results);
                showResponse();
            }

            @Override
            public void onError(Exception e) {

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
        String url = "http://gank.io/api/data/all/10/"+(position/10 +1);
        okHttpSendRequest(url);
    }
}


