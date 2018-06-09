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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyFragment2 extends Fragment {


    String a1, a2, a3, a4, a5;
    String b1, b2, b3, b4, b5;
    String c1, c2, c3, c4, c5;
    String d1, d2, d3, d4, d5;
    String e1, e2, e3, e4, e5;
    String f1, f2, f3, f4, f5;

    String[] a = {a1, a2, a3, a4, a5};
    String[] b = {b1, b2, b3, b4, b5};
    String[] c = {c1, c2, c3, c4, c5};
    String[] d = {d1, d2, d3, d4, d5};
    String[] e = {e1, e2, e3, e4, e5};
    String[] f = {f1, f2, f3, f4, f5};
    String city;
    int sx = 0;
    int jz = -1;
    int sx1 = 0;

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
        View view = inflater.inflate(R.layout.page2, null);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView2);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshView2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.apiopen.top/weatherApi?city=%E9%87%8D%E5%BA%86")
                            .build();
                    Response response = client.newCall(request).execute();
                    String JSONString = response.body().string();

                    Gson gson = new Gson();

                    /*Result r = gson.fromJson(JSONString, Result.class);

                    for (int i = 0; i < 10; i++) {
                        a[i] = r.results.get(i).desc;
                        Log.e("TAG" + i, a[i]);
                    }*/


                    Weather w = gson.fromJson(JSONString, Weather.class);
                    //yesterday
                    String yd = w.data.yesterday.date;
                    a[0] = yd;
                    String yh = w.data.yesterday.high;
                    a[1] = yh;
                    String yf = w.data.yesterday.fx;
                    a[2] = yf;
                    String yl = w.data.yesterday.low;
                    a[3] = yl;
                    String yt = w.data.yesterday.type;
                    a[4] = yt;
                    //城市
                    city = w.data.city;
                    //forecast
                    for (int i = 0; i < 5; i++) {
                        b[i] = w.data.forecast.get(i).date;
                        c[i] = w.data.forecast.get(i).high;
                        d[i] = w.data.forecast.get(i).low;
                        e[i] = w.data.forecast.get(i).fengxiang;
                        f[i] = w.data.forecast.get(i).type;
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
        initContacts(4);
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
                            if (jz <= 5) {
                                Toast.makeText(getContext(), "这是第" + (jz + 1) + "天的天气",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "已经是最新4天的天气了",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 1000);
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
                        //把要刷新的实化
                        initContacts(3);
                        mAdapter.swipeAddData(mAddData);
                        Log.e("Q", sx + "");
                        if (sx1 >= 1) {
                            Toast.makeText(getContext(), "只能刷新到昨天的天气",
                                    Toast.LENGTH_SHORT).show();
                        } else if (sx == 1) {
                            Toast.makeText(getContext(), "这是昨天的天气",
                                    Toast.LENGTH_SHORT).show();
                        }
                        sx1++;
                    }
                }, 1000);
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

        if (n == 2) {
            switch (jz) {
                case 0:
                    Contact contact1 = new Contact(b[1], "日期");
                    mAddData.add(contact1);
                    Contact contact2 = new Contact(c[1], "温度");
                    mAddData.add(contact2);
                    Contact contact3 = new Contact(d[1], "温度");
                    mAddData.add(contact3);
                    Contact contact4 = new Contact(e[1], "风向");
                    mAddData.add(contact4);
                    Contact contact5 = new Contact(f[1], "天气");
                    mAddData.add(contact5);
                    Contact contact6 = new Contact("", "后天");
                    mAddData.add(contact6);
                    break;
                case 1:
                    Contact contact11 = new Contact(b[2], "日期");
                    mAddData.add(contact11);
                    Contact contact22 = new Contact(c[2], "温度");
                    mAddData.add(contact22);
                    Contact contact33 = new Contact(d[2], "温度");
                    mAddData.add(contact33);
                    Contact contact44 = new Contact(e[2], "风向");
                    mAddData.add(contact44);
                    Contact contact55 = new Contact(f[2], "天气");
                    mAddData.add(contact55);
                    Contact contact66 = new Contact("", "");
                    mAddData.add(contact66);
                    break;
                case 3:
                    Contact contact111 = new Contact(b[3], "日期");
                    mAddData.add(contact111);
                    Contact contact222 = new Contact(c[3], "温度");
                    mAddData.add(contact222);
                    Contact contact333 = new Contact(d[3], "温度");
                    mAddData.add(contact333);
                    Contact contact444 = new Contact(e[3], "风向");
                    mAddData.add(contact444);
                    Contact contact555 = new Contact(f[3], "天气");
                    mAddData.add(contact555);
                    Contact contact666 = new Contact("", "");
                    mAddData.add(contact666);
                    break;
                case 4:
                    Contact contact1111 = new Contact(b[4], "日期");
                    mAddData.add(contact1111);
                    Contact contact2222 = new Contact(c[4], "温度");
                    mAddData.add(contact2222);
                    Contact contact3333 = new Contact(d[4], "温度");
                    mAddData.add(contact3333);
                    Contact contact4444 = new Contact(e[4], "风向");
                    mAddData.add(contact4444);
                    Contact contact5555 = new Contact(f[4], "天气");
                    mAddData.add(contact5555);
                    Contact contact6666 = new Contact("", "");
                    mAddData.add(contact6666);
                    break;
                default:

                    break;
            }
            jz++;
        } else if (n == 3) {
            if (sx == 0) {
                Contact contacts7 = new Contact("", "昨天");
                mAddData.add(contacts7);
                Contact contacts1 = new Contact(a[0], "日期");
                mAddData.add(contacts1);
                Contact contacts2 = new Contact(a[1], "温度");
                mAddData.add(contacts2);
                Contact contacts4 = new Contact(a[3], "温度");
                mAddData.add(contacts4);
                Contact contacts3 = new Contact(a[2], "风向");
                mAddData.add(contacts3);
                Contact contacts5 = new Contact(a[4], "天气");
                mAddData.add(contacts5);
                Contact contacts6 = new Contact("", "");
                mAddData.add(contacts6);
                sx++;
            }
        } else {
            Contact contact = new Contact(city, "城市");
            mContacts.add(contact);
            Contact contact7 = new Contact("", "今天");
            mContacts.add(contact7);
            Contact contacts1 = new Contact(b[0], "日期");
            mContacts.add(contacts1);
            Contact contacts2 = new Contact(c[0], "温度");
            mContacts.add(contacts2);
            Contact contacts3 = new Contact(d[0], "温度");
            mContacts.add(contacts3);
            Contact contacts4 = new Contact(e[0], "风向");
            mContacts.add(contacts4);
            Contact contacts5 = new Contact(f[0], "天气");
            mContacts.add(contacts5);
            Contact contacts6 = new Contact("", "明天");
            mContacts.add(contacts6);

        }

    }

}