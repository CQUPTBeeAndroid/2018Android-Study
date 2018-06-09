package com.example.materiatest3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyFragment3 extends Fragment {
    String b, c, d, e, f, g, h, b1, b2, b3;
    String[] a = {b, c, d, e, f, g, h, b1, b2, b3};
    int j=-3;
    int m=9;
    private TextView textview;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private ContactsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Contact> mContacts = new ArrayList<>();
    private ArrayList<Contact> mAddData;
    private int lastVisibleItem;
    public static final int UPDATA_TEXT = 1;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page3, null);


        mRecyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://gank.io/api/data/Android/10/1")
                            .build();
                    Response response = client.newCall(request).execute();
                    String JSONString = response.body().string();

                    Gson gson = new Gson();

                    Result r = gson.fromJson(JSONString, Result.class);

                    for (int i = 0; i < 10; i++) {
                        a[i] = r.results.get(i).desc;
                        Log.e("TAG" + i, a[i]);
                    }
                    Message message = new Message();
                    message.what = UPDATA_TEXT;
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return view;
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATA_TEXT:

                    initView();
                    getData();

                    break;
                default:
                    break;
            }
        }
    };




        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));



    private void getData() {
        initContacts(9);
        mAdapter = new ContactsAdapter(mContacts);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        //上拉加载，设置滑动监听
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==
                        mAdapter.getItemCount()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //把要刷新的实例化
                            initContacts(2);
                            mAdapter.upAddData(mAddData);
                            Toast.makeText(getContext(), "更新了2条数据...",
                                    Toast.LENGTH_SHORT).show();
                        }
                    },1000);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //找到最后一个的位置
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });


        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //把要刷新的实例化
                        initContacts(3);
                        mAdapter.swipeAddData(mAddData);
                        Toast.makeText(getContext(), "更新了三条数据...",
                                Toast.LENGTH_SHORT).show();
                    }
                },1000);
                //刷新结束
                mRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void initView() {

        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //瀑布流布局
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager
                (3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));

        //设置刷新图标的颜色
        mRefreshLayout.setColorSchemeResources(R.color.colorAccent);
    }

    private void initContacts(int n) {

        mAddData = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n == 2) {
                m++;
                Contact contact = new Contact(a[i]+"", m+"");
                mAddData.add(contact);
            }else if (n == 3) {

                j++;
                Contact contacts = new Contact(a[i] + "", j + "");

                mAddData.add(contacts);
            } else{
                    Contact contacts = new Contact(a[i] + "", i + "");
                    mContacts.add(contacts);
                }
        }
    }

}