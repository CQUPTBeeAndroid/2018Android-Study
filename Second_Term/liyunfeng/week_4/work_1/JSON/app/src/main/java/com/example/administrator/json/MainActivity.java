package com.example.administrator.json;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private JSONObject object;
    private int xiala=0,shangla=1;
    private int lastVisibleItem;
private List<Map<String,Object>> mlist=new ArrayList<Map<String,Object>>();
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                init(xiala);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        init(xiala);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE
                        ){
                    final View footView= View.inflate(getBaseContext(),R.layout.footxml,null);
                    listView.addFooterView(footView);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                            }catch (Exception e){
                                e.printStackTrace();
                            }runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    init(shangla);
                                    swipeRefreshLayout.setRefreshing(false);
                                    listView.removeFooterView(footView);
                                }
                            });
                        }
                    }).start();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }

        });


    }
    private void init(final int type){
        listView=(ListView)findViewById(R.id.listView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://gank.io/api/data/Android/10/1")
                        .build();
                try {
                    Response response=client.newCall(request).execute();
                    String data=response.body().string();
                    if (type==0){
                        jsonXLJX(data);
                    }else{
                        jsonJX(data);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void jsonJX(String data){
        if (data!=null){
            try {
                JSONObject jsonObject=new JSONObject(data);
                JSONArray resultJsonArray=jsonObject.getJSONArray("results");
                for (int i=0;i<resultJsonArray.length();i++){
                    object=resultJsonArray.getJSONObject(i);
                    Map<String,Object> map=new HashMap<String, Object>();
                    try {
                        String id=object.getString("_id");
                        map.put("_id",id);
                        mlist.add(map);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void jsonXLJX(String data){
        if (data!=null){
            try {
                JSONObject jsonObject=new JSONObject(data);
                JSONArray resultJsonArray=jsonObject.getJSONArray("results");
                for (int i=0;i<resultJsonArray.length();i++){
                    object=resultJsonArray.getJSONObject(i);
                    Map<String,Object> map=new HashMap<String, Object>();
                    try {
                        String id=object.getString("_id");
                        map.put("_id",id);
                        mlist.add(0,map);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                Message message=new Message();
                message.what=1;
                handler.sendMessage(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @SuppressLint("HandlerLeak")
    private  Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    MyListViewAdapter myListViewAdapter=new MyListViewAdapter();
                    listView.setAdapter(myListViewAdapter);
                    myListViewAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    //适配器
    class MyListViewAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolde viewHolde;
            if (convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.layout,null);
                viewHolde=new ViewHolde();
                viewHolde.id=(TextView)convertView.findViewById(R.id.textView);
                convertView.setTag(viewHolde);
            }else{
                viewHolde=(ViewHolde)convertView.getTag();
            }
            viewHolde.id.setText(mlist.get(position).get("_id").toString());
            return convertView;
        }
    }
    class ViewHolde{
        TextView id;
    }
}
