package com.example.zhangfan.work6.FrameLayout;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zhangfan.work6.Activities.AllActivity;
import com.example.zhangfan.work6.Activities.TimeActivity;
import com.example.zhangfan.work6.Gson.JsonHttp;
import com.example.zhangfan.work6.Gson.NewsJsonBean;
import com.example.zhangfan.work6.HttpUtil.HttpUtil;
import com.example.zhangfan.work6.R;
import com.example.zhangfan.work6.RecyclerView.MyPagerAdapter;
import com.example.zhangfan.work6.RecyclerView.NewsAdapter;
import com.example.zhangfan.work6.RecyclerView.NewsBean;
import com.example.zhangfan.work6.RecyclerView.WrapContentListView;
import com.example.zhangfan.work6.WebActivities.WebActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FirstFrameLayout extends Fragment {
    private List<NewsJsonBean.Results> androidItems = new ArrayList<>();
    private View pager1, pager2, pager3;
    private List<NewsBean> newsBeanList = new ArrayList<>();
    private List<NewsBean> newsBeanList2 = new ArrayList<>();
    private List<NewsBean> newsBeanList3 = new ArrayList<>();
    private List<NewsBean> newsBeanList4 = new ArrayList<>();
    private List<NewsBean> newsBeanList5 = new ArrayList<>();
    private List<NewsBean> newsBeanList6 = new ArrayList<>();
    private List<View> pagerList;
    private ViewPager viewPager;
    private ArrayList<View> pageview;
    private MyPagerAdapter myPagerAdapter;
    private WrapContentListView mListView;
    private NewsAdapter adapter1;
    private NewsAdapter adapter2;
    private NewsAdapter adapter3;
    private NewsAdapter adapter4;
    private NewsAdapter adapter5;
    private NewsAdapter adapter6;
    private WrapContentListView androidlist;
    private NewsJsonBean newsJsonBean;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View firstFrameLayout = inflater.inflate(R.layout.fragme_first, container, false);

        adapter1 = new NewsAdapter(getActivity(), R.layout.listview_item, newsBeanList);
        adapter2 = new NewsAdapter(getActivity(), R.layout.listview_item, newsBeanList2);
        adapter3 = new NewsAdapter(getActivity(), R.layout.listview_item, newsBeanList3);
        adapter4 = new NewsAdapter(getActivity(), R.layout.listview_item, newsBeanList4);
        adapter5 = new NewsAdapter(getActivity(), R.layout.listview_item, newsBeanList5);
        adapter6 = new NewsAdapter(getActivity(), R.layout.listview_item, newsBeanList6);


        viewPager = (ViewPager) firstFrameLayout.findViewById(R.id.viewpag);

        ImageView imageView = firstFrameLayout.findViewById(R.id.image_first);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TimeActivity.class);
                startActivity(intent);
            }
        });
        inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.item01, null);
        View view2 = inflater.inflate(R.layout.item02, null);
        View view3 = inflater.inflate(R.layout.item03, null);

        //将view装入数组
        pageview = new ArrayList<View>();
        pageview.add(view1);
        pageview.add(view2);
        pageview.add(view3);


        //数据适配器
        PagerAdapter mPagerAdapter = new PagerAdapter() {

            @Override
            public int getCount() {
                return pageview.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView(pageview.get(arg1));
            }

            public Object instantiateItem(View arg0, int arg1) {
                ((ViewPager) arg0).addView(pageview.get(arg1));
                return pageview.get(arg1);
            }


        };

        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);
//
        androidlist = firstFrameLayout.findViewById(R.id.lv_main);
        WrapContentListView listView2 = (WrapContentListView) firstFrameLayout.findViewById(R.id.lv_main2);
        WrapContentListView listView3 = firstFrameLayout.findViewById(R.id.lv_main3);
        WrapContentListView listView4 = firstFrameLayout.findViewById(R.id.lv_main4);
        WrapContentListView listView5 = firstFrameLayout.findViewById(R.id.lv_main5);
        WrapContentListView listView6 = firstFrameLayout.findViewById(R.id.lv_main6);
        ListView listView = firstFrameLayout.findViewById(R.id.lv_main6);




        //mListView.setAdapter(adapter);


        listView4.setAdapter(adapter4);
        listView5.setAdapter(adapter5);
        listView6.setAdapter(adapter6);
        androidlist.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);


        androidlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",newsJsonBean.getResults().getAndroid().get(position).getUrl());
                startActivity(intent);


            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",newsJsonBean.getResults().getiOS().get(position).getUrl());
                startActivity(intent);


            }
        });
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",newsJsonBean.getResults().get休息视频().get(position).getUrl());
                startActivity(intent);


            }
        });
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",newsJsonBean.getResults().get拓展资源().get(position).getUrl());
                startActivity(intent);


            }
        });
        listView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",newsJsonBean.getResults().get瞎推荐().get(position).getUrl());
                startActivity(intent);


            }
        });
        listView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(parent.getContext(), WebActivity.class);
                intent.putExtra("itemurl",newsJsonBean.getResults().get福利().get(position).getUrl());
                startActivity(intent);


            }
        });
        okHttpSendRequest2();


        return firstFrameLayout;


    }
    //网络部分

    private void okHttpSendRequest2() {

//       long time = System.currentTimeMillis();
//        final Calendar mCalendar = Calendar.getInstance();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String url = "http://gank.io/api/day/"+year+"/"+month+"/"+day;
        Log.d("a", url);
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                Gson gson = new Gson();
                newsJsonBean = gson.fromJson(responseData, NewsJsonBean.class);


                //android
                if (newsJsonBean.getResults().getAndroid() != null) {
                    for (int i = 0; i < newsJsonBean.getResults().getAndroid().size(); i++) {
                        NewsBean ab = new NewsBean(newsJsonBean.getResults().getAndroid().get(i).getDesc(), newsJsonBean.getResults().getAndroid().get(i).getWho(), newsJsonBean.getResults().getAndroid().get(i).getPublishedAt());
                        newsBeanList.add(ab);

                    }
                }
                //ios
                if (newsJsonBean.getResults().getiOS() != null) {
                    for (int i = 0; i < newsJsonBean.getResults().getiOS().size(); i++) {
                        NewsBean ab = new NewsBean(newsJsonBean.getResults().getiOS().get(i).getDesc(), newsJsonBean.getResults().getiOS().get(i).getWho(), newsJsonBean.getResults().getiOS().get(i).getPublishedAt());
                        newsBeanList2.add(ab);

                    }
                }

                //reconmend
                if (newsJsonBean.getResults().get瞎推荐() != null) {
                    for (int i = 0; i < newsJsonBean.getResults().get瞎推荐().size(); i++) {
                        NewsBean ab = new NewsBean(newsJsonBean.getResults().get瞎推荐().get(i).getDesc(), newsJsonBean.getResults().get瞎推荐().get(i).getWho(), newsJsonBean.getResults().get瞎推荐().get(i).getPublishedAt());
                        newsBeanList3.add(ab);

                    }
                }
                if (newsJsonBean.getResults().get拓展资源() != null){
                    for (int i=0;i<newsJsonBean.getResults().get拓展资源().size();i++){
                        NewsBean ab = new NewsBean(newsJsonBean.getResults().get拓展资源().get(i).getDesc(),newsJsonBean.getResults().get拓展资源().get(i).getWho(),newsJsonBean.getResults().get拓展资源().get(i).getPublishedAt());
                        newsBeanList4.add(ab);

                    }
                }

                //
                if (newsJsonBean.getResults().get福利() != null) {
                    for (int i = 0; i < newsJsonBean.getResults().get福利().size(); i++) {
                        NewsBean ab = new NewsBean(newsJsonBean.getResults().get福利().get(i).getDesc(), newsJsonBean.getResults().get福利().get(i).getWho(), newsJsonBean.getResults().get福利().get(i).getPublishedAt());
                        newsBeanList5.add(ab);

                    }
                }
                //
                if (newsJsonBean.getResults().get休息视频() != null) {
                    for (int i = 0; i < newsJsonBean.getResults().get休息视频().size(); i++) {
                        NewsBean ab = new NewsBean(newsJsonBean.getResults().get休息视频().get(i).getDesc(), newsJsonBean.getResults().get休息视频().get(i).getWho(), newsJsonBean.getResults().get休息视频().get(i).getPublishedAt());
                        newsBeanList6.add(ab);

                    }
                }
                sendmsg();
                //  newsBeanList.add(a);





            }
        });
    }
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    adapter6.notifyDataSetChanged();
                    adapter5.notifyDataSetChanged();
                    adapter4.notifyDataSetChanged();
                    adapter3.notifyDataSetChanged();
                    adapter2.notifyDataSetChanged();
                    adapter1.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };
    public void sendmsg(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        }).start();

    }

}


