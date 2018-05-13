package com.example.hp.level_3.adapter;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import com.example.hp.level_3.R;
import java.util.ArrayList;

public class ViewPagerChangedListenter implements ViewPager.OnPageChangeListener {

    private ArrayList<Button>buttons = new ArrayList<>();
    Context context;
    private int i = 1;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {
        if(buttons.size() == 3){
            buttons.get(i).setTextSize(16);
            buttons.get(i).setTextColor(context.getResources().getColor(R.color.colorHintText));
            buttons.get(position).setTextSize(19);
            buttons.get(position).setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            i = position;
        }
    }

    @Override
    public void onPageScrollStateChanged(int position) {
    }

    public void getBtn(Button button){
        this.buttons.add(button);
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
