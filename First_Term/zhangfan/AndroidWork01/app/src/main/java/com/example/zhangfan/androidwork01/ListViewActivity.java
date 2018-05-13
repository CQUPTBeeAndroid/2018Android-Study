package com.example.zhangfan.androidwork01;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private List<Fruit> fruitList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item, fruitList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this,fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("苹果", R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit("香蕉", R.drawable.banana);
            fruitList.add(banana);
            Fruit orange = new Fruit("橘子", R.drawable.orange);
            fruitList.add(orange);
            Fruit watermalon = new Fruit("西瓜", R.drawable.watermlon);
            fruitList.add(watermalon);
            Fruit pear = new Fruit("梨子", R.drawable.pear);
            fruitList.add(pear);
            Fruit grape = new Fruit("葡萄", R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("菠萝", R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("草莓", R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("樱桃", R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango = new Fruit("芒果", R.drawable.mango);
            fruitList.add(mango);
        }
    }
}