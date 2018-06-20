package com.example.gankpro.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gankpro.Banner.GlideImageLoader;
import com.example.gankpro.HttpUtil;
import com.example.gankpro.R;
import com.youth.banner.Banner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class FirstActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private TabLayout mTablayout;
    private ViewPager myViewPager;
    private MyFragmentAdapter myFragmentAdapter;
    private TextView user;
    private View headerLayout;
    private String username;
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final Intent intent = getIntent();
        username = intent.getStringExtra("user");
       // Log.d("这是",username);
        mContext = this;
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        final NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        Log.d("这是",username);
         headerLayout =
                navigationView.getHeaderView(0);//获取navigationView的头布局
        user = headerLayout.findViewById(R.id.username);//传入用户名称
        user.setText(username);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu2);
        }
        navigationView.setCheckedItem(R.id.back);//默认为返回登录
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.back:
                        Intent intent1 = new Intent(FirstActivity.this,MainActivity.class);
                        startActivity(intent1);
                        break;
                        default:
                            break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        initView();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch ((item.getItemId())){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                default:
        }
        return  true;
    }
public void initView(){
        myViewPager = (ViewPager)findViewById(R.id.view_pager);
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),mContext);
        myViewPager.setAdapter(myFragmentAdapter);
        mTablayout = (TabLayout)findViewById(R.id.tablayout);
        mTablayout.addTab(mTablayout.newTab().setText("首页").setIcon(R.drawable.first_ye));
        mTablayout.addTab(mTablayout.newTab().setText("知识体系").setIcon(R.drawable.zhishitixi));

        mTablayout.addTab(mTablayout.newTab().setText("项目").setIcon(R.drawable.xiangmu));
        myViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
        mTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(myViewPager));
}
}
