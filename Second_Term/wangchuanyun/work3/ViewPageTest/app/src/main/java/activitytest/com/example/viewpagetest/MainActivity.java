package activitytest.com.example.viewpagetest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import activitytest.com.example.viewpagetest.Adapter.MyFragmentAdapter;


public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager myViewPager;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        myViewPager = (ViewPager)findViewById(R.id.view_pager);
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myFragmentAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(myViewPager);

    }


}
