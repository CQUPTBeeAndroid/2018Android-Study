package com.example.hp.ourgank.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hp.ourgank.Activity.AndroidDetail;
import com.example.hp.ourgank.Activity.MainActivity;
import com.example.hp.ourgank.Activity.RecommendDetail;
import com.example.hp.ourgank.Adapter.SharedRecyAdapter;
import com.example.hp.ourgank.Assets.GetDataByHttp;
import com.example.hp.ourgank.Bean.AndroidDataBean;
import com.example.hp.ourgank.Bean.AndroidIntentData;
import com.example.hp.ourgank.Bean.RecommendDataBean;
import com.example.hp.ourgank.Bean.SharedTextViewDataBean;
import com.example.hp.ourgank.R;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/6 13:28
 * @简述: 安卓碎片
 */
public class AndroidFragment extends Fragment {

    private View view = null;

    private Activity context = null;

    private SharedRecyAdapter adapter = null;               //共用的一个recyclerview的adapter

    private List<SharedTextViewDataBean> strings = null;    //共用的一个提供给adapter的一个存放数据的容器。

    private GetDataByHttp getDataByHttp = null;             //获取数据的对象

    private AndroidDataBean bean = new AndroidDataBean();   //json数据种子

    private SwipeRefreshLayout refreshLayout;

    private AndroidIntentData data = new AndroidIntentData();//用于活动间传递数据的数据对象

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_android, container, false);

        context = (MainActivity) getActivity();

        getData();      //得到数据

        page++;

        return view;
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        adapter = new SharedRecyAdapter(R.id.android_recy_text1
                , R.id.android_recy_text2, R.layout.android_recy_item, strings);    //传入控件

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.android_recy);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.android_swipe); //下拉刷新
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                page++;
            }
        });

        adapter.setOnClickListener(new SharedRecyAdapter.SetItemOnClickListener() {
            @Override
            public void onClick(int position) {
                data.setImages(bean.getResults().get(position).getImages());
                data.setUrl(bean.getResults().get(position).getUrl());

                Bundle mBundle = new Bundle();
                mBundle.putSerializable("data",data);

                Intent intent = new Intent(context, AndroidDetail.class);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        String url = "http://gank.io/api/data/Android/10/" + page;
        getDataByHttp = new GetDataByHttp(url, handler, bean, AndroidDataBean.class);
        getDataByHttp.startSendRequest();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    strings = new ArrayList<>();

                    bean = (AndroidDataBean) getDataByHttp.getBean();
                    if (!bean.isError()) {
                        List<AndroidDataBean.Results> results = bean.getResults();
                        for (AndroidDataBean.Results r : results) {
                            String time = r.getPublishedAt().substring(0, 10);
                            strings.add(new SharedTextViewDataBean(r.getDesc(), time));
                        }

                        if (adapter == null) {
                            initView();
                        } else {
                            adapter.shuaXin(strings);
                            refreshLayout.setRefreshing(false);
                        }
                    } else {
                        Toast.makeText(context, "获取“Android”资源失败！", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 0:
                    Toast.makeText(context, "获取“Android”资源失败！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}