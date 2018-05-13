package com.example.pengfeiteng.recycleview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<Dog> dogList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDogs();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.swipe_target);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DogAdapter adapter = new DogAdapter(dogList);
        recyclerView.setAdapter(adapter);
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initUpDogs();
            }
        });
        swipeRefreshLayout.setRefreshing(false);
    }
    private void initUpDogs() {
        Dog jiwawa = new Dog("吉娃娃",R.drawable.dog5);
        dogList.add(jiwawa);
        Dog deguomuyangquan = new Dog("德国牧羊犬",R.drawable.dog6);
        dogList.add(deguomuyangquan);
        Dog bomeiquan = new Dog("博美犬",R.drawable.dog7);
        dogList.add(bomeiquan);
        Dog kasiluo = new Dog("卡斯罗",R.drawable.dog8);
        dogList.add(kasiluo);
    }

    private void initDogs() {
        for (int i = 0; i < 2; i++) {
            Dog hashiqi = new Dog("哈士奇",R.drawable.dog1);
            dogList.add(hashiqi);
            Dog zangao = new Dog("藏獒",R.drawable.dog2);
            dogList.add(zangao);
            Dog guibinquan = new Dog("贵宾犬",R.drawable.dog3);
            dogList.add(guibinquan);
            Dog songshi = new Dog("松狮",R.drawable.dog4);
            dogList.add(songshi);
            Dog faguodouniuquan = new Dog("法国斗牛犬",R.drawable.dog9);
            dogList.add(faguodouniuquan);
            Dog yingguodouniuquan = new Dog("英国斗牛犬",R.drawable.dog10);
            dogList.add(yingguodouniuquan);
            Dog samoyequan = new Dog("萨摩耶犬",R.drawable.dog11);
            dogList.add(samoyequan);
            Dog afuhanquan = new Dog("阿富汗犬",R.drawable.dog12);
            dogList.add(afuhanquan);
            Dog dabaixiongquan = new Dog("大白熊犬",R.drawable.dog13);
            dogList.add(dabaixiongquan);
            Dog shengbonaquan = new Dog("圣伯纳犬",R.drawable.dog14);
            dogList.add(shengbonaquan);
            Dog jinmaoxunhuiquan = new Dog("金毛寻回犬",R.drawable.dog15);
            dogList.add(jinmaoxunhuiquan);
            Dog douniugeng = new Dog("斗牛梗",R.drawable.dog16);
            dogList.add(douniugeng);
        }
    }
}
