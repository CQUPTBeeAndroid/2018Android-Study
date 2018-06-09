package com.example.materiatest3;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class MyPagerAdapter extends PagerAdapter {
    private List<View> pageList;

    public MyPagerAdapter(List<View> pageList) {
        this.pageList = pageList;
    }

    @Override
    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject
            (View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public Object instantiateItem
            (ViewGroup container, int position) {
         View view = pageList.get(position);
         container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pageList.get(position));

    }
}
