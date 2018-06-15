package com.example.zhangfan.work6.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.HttpUtil.HttpCallbackListener;
import com.example.zhangfan.work6.HttpUtil.HttpUtil;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.RecyclerView.ContactsAdapter;
import com.example.zhangfan.work6.RecyclerView.Girls;
import com.example.zhangfan.work6.RecyclerView.GirlsAdapter;
import com.example.zhangfan.work6.RecyclerView.MyOkttp;
import com.example.zhangfan.work6.RecyclerView.OnItemClickListener1;
import com.example.zhangfan.work6.RecyclerView.ScendItemAdapter;
import com.example.zhangfan.work6.RecyclerView.SnackbarUtil;
import com.example.zhangfan.work6.WebActivities.WebActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WelFareActivity extends AppCompatActivity {

    private static RecyclerView recyclerview;
    private CoordinatorLayout coordinatorLayout;
    private GirlsAdapter mAdapter;
    private List<Girls> meizis;
    private List<JsonHttp.Results> androidItems = new ArrayList<>();
    private GridLayoutManager mLayoutManager;
    private int lastVisibleItem ;
    private ContactsAdapter adapter;
    private int page=1;
    private ItemTouchHelper itemTouchHelper;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_fare);
        Button backButton = findViewById(R.id.btn_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (WelFareActivity.this).finish();
            }
        });
        Intent intent = getIntent();
        String tit = intent.getStringExtra("title");
        TextView title = findViewById(R.id.title_text);
        title.setText(tit);

        okHttpSendRequest("http://gank.io/api/data/福利/20/1");
        swipeRefreshLayout = findViewById(R.id.welfare_swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                okHttpSendRequest("http://gank.io/api/data/福利/20/1");
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.scend_welfare_recyclerview);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new ContactsAdapter(androidItems);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener1() {
            @Override
            public void onItemClick(View view, int position, String str) {
                Toast.makeText(WelFareActivity.this, "click" + str, Toast.LENGTH_SHORT).show();
//
                Intent intent2 = new Intent(WelFareActivity.this,ImageActivity.class);
                intent2.putExtra("itemurl1",androidItems.get(position).getUrl());
                startActivity(intent2);
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
                            Toast.makeText(WelFareActivity.this, "更新了10条数据...",
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
        String url = "http://gank.io/api/data/福利/10/"+(position/10 +1);
        okHttpSendRequest(url);
    }
}

