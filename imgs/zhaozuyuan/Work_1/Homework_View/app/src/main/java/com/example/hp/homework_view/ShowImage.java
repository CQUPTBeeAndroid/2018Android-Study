package com.example.hp.homework_view;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ShowImage extends AppCompatActivity {

//    申明三个对象，滑动对象、刷新对象、滑动控件的适配器对象
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipelyout;
    MyRecyAdapater myAdapter;

    private JsonBean jsonBean = null;

//    三个类型的字符串
    private final static String JUNSHI = "军事";
    private final static String BEAUTY = "美女";
    private final static String SHEHUI = "人文";

//    子线程的控制
    private boolean work = true;

//    网络图片的页数
    private int pages = 0;


//    获取窗口的高度
    int windowWidth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        work = true;

//        获取该展示什么类型的图片的数据
        Intent intent = getIntent();
        int type = intent.getIntExtra("Type",2);

//        获取屏幕宽度
        WindowManager wm1 = this.getWindowManager();
        windowWidth = wm1.getDefaultDisplay().getWidth();

        if(type == 0) {
            visitInternetData(JUNSHI);
        }else if(type == 1){
            visitInternetData(SHEHUI);
        }else {
            visitInternetData(BEAUTY);
        }

//        网络图片页数的改变
        pages += 4;

//        等待返回数据成功
        for(;jsonBean == null;);


//        实例滑动对象、适配器，将适配器放入到滑动对象中去
        recyclerView = (RecyclerView)findViewById(R.id.main_recyview);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3
                ,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyRecyAdapater(jsonBean,windowWidth,this);
        recyclerView.setAdapter(myAdapter);

//        实例刷新对象，实现一个方法
        mSwipelyout = (SwipeRefreshLayout)findViewById(R.id.main_swipe);
        initListener();

    }

    /**
     *
     * @param keyCode
     * @param event
     * @return 、false
     * 返回键关闭线程
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            work = false;
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 向上滑加载，向下拉刷新，但下拉刷新未做刷新
     */
    private void initListener(){
        initPullRefresh();
        initLoadMoreListener();
    }

    /**
     * 下拉刷新
     */
    private void initPullRefresh(){

//        刷新对象的监听,是出于SwipeRefreshLyout
        mSwipelyout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<Integer>imageIds_2 = new ArrayList<>();
                        for(int i = 0;i <= 4;i++){
                            imageIds_2.add(R.drawable.img_2);
                        }

//                        调用了适配器的Header的增加item的方法
                        myAdapter.AddHeaderItem(jsonBean);
                        mSwipelyout.setRefreshing(false);
                    }
                },3000);
            }
        });

    }

    /**
     * 上拉加载
     */
    private void initLoadMoreListener(){

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

//                当前RecyclerView显示出来的最后一个的item的position
                int lastPosition = -1;

//                当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof GridLayoutManager) {

//                        通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();

                    } else if (layoutManager instanceof LinearLayoutManager) {

                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();

                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {

//                        因为StaggeredGridLayoutManager的特殊性可能导致最后显示的item存在多个，所以这里取到的是一个数组
//                        得到这个数组后再取到数组中position值最大的那个就是最后显示的position值了
                        int[] lastPositions = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                        ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(lastPositions);
                        lastPosition = findMax(lastPositions);
                    }

//                    时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
//                    如果相等则说明已经滑动到最后了
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {

                        JsonBean jsonBean1 = jsonBean;
                        visitInternetData(JUNSHI);
                        pages += 4;

//                        等待获取数据成功
                        for(;jsonBean1.getStart_index() == jsonBean.getStart_index(););

                        Log.d("TAG",jsonBean1.getStart_index()+"----"+jsonBean.getStart_index());
                        myAdapter.AddFooterItem(jsonBean);
                        Toast.makeText(ShowImage.this,"正在加载···",Toast.LENGTH_SHORT).show();

                    }
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            }
        });
    }
    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * 访问百度图片并解析json获取对象（包括网址）
     * @param string
     */
    private void visitInternetData(final String string){
        new Thread(new Runnable() {
            @Override
            public void run() {

//                网址中的类型以及“全部”
                String type = null;
                String all = null;

                while (work) {
                    try {
//                        将汉字转化为标准网址
                        type = java.net.URLEncoder.encode(string, "utf-8");
                        all = java.net.URLEncoder.encode("全部", "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        Log.d("TAG", "错误1");
                    }

                    String apiUrl = String.format("http://image.baidu.com/channel/listjson?pn=%s" +
                            "&rn=8&tag1=%s&tag2=%s&ie=utf8",pages, type, all);

                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(apiUrl)
                                .build();
                        Response response = client.newCall(request).execute();
                        String responesDate = response.body().string();
//                        responesDate即是获取的json数据流。

//                        转化为JsonBean对象
                        Gson gson = new Gson();
                        try {
                            jsonBean = gson.fromJson(responesDate, JsonBean.class);
                        } catch (Exception e) {
                            Log.d("TAG", "错误2");
                        }
                    } catch (Exception e) {
                        Log.d("TAG", "错误3");
                    }
                }
            }
        }).start();
    }

}
