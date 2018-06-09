package com.example.hp.ourgank.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hp.ourgank.Activity.MainActivity;
import com.example.hp.ourgank.Adapter.WelFareRecyAdapter;
import com.example.hp.ourgank.Assets.GetDataByHttp;
import com.example.hp.ourgank.Bean.WelFareImageBean;
import com.example.hp.ourgank.R;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/5 17:33
 * @简述: 福利碎片
 */
public class WelfareFragment extends Fragment{

    private View view = null;       //整个fragment的view

    private Activity context = null;

    private List<String>images = null;  //用来装图片网址的容器，注意每次都是10个数据，每次改变要重新实例

    private RecyclerView recyclerView = null;

    private GetDataByHttp getDataByHttp = null;     //用来请求json数据的对象

    private SwipeRefreshLayout swipeRefreshLayout = null;   //下拉刷新

    private WelFareRecyAdapter recyAdapter = null;

    private WelFareImageBean bean = new WelFareImageBean();

    private static boolean isBottomRefresh = false;     //是否是底部刷新数据的标志

    private static int page = 1;           //页数，初始化为第二页

    private int[] lastVisibleItem;      //瀑布流一行的位置的数组

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_welfare,container,false);

        context = (MainActivity)getActivity();

        getImageUrl(page);      //第一次获取图片

        page++;

        return view;
    }

    /**
     * 初始化控件，包括了下拉刷新、上拉加载
     */
    private void initView(){
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2
                ,StaggeredGridLayoutManager.VERTICAL);          //瀑布流
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE); //防止item乱跳

        recyAdapter= new WelFareRecyAdapter(images,context);

        recyclerView = view.findViewById(R.id.welfare_recy);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyAdapter);

        swipeRefreshLayout = view.findViewById(R.id.welfare_swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getImageUrl(page);      //下拉刷新
                page++;
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                Log.d("TAG","count"+recyAdapter.getItemCount());

                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem[0] + 1==
                        recyAdapter.getItemCount()) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            isBottomRefresh = true;     //开始上拉加载了
                            getImageUrl(page);
                            page++;

                            Log.d("TAG","上拉加载");
                        }
                    },100);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //找到最后一个的位置
                lastVisibleItem = layoutManager.findLastVisibleItemPositions(new int[layoutManager.getSpanCount()]);
                Log.d("TAG","最后的item的位置"+lastVisibleItem[0]);
            }
        });
    }

    /**
     * @param page 页数
     *  发送网络请求
     */
    private void getImageUrl(int page){
        String type = "-1";
        try {
            type = java.net.URLEncoder.encode("福利", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://gank.io/api/data/"+type+"/10/"+page;
        getDataByHttp = new GetDataByHttp(url,handler,bean,WelFareImageBean.class);
        getDataByHttp.startSendRequest();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    images = new ArrayList<>();                //必须在下面每次要用时实例，不然会出现item重复。

                    bean = (WelFareImageBean) getDataByHttp.getBean();      //获取种子

                    if(!bean.isError()){
                        List<WelFareImageBean.Results>results = bean.getResults();
                        for(WelFareImageBean.Results r: results){
                            images.add(r.getUrl());
                        }
                    }

                    if(recyclerView == null){           //第一次进入
                        initView();
                        recyAdapter.notifyDataSetChanged();
                    }

                    if(isBottomRefresh){
                        recyAdapter.bottomAddData(images);isBottomRefresh = false;      //上拉加载
                    }else {
                        swipeRefreshLayout.setRefreshing(false);
                        recyAdapter.topAddData(images);         //下拉刷新
                    }
                    break;
                case 0:
                    Toast.makeText(context,"加载失败！",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
}
