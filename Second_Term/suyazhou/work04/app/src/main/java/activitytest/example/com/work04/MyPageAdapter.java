package activitytest.example.com.work04;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPageAdapter extends PagerAdapter {
    private List<View> pageList;

    public MyPageAdapter(List<View> pageList) {
        this.pageList = pageList;
    }

    public int getCount() {
        return pageList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0 , Object arg1) {
        return arg0 == arg1;
    }

    public Object instantiateItem(ViewGroup container , int position) {
        View view = pageList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container , int position , Object object) {
        container.removeView(pageList.get(position));
    }
}
