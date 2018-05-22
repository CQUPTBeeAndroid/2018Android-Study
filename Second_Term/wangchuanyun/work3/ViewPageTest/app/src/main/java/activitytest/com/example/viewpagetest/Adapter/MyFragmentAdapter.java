package activitytest.com.example.viewpagetest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import activitytest.com.example.viewpagetest.Fragment.Fragment1;
import activitytest.com.example.viewpagetest.Fragment.Fragment2;
import activitytest.com.example.viewpagetest.Fragment.Fragment3;
import activitytest.com.example.viewpagetest.Fragment.Fragment4;

/**
 * Created by 问荆 on 2018/5/10.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"消息", "通讯", "发现","我的"};

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Fragment2();
        } else if (position == 2) {
            return new Fragment3();
        }else if(position ==3){
            return new Fragment4();
        }
        return new Fragment1();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
