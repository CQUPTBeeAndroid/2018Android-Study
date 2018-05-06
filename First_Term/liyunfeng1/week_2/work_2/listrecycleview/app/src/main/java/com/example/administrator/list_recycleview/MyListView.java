package com.example.administrator.list_recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyListView extends AppCompatActivity{
    private MyListViewAdapt myListViewAdapt;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Item> mlist=new ArrayList<>();
    private int num=1;//上拉的数据
    private int num1=1;//下拉的数据
    private int LastVisiblePosition;
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        init();
        myListViewAdapt=new MyListViewAdapt(MyListView.this,R.layout.item,mlist);
        listView=(ListView)findViewById(R.id.list);

        listView.setAdapter(myListViewAdapt);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item=(Item)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),item.getTextView(),Toast.LENGTH_SHORT).show();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE){
                    final View footView= View.inflate(getBaseContext(),R.layout.footxml,null);
                    listView.addFooterView(footView);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                Thread.sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initshangla();
                                    myListViewAdapt.notifyDataSetChanged();
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

    public void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initxiala();
                        myListViewAdapt.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


    private void initxiala(){
        for (int i=0;i<2;i++){
            Item item=new Item();

            item.setImage(R.drawable.ic_launcher_background);
            item.setTextView("刷新数据第"+num1+"条");
            num1++;
            mlist.add(0,item);
        }
    }
    private void init(){
        for (int i=0;i<2;i++){
            Item item=new Item();
            item.setImage(R.drawable.ic_launcher_background);
            item.setTextView("原数据"+i);
            mlist.add(item);
        }
    }

    private void initshangla(){
        for (int i=0;i<2;i++){
            Item item=new Item();
            item.setImage(R.drawable.ic_launcher_background);
            item.setTextView("加载数据第"+num+"条");
            num++;
            mlist.add(item);
        }
    }

}
