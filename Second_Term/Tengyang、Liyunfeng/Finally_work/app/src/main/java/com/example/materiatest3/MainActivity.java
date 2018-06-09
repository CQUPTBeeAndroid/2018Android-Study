package com.example.materiatest3;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private DrawerLayout m;
    private TextView tv_tab0, tv_tab1, tv_tab2, tv_tab3;
    private ImageView line_tab;
    private int moveOne = 0;
    private boolean isScrolling = false;
    private boolean isBackScrolling = false;
    private long startTime = 0;
    private long currentTime = 0;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initLineImage();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar a = getSupportActionBar();
        if (a != null) {
            a.setDisplayHomeAsUpEnabled(true);
            //a.setHomeAsUpIndicator(R.drawable.meizi7);
        }

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_call);//默认选中
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //m.closeDrawers();关闭菜单
                switch (item.getItemId()) {
                    case R.id.nav_call:
                        Intent call = new Intent(MainActivity.this, CallActivity.class);
                        startActivity(call);
                        break;
                    case R.id.nav_location:
                        Intent location = new Intent(MainActivity.this, LocationActivity.class);
                        startActivity(location);
                        break;
                    case R.id.nav_camera:
                        Intent camera=new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(camera);
                    default:
                        break;
                }

                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "探索更多的秘密吧", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                m.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    private void initLineImage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        ViewGroup.LayoutParams lp = line_tab.getLayoutParams();
        lp.width = screenW / 4;
        line_tab.setLayoutParams(lp);
        moveOne = lp.width;
    }

    private void initView() {
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);

        MyFragment1 myFragment1 = new MyFragment1();
        MyFragment2 myFragment2 = new MyFragment2();
        MyFragment3 myFragment3 = new MyFragment3();
        MyFragment4 myFragment4 = new MyFragment4();
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        fragmentList.add(myFragment3);
        fragmentList.add(myFragment4);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        myViewPager.setAdapter(myFragmentAdapter);

        tv_tab0 = (TextView) findViewById(R.id.tv_tab0);
        tv_tab1 = (TextView) findViewById(R.id.tv_tab1);
        tv_tab2 = (TextView) findViewById(R.id.tv_tab2);
        tv_tab3 = (TextView) findViewById(R.id.tv_tab3);

        myViewPager.setCurrentItem(0);
        tv_tab0.setTextColor(Color.BLACK);
        tv_tab1.setTextColor(Color.BLACK);
        tv_tab2.setTextColor(Color.BLACK);
        tv_tab3.setTextColor(Color.BLACK);

        tv_tab0.setOnClickListener(this);
        tv_tab1.setOnClickListener(this);
        tv_tab2.setOnClickListener(this);
        tv_tab3.setOnClickListener(this);

        myViewPager.setOnPageChangeListener(this);
        line_tab = (ImageView) findViewById(R.id.line_tab);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case 1:
                isScrolling = true;
                isBackScrolling = false;
                break;
            case 2:
                isScrolling = false;
                isBackScrolling = true;
                break;
            default:
                isScrolling = false;
                isBackScrolling = false;
                break;
        }
    }

    @Override
    public void onPageScrolled
            (int position, float positionOffset, int positionOffsetPixels) {
        currentTime = System.currentTimeMillis();
        if (isScrolling && (currentTime - startTime > 200)) {
            movePositionX(position, moveOne * positionOffset);
            startTime = currentTime;
        }
        if (isBackScrolling) {
            movePositionX(position);
        }
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(0);
                break;
            case 1:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(1);
                break;
            case 2:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(2);
                break;
            case 3:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(3);
                break;
            default:
                break;
        }
    }

    private void movePositionX(int toPosition, float positionOffsetPixels) {
        float curTranslationX = line_tab.getTranslationX();
        float toPositionX = moveOne * toPosition + positionOffsetPixels;
        ObjectAnimator animator = ObjectAnimator.ofFloat
                (line_tab, "translationX", curTranslationX, toPositionX);
        animator.setDuration(500);
        animator.start();
    }

    private void movePositionX(int toPosition) {
        movePositionX(toPosition, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_tab0:
                myViewPager.setCurrentItem(0);
                break;
            case R.id.tv_tab1:
                myViewPager.setCurrentItem(1);
                break;
            case R.id.tv_tab2:
                myViewPager.setCurrentItem(2);
                break;
            case R.id.tv_tab3:
                myViewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }
}