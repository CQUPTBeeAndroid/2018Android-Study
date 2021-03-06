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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hp.ourgank.Activity.MainActivity;
import com.example.hp.ourgank.Adapter.SharedRecyAdapter;
import com.example.hp.ourgank.Assets.GetDataByHttp;
import com.example.hp.ourgank.Bean.RecommendDataBean;
import com.example.hp.ourgank.Bean.SharedTextViewDataBean;
import com.example.hp.ourgank.R;
import com.example.hp.ourgank.Activity.RecommendDetail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/6 13:28
 * @简述: 推荐碎片(视频碎片)
 */
public class RecommendFragment extends Fragment {

    private View view = null;

    private Activity context = null;

    private SharedRecyAdapter adapter = null;

    private List<SharedTextViewDataBean>strings = null;

    private GetDataByHttp getDataByHttp = null;

    private RecommendDataBean bean = new RecommendDataBean();

    private SwipeRefreshLayout refreshLayout;

    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommend,container,false);

        context = (MainActivity)getActivity();

        getData();

        page++;

        return view;
    }

    private void initView(){
        LinearLayoutManager manager = new LinearLayoutManager(context);
        adapter = new SharedRecyAdapter(R.id.recommend_recy_text1
                ,R.id.recommend_recy_text2,R.layout.recommend_recy_item,strings);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recommend_recy);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.recommend_swipe);
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
                Intent intent = new Intent(context, RecommendDetail.class);
                intent.putExtra("url",bean.getResults().get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    private void getData(){
        String type = "-1";
        try {
            type = java.net.URLEncoder.encode("休息视频", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://gank.io/api/data/"+type+"/10/"+page;
        getDataByHttp = new GetDataByHttp(url,handler,bean,RecommendDataBean.class);
        getDataByHttp.startSendRequest();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    strings = new ArrayList<>();

                    bean = (RecommendDataBean) getDataByHttp.getBean();
                    if(!bean.isError()){
                        List<RecommendDataBean.Results> results = bean.getResults();
                        for(RecommendDataBean.Results r:results){
                            String time = r.getPublishedAt().substring(0,10);
                            strings.add(new SharedTextViewDataBean(r.getDesc(),time));
                        }

                        if(adapter == null){
                            initView();
                        }else {adapter.shuaXin(strings);refreshLayout.setRefreshing(false);}
                    }else { Toast.makeText(context,"获取“推荐”资源失败！",Toast.LENGTH_SHORT).show();}
                    break;
                case 0:
                    Toast.makeText(context,"获取“推荐”资源失败！",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}