package com.example.gankpro.Activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.gankpro.Activity.FirstActivityFragment.FirstFragment;
import com.example.gankpro.Activity.FirstActivityFragment.Fragment2;
import com.example.gankpro.Activity.FirstActivityFragment.Fragment4;
import com.example.gankpro.R;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] mBlowView = new String[]{"首页", "知识体系", "项目"};

    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Fragment2();
        } else if (position == 2) {
            return new Fragment4();
        }
        return new FirstFragment();
    }

    @Override
    public int getCount() {
        return mBlowView.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBlowView[position];
    }

}
