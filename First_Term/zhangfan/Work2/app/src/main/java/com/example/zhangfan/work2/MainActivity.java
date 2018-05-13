package com.example.zhangfan.work2;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title,messageText,contactsText,newsText,settingText;
    private ViewPager vp;
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private NewsFragment  newsFragment;
    private SettingFragment settingFragment;
    private FragmentManager fragmentManager;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    String[] titles = new String[]{"微信", "联系人", "发现", "我"};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        messageText.setTextColor(Color.parseColor("#66CDAA"));


        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                title.setText(titles[position]);
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initViews() {

        title = (TextView) findViewById(R.id.text_title);
        messageText = (TextView) findViewById(R.id.message_text);
        contactsText = (TextView) findViewById(R.id.contacts_text);
        newsText = (TextView) findViewById(R.id.news_text);
        settingText = (TextView) findViewById(R.id.setting_text);

        messageText.setOnClickListener(this);
        contactsText.setOnClickListener(this);
        newsText.setOnClickListener(this);
        settingText.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.mainViewPager);
        messageFragment = new MessageFragment();
        contactsFragment = new ContactsFragment();
        newsFragment = new NewsFragment();
        settingFragment = new SettingFragment();
        mFragmentList.add(messageFragment);
        mFragmentList.add(contactsFragment);
        mFragmentList.add(newsFragment);
        mFragmentList.add(settingFragment);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_text:
                vp.setCurrentItem(0, true);
                break;
            case R.id.contacts_text:
                vp.setCurrentItem(1, true);
                break;
            case R.id.news_text:
                vp.setCurrentItem(2, true);
                break;
            case R.id.setting_text:
                vp.setCurrentItem(3, true);
                break;
        }
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }
    private void changeTextColor(int position) {
        if (position == 0) {
            messageText.setTextColor(Color.parseColor("#57ED57"));
            contactsText.setTextColor(Color.parseColor("#000000"));
            newsText.setTextColor(Color.parseColor("#000000"));
            settingText.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            messageText.setTextColor(Color.parseColor("#000000"));
            contactsText.setTextColor(Color.parseColor("#57ED57"));
            newsText.setTextColor(Color.parseColor("#000000"));
            settingText.setTextColor(Color.parseColor("#000000"));
        } else if (position == 2) {
           messageText.setTextColor(Color.parseColor("#000000"));
           contactsText.setTextColor(Color.parseColor("#000000"));
            newsText.setTextColor(Color.parseColor("#57ED57"));
            settingText.setTextColor(Color.parseColor("#000000"));
        } else if (position == 3) {
           messageText.setTextColor(Color.parseColor("#000000"));
            contactsText.setTextColor(Color.parseColor("#000000"));
           newsText.setTextColor(Color.parseColor("#000000"));
          settingText.setTextColor(Color.parseColor("#57ED57"));
        }
    }
}
