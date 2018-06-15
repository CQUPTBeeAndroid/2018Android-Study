package com.example.zhangfan.work6.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.zhangfan.work6.Gson.NewsJsonBean;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.RecyclerView.NewsAdapter;
import com.example.zhangfan.work6.RecyclerView.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class TimeActivity extends AppCompatActivity {
    private List<NewsJsonBean> newsBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ListView listView7 =findViewById(R.id.lv_main7);
    }
}
