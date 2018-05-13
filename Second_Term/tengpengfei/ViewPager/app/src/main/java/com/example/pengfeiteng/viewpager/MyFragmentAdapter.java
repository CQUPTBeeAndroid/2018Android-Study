package com.example.pengfeiteng.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public MyFragmentAdapter (FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);

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
