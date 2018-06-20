package com.example.gankpro.Activity.FirstActivityFragment.ChildrenFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import com.example.gankpro.HttpUtil;
import com.example.gankpro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MyChildrenFragmentAdapter extends FragmentStatePagerAdapter {
    List<ChildrenItem>childrenItemList1 = new ArrayList<>();
    List<ChildrenItem>childrenItemList2 = new ArrayList<>();
    List<ChildrenItem>childrenItemList3 = new ArrayList<>();
    List<ChildrenItem>childrenItemList4 = new ArrayList<>();
    private String[]TextTab = new String[]{"完整项目","下拉刷新","富文本编辑器","RV列表动效"};
    public MyChildrenFragmentAdapter(FragmentManager fm, Context context,
                                     List<ChildrenItem>childrenItemList1 ,
    List<ChildrenItem>childrenItemList2,
    List<ChildrenItem>childrenItemList3 ,
    List<ChildrenItem>childrenItemList4   ) {
        super(fm);
        this.childrenItemList1 = childrenItemList1;
        this.childrenItemList2 = childrenItemList2;
       this.childrenItemList3 = childrenItemList3;
       this.childrenItemList4 = childrenItemList4;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1){
             ChildrenFragment childrenFragment =  new ChildrenFragment();
             childrenFragment.getData(childrenItemList2);
             return childrenFragment;
        }else if(position ==2){
            ChildrenFragment childrenFragment =  new ChildrenFragment();
            childrenFragment.getData(childrenItemList3);
            return childrenFragment;
        }else if(position ==3){
            ChildrenFragment childrenFragment =  new ChildrenFragment();
            childrenFragment.getData(childrenItemList4);
            return childrenFragment;
        }
        ChildrenFragment childrenFragment =  new ChildrenFragment();
        childrenFragment.getData(childrenItemList1);
        return childrenFragment;
    }

    @Override
    public int getCount() {
        return TextTab.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return TextTab[position];
    }
}
