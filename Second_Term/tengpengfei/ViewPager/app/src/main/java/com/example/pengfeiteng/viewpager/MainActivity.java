package com.example.pengfeiteng.viewpager;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener {

    private View page1,page2,page3,page4;

    private MyViewPagerAdapter myViewPagerAdapter;

    private ViewPager viewPager;

    private List<View> pageList;

    private List<Fragment> fragmentList;

    private Fragment1 fragment1;

    private Fragment2 fragment2;

    private Fragment3 fragment3;

    private Fragment4 fragment4;

    private MyFragmentAdapter myFragmentAdapter;

    private TextView tab1,tab2,tab3,tab4;

    private float windowWidth;

    private ImageView imageView;

    private int moveOneDistance = 0;

    private List<Item> itemList = new ArrayList<>();
    private List<Item> itemList1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initImage();
        initItem();
        initItem1();
    }

    private void initItem1() {
        for (int i = 0; i < 2; i++) {
            Item dog1 = new Item("朋友圈",R.drawable.ic_launcher_background);
            itemList.add(dog1);
            Item dog2 = new Item("扫一扫",R.drawable.ic_launcher_background);
            itemList.add(dog2);
            Item dog3 = new Item("摇一摇",R.drawable.ic_launcher_background);
            itemList.add(dog3);
            Item dog4 = new Item("看一看",R.drawable.ic_launcher_background);
            itemList.add(dog4);
        }
    }

    private void initItem() {
        for (int i = 0; i < 2; i++) {
            Item dog1 = new Item("dog1",R.drawable.dog1);
            itemList.add(dog1);
            Item dog2 = new Item("dog2",R.drawable.dog2);
            itemList.add(dog2);
            Item dog3 = new Item("dog3",R.drawable.dog3);
            itemList.add(dog3);
            Item dog4 = new Item("dog4",R.drawable.dog4);
            itemList.add(dog4);
        }
    }

    private void initImage() {
        imageView = findViewById(R.id.testImage);
        WindowManager windowManager = getWindowManager();
        windowWidth = windowManager.getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) (windowWidth / 4);
        imageView.setLayoutParams(layoutParams);
        moveOneDistance = (int) (windowWidth / 4);
    }

    private void initView() {
        viewPager = findViewById(R.id.mViewPager);

        /*LayoutInflater inflater = getLayoutInflater();
        page1 = inflater.inflate(R.layout.page1,null);
        page2 = inflater.inflate(R.layout.page2,null);
        page3 = inflater.inflate(R.layout.page3,null);
        page4 = inflater.inflate(R.layout.page4,null);

        pageList = new ArrayList<>();

        pageList.add(page1);
        pageList.add(page2);
        pageList.add(page3);
        pageList.add(page4);

        myViewPagerAdapter = new MyViewPagerAdapter(pageList);
        viewPager.setAdapter(myViewPagerAdapter);*/

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        fragmentList = new ArrayList<>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        tab4 = findViewById(R.id.tab4);

        viewPager.setCurrentItem(1);

        tab1.setTextColor(Color.RED);
        tab2.setTextColor(Color.BLACK);
        tab3.setTextColor(Color.BLACK);
        tab4.setTextColor(Color.BLACK);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);



        viewPager.addOnPageChangeListener(this);

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myFragmentAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tab1.setTextColor(Color.RED);
                tab2.setTextColor(Color.BLACK);
                tab3.setTextColor(Color.BLACK);
                tab4.setTextColor(Color.BLACK);
                movePositionX(0);
                load();
                break;
            case 1:
                tab1.setTextColor(Color.BLACK);
                tab2.setTextColor(Color.RED);
                tab3.setTextColor(Color.BLACK);
                tab4.setTextColor(Color.BLACK);
                movePositionX(1);
                load1();
                break;
            case 2:
                tab1.setTextColor(Color.BLACK);
                tab2.setTextColor(Color.BLACK);
                tab3.setTextColor(Color.RED);
                tab4.setTextColor(Color.BLACK);
                movePositionX(2);
                load2();
                break;
            case 3:
                tab1.setTextColor(Color.BLACK);
                tab2.setTextColor(Color.BLACK);
                tab3.setTextColor(Color.BLACK);
                tab4.setTextColor(Color.RED);
                movePositionX(3);
                load3();
                break;
        }
    }

    private void load3() {
        RecyclerView recyclerView3 = findViewById(R.id.mRecylerView3);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        recyclerView3.setLayoutManager(layoutManager3);
        BaseAdapter baseAdapter3 = new BaseAdapter(itemList);
        recyclerView3.setAdapter(baseAdapter3);
    }

    private void load2() {
        RecyclerView recyclerView2 = findViewById(R.id.mRecylerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        BaseAdapter baseAdapter2 = new BaseAdapter(itemList1);
        recyclerView2.setAdapter(baseAdapter2);
    }

    private void load1() {
        RecyclerView recyclerView1 = findViewById(R.id.mRecylerView1);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        BaseAdapter baseAdapter1 = new BaseAdapter(itemList);
        recyclerView1.setAdapter(baseAdapter1);
    }

    private void load() {
        RecyclerView recyclerView = findViewById(R.id.mRecylerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        BaseAdapter baseAdapter = new BaseAdapter(itemList);
        recyclerView.setAdapter(baseAdapter);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab4:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private void movePositionX(int toPosition) {
        float curX = imageView.getTranslationX();
        toPosition *= moveOneDistance;
        ObjectAnimator animator = new ObjectAnimator().ofFloat(imageView,"translationX",curX,toPosition);
        animator.start();
    }
}
