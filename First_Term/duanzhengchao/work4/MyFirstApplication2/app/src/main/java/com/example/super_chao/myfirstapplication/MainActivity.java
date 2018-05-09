package com.example.super_chao.myfirstapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public  class MainActivity  extends AppCompatActivity implements OnClickListener,OnPageChangeListener {
       // private String[] data = {"apple","banana"};
       private ViewPager myViewPager;
        //Fragment
        private Fragment fragment_first;
private Fragment fragment_second;
private Fragment fragment_third;
        private Fragment fragment_fourth;

        //底端菜单栏LinearLayout
        private LinearLayout linear_first;
private LinearLayout linear_second;
private LinearLayout linear_third;
        private LinearLayout linear_forth;

        //底端菜单栏Imageview
        private ImageView iv_first;
private ImageView iv_second;
private ImageView iv_third;
        private ImageView iv_forth;

        //底端菜单栏textView
        private TextView tv_first;
private TextView tv_second;
private TextView tv_third;
        private TextView tv_forth;

     //   ActionBar actionBar;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//隐藏actionbar
       // actionBar = getActionBar(); //得到ActionBar
        //actionBar.hide(); //隐藏ActionBar
       // ListView listView = (ListView)findViewById(R.id.list_view);
       // ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
       // listView.setAdapter(adapter);


        //初始化各个控件
        InitView();

        //初始化点击触发事件
        InitEvent();

        //初始化Fragment
       /* InitFragment(1);*/

        //将第一个图标设置为选中状态
     //   iv_first.setImageResource(R.drawable.apple_pic);
        tv_first.setTextColor(getResources().getColor(R.color.colorAccent));
        }

private void InitView(){
        myViewPager = (ViewPager) findViewById(R.id.frame_content);

        linear_first = (LinearLayout) findViewById(R.id.line1);
        linear_second = (LinearLayout) findViewById(R.id.line2);
        linear_third = (LinearLayout) findViewById(R.id.line3);
        linear_forth = (LinearLayout) findViewById(R.id.line4);

        iv_first = (ImageView) findViewById(R.id.ic_1);
        iv_second = (ImageView) findViewById(R.id.ic_2);
        iv_third= (ImageView) findViewById(R.id.ic_3);
        iv_forth= (ImageView) findViewById(R.id.ic_4);

        tv_first = (TextView) findViewById(R.id.textview_1);
        tv_second = (TextView) findViewById(R.id.textview_2);
        tv_third = (TextView) findViewById(R.id.textview_3);
        tv_forth = (TextView) findViewById(R.id.textview_4);

//
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        myViewPager.setAdapter(myFragmentAdapter);
//
        }

/*private void InitFragment(int index){
        //v4包下的Fragment，使用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        //启动事务
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        //将所有的Fragment隐藏
        hideAllFragment(transaction);
        switch (index){
        case 1:
        if (fragment_first== null){
        fragment_first = new Fragment1();
        transaction.add(R.id.frame_content,fragment_first);
        }
        else{
        transaction.show(fragment_first);
        }
        break;

        case 2:
        if (fragment_second== null){
        fragment_second = new Fragment2();
        transaction.add(R.id.frame_content,fragment_second);
        }
        else{
        transaction.show(fragment_second);
        }
        break;

        case 3:
        if (fragment_third== null){
        fragment_third = new Fragment3();
        transaction.add(R.id.frame_content,fragment_third);
        }
        else{
        transaction.show(fragment_third);
        }
        break;

        case 4:
                if (fragment_fourth== null){
                        fragment_fourth = new Fragment4();
                        transaction.add(R.id.frame_content,fragment_fourth);
                        }
                else{
                        transaction.show(fragment_fourth);
                }
                break;

        }
        //提交事务
        transaction.commit();
        }*/
private void InitEvent(){
        //设置LinearLayout监听
        linear_first.setOnClickListener(this);
        linear_second.setOnClickListener(this);
        linear_third.setOnClickListener(this);
        linear_forth.setOnClickListener(this);
        }

@Override
public void onClick(View view) {


        //每次点击之后，将所有的ImageView和TextView设置为未选中
        restartButton();
        //再根据所选，进行跳转页面，并将ImageView和TextView设置为选中
        switch(view.getId()){
        case R.id.line1:
      //  Toast.makeText(MainActivity.this,"first", Toast.LENGTH_SHORT).show();
        iv_first.setImageResource(R.drawable.apple_pic);
        tv_first.setTextColor(getResources().getColor(R.color.colorAccent));
        //InitFragment(1);
                myViewPager.setCurrentItem(0);
        break;

        case R.id.line2:
        iv_second.setImageResource(R.drawable.banana_pic);
        tv_second.setTextColor(getResources().getColor(R.color.colorAccent));
       // InitFragment(2);
                myViewPager.setCurrentItem(1);
        break;

        case R.id.line3:
        iv_third.setImageResource(R.drawable.grape_pic);
        tv_third.setTextColor(getResources().getColor(R.color.colorAccent));
       // InitFragment(3);
                myViewPager.setCurrentItem(2);
        break;
                case R.id.line4:
                        iv_forth.setImageResource(R.drawable.pear_pic);
                        tv_forth.setTextColor(getResources().getColor(R.color.colorAccent));
                       // InitFragment(4);
                        myViewPager.setCurrentItem(3);
                        break;
        }
        }

//隐藏所有的Fragment
/*private void hideAllFragment(android.support.v4.app.FragmentTransaction transaction){
        if (fragment_first!= null){
        transaction.hide(fragment_first);
        }

        if (fragment_second!= null){
        transaction.hide(fragment_second);
        }

        if (fragment_third!= null){
        transaction.hide(fragment_third);
        }
        if (fragment_fourth!= null){
                transaction.hide(fragment_fourth);
        }*/

        // transaction.commit();
        //}

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

       //重新设置ImageView和TextView的状态
private void restartButton(){
        //设置为未点击状态
        iv_first.setImageResource(R.drawable.apple_pic);
        iv_second.setImageResource(R.drawable.banana_pic);
        iv_third.setImageResource(R.drawable.grape_pic);
        iv_forth.setImageResource(R.drawable.pear_pic);

        //设置为灰色
        tv_first.setTextColor(getResources().getColor(R.color.colorPrimary));
        tv_second.setTextColor(getResources().getColor(R.color.colorPrimary));
        tv_third.setTextColor(getResources().getColor(R.color.colorPrimary));
        tv_forth.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        @Override
        public void onPageSelected(int position){
/*        switch (position){
                case 0:

                        tv_first.setTextColor(getResources().getColor(R.color.colorAccent));
                        tv_second.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_third.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_forth.setTextColor(getResources().getColor(R.color.colorPrimary));

                        break;

                case 1:
                        iv_second.setImageResource(R.drawable.banana_pic);
                        tv_first.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_second.setTextColor(getResources().getColor(R.color.colorAccent));
                        tv_third.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_forth.setTextColor(getResources().getColor(R.color.colorPrimary));

                        break;
                case 2:
                        iv_third.setImageResource(R.drawable.grape_pic);

                        tv_first.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_second.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_third.setTextColor(getResources().getColor(R.color.colorAccent));
                        tv_forth.setTextColor(getResources().getColor(R.color.colorPrimary));
                        break;
                case 4:
                        iv_forth.setImageResource(R.drawable.pear_pic);

                        tv_first.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_second.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_third.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tv_forth.setTextColor(getResources().getColor(R.color.colorAccent));
                        break;
                default:
                                break;



        }*/
}

        @Override
        public void onPageScrollStateChanged(int state) {

        }
}
