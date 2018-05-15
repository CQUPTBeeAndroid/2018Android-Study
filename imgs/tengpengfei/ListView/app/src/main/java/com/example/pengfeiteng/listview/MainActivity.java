package com.example.pengfeiteng.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends AppCompatActivity implements UltraRefreshListener{

    private PtrClassicFrameLayout mPtrFrame;
    private DogAdapter mAdapter;
    private UltraRefreshListView mlv;
    private List<Dog> dogList = new ArrayList<Dog>();
    private PtrClassicFrameLayout mptrFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPtrFrame = ((PtrClassicFrameLayout) findViewById(R.id.ultra));

        mlv = ((UltraRefreshListView) findViewById(R.id.mListView));

        CustomUltraRefreshHeader header = new CustomUltraRefreshHeader(this);

        mPtrFrame.setHeaderView(header);

        mPtrFrame.addPtrUIHandler((in.srain.cube.views.ptr.PtrUIHandler) header);

        mPtrFrame.setPtrHandler((PtrHandler) mlv);


        /*initDogs();*/
        mAdapter = new DogAdapter(MainActivity.this,R.layout.dog_item,dogList);

        /*mptrFrame.setLastUpdateTimeRelateObject(this);

        mptrFrame.setRatioOfHeaderHeightToRefresh(1.2f);//下拉刷新的阻力

        mptrFrame.setDurationToClose(200);//返回到刷新的位置

        mptrFrame.setDurationToCloseHeader(1000);//关闭头部的时间

        mptrFrame.setPullToRefresh(false);//下拉一定距离 true: 自动刷新, fasle: 释放刷新

        mptrFrame.setKeepHeaderWhenRefresh(true);

        mptrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,content,header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //数据回调
                mptrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mptrFrame.refreshComplete();
                    }
                },1500);
            }
        });*/
    }

    /*private void initDogs() {
        Dog hashiqi = new Dog("哈士奇",R.drawable.dog1);
        dogList.add(hashiqi);
        Dog zangao = new Dog("藏獒",R.drawable.dog2);
        dogList.add(zangao);
        Dog guibinquan = new Dog("贵宾犬",R.drawable.dog3);
        dogList.add(guibinquan);
        Dog songshi = new Dog("松狮",R.drawable.dog4);
        dogList.add(songshi);
        Dog jiwawa = new Dog("吉娃娃",R.drawable.dog5);
        dogList.add(jiwawa);
        Dog deguomuyangquan = new Dog("德国牧羊犬",R.drawable.dog6);
        dogList.add(deguomuyangquan);
        Dog bomeiquan = new Dog("博美犬",R.drawable.dog7);
        dogList.add(bomeiquan);
        Dog kasiluo = new Dog("卡斯罗",R.drawable.dog8);
        dogList.add(kasiluo);
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
    }*/

   @Override
    public void onRefresh() {
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                dogList.clear();
                Dog hashiqi = new Dog("哈士奇",R.drawable.dog1);
                dogList.add(hashiqi);
                Dog zangao = new Dog("藏獒",R.drawable.dog2);
                dogList.add(zangao);
                Dog guibinquan = new Dog("贵宾犬",R.drawable.dog3);
                dogList.add(guibinquan);
                Dog songshi = new Dog("松狮",R.drawable.dog4);
                dogList.add(songshi);
                Dog jiwawa = new Dog("吉娃娃",R.drawable.dog5);
                dogList.add(jiwawa);
                Dog deguomuyangquan = new Dog("德国牧羊犬",R.drawable.dog6);
                dogList.add(deguomuyangquan);
                Dog bomeiquan = new Dog("博美犬",R.drawable.dog7);
                dogList.add(bomeiquan);
                Dog kasiluo = new Dog("卡斯罗",R.drawable.dog8);
                dogList.add(kasiluo);
                Dog faguodouniuquan = new Dog("法国斗牛犬",R.drawable.dog9);
                dogList.add(faguodouniuquan);
                Dog yingguodouniuquan = new Dog("英国斗牛犬",R.drawable.dog10);
                dogList.add(yingguodouniuquan);


                mlv.refreshComplete();
                mAdapter.notifyDataSetChanged();
            }
        },1000);
    }

    @Override
    public void addMore() {
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
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
        },1000);
    }
}
