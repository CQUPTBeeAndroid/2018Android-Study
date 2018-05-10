package com.example.viewpager;


import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MyFragmentAdapter(FragmentManager fm,
                             List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragmentList.get(arg0);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

