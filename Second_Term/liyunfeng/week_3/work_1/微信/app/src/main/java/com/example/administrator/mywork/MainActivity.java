package com.example.administrator.mywork;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,View.OnClickListener,BottomNavigationBar.OnTabSelectedListener {

    private ViewPager myViewPager;
    private BottomNavigationItem weixin,tongxunlu,faxian,wo;
    private  BottomNavigationBar bottomNavigationBar;
    private MyFragment1 myFragment1;
    private MyFragment2 myFragment2;
    private MyFragment3 myFragment3;
    private MyFragment4 myFragment4;
    private void BindFragment(){
        MyFragment1 myFragment1=new MyFragment1();
        MyFragment2 myFragment2=new MyFragment2();
        MyFragment3 myFragment3=new MyFragment3();
        MyFragment4 myFragment4=new MyFragment4();
        List<Fragment> fragmentList=new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        fragmentList.add(myFragment3);
        fragmentList.add(myFragment4);
        MyFragmentAdapter myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        myViewPager=(ViewPager)findViewById(R.id.MyViewPager);
        myViewPager.setAdapter(myFragmentAdapter);
    }
    private void additem(){
        weixin=new BottomNavigationItem(R.drawable.weixin,"微信");
        tongxunlu=new BottomNavigationItem(R.drawable.tongxunlu,"通讯录");
        faxian=new BottomNavigationItem(R.drawable.faxian,"发现");
        wo=new BottomNavigationItem(R.drawable.wo,"我");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        bottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar_container);
        bottomNavigationBar.setAutoHideEnabled(true);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setBarBackgroundColor(R.color.white);
        bottomNavigationBar.setActiveColor(R.color.colorPrimaryDark);
        bottomNavigationBar.setTabSelectedListener(this);
        additem();
        bottomNavigationBar.addItem(weixin).addItem(tongxunlu).addItem(faxian).addItem(wo);
        bottomNavigationBar.initialise();
        BindFragment();
        myViewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                bottomNavigationBar.selectTab(0);
                break;
            case 1:
                bottomNavigationBar.selectTab(1);
                break;
            case 2:
                bottomNavigationBar.selectTab(2);
                break;
            case 3:
                bottomNavigationBar.selectTab(3);
                break;



        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0:
                myViewPager.setCurrentItem(0);
                break;
            case 1:
                myViewPager.setCurrentItem(1);
                break;
            case 2:
                myViewPager.setCurrentItem(2);
                break;
            case 3:
                myViewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
