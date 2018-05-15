package com.example.hp.level_3.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.hp.level_3.asset.ActivityCollector;
import com.example.hp.level_3.fragment.ChatFragment;
import com.example.hp.level_3.fragment.ContactFragment;
import com.example.hp.level_3.fragment.ExtraFragment;
import com.example.hp.level_3.R;
import com.example.hp.level_3.adapter.ViewPagerChangedListenter;
import com.example.hp.level_3.adapter.ViewPagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现ViewPager.
 * 不足：1.做得点都不想微信，哈哈哈~
 *      2.未实现缓存碎片，每次切换页面，会导致碎片的重载。
 *
 *@date 2018/5/5
 */
public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    private Button chatBtn;     //聊天
    private Button contactBtn;  //联系人
    private Button extraBtn;    //发现

    private ViewPager viewPager;
    private ViewPagerFragmentAdapter mFragmentAdapter;
    private FragmentManager fragmentManager;

    private List<Fragment> fragments = new ArrayList<>();   //用于存放碎片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_main3);

        initView();

        initFragment();

        initViewPager();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.chat_btn:
                viewPager.setCurrentItem(0);
                break;
            case R.id.contact_btn:
                viewPager.setCurrentItem(1);
                break;
            case R.id.extra_btn:
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

//    初始化ViewPager
    private void initViewPager(){

        fragmentManager = getSupportFragmentManager();
        mFragmentAdapter = new ViewPagerFragmentAdapter(fragmentManager,fragments);

        viewPager = (ViewPager)findViewById(R.id.viewpager);

        ViewPagerChangedListenter viewPagerChangedListenter = new ViewPagerChangedListenter();
        viewPagerChangedListenter.setContext(this);
        viewPagerChangedListenter.getBtn(chatBtn);
        viewPagerChangedListenter.getBtn(contactBtn);
        viewPagerChangedListenter.getBtn(extraBtn);
        viewPager.addOnPageChangeListener(viewPagerChangedListenter);

        viewPager.setAdapter(mFragmentAdapter);
        viewPager.setCurrentItem(1);

    }

//    初始化碎片
    private void initFragment(){

        Fragment chat = new ChatFragment();
        Fragment contact = new ContactFragment();
        Fragment extra = new ExtraFragment();

        fragments.add(chat);
        fragments.add(contact);
        fragments.add(extra);
    }

//    初始化三个底部按钮
    private void initView(){
        chatBtn = (Button)findViewById(R.id.chat_btn);
        contactBtn = (Button)findViewById(R.id.contact_btn);
        extraBtn = (Button)findViewById(R.id.extra_btn);

        contactBtn.setOnClickListener(this);
        chatBtn.setOnClickListener(this);
        extraBtn.setOnClickListener(this);
    }

//    确保按下返回键不会回到登录界面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }else {
            return super.onKeyDown(keyCode,event);
        }
    }

}
