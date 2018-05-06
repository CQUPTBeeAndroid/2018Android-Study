package activitytest.com.example.refreshtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnRefreshListener {

    private SwipeRefreshLayout swipeLayout;
    private ListView listView;
    private List<Fruit> listDatas;
    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        listView = (ListView) findViewById(R.id.list);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeResources(android.R.color.holo_orange_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        listDatas = new ArrayList<Fruit>();
        for(int i =0; i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple);
            listDatas.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana);
           listDatas.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.orange);
            listDatas.add(orange);
            Fruit watermelon= new Fruit("Watermelon",R.drawable.watermelon);
           listDatas.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.pear);
            listDatas.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.grape);
           listDatas.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple);
            listDatas.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry);
            listDatas.add(strawberry);
            Fruit mango = new Fruit("Mango",R.drawable.mango);
            listDatas.add(mango);
        }
        adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item,listDatas);
        listView.setAdapter(adapter);

    }

    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                swipeLayout.setRefreshing(false);
                listDatas.addAll(listDatas);
                adapter.notifyDataSetChanged();
            }
        }, 3000);
    }

}
