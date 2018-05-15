package activitytest.example.com.work04;

import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnPageChangeListener, OnClickListener {

    private ViewPager myViewPage;
    private View page1, page2, page3, page4;
    private ViewPager myViewPager;
    private MyPageAdapter myPageAdapter;
    private MyFragmentAdapter myFragmentAdapter;
    private List<View> pageList = new ArrayList<>();
    private List<Contact> contactList = new ArrayList<>();
    private TextView tv_tab0, tv_tab1, tv_tab2, tv_tab3;
    private ImageView line_tab;
    private int moveOne;
    private boolean isScrolling = false;
    private boolean isBackScrolling = false;
    private long startTime = 0;
    private long currentTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLineImage();
    }


    private void initLineImage() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;

        ViewGroup.LayoutParams lp = line_tab.getLayoutParams();
        lp.width = screenW / 4;
        line_tab.setLayoutParams(lp);
        moveOne = lp.width;
    }


    private void initView() {
        myViewPager = (ViewPager) findViewById(R.id.myViewPage);
        MyFragment1 myFragment1 = new MyFragment1();
        MyFragment2 myFragment2 = new MyFragment2();
        MyFragment3 myFragment3 = new MyFragment3();
        MyFragment4 myFragment4 = new MyFragment4();

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        fragmentList.add(myFragment3);
        fragmentList.add(myFragment4);

        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        myViewPage.setAdapter(myFragmentAdapter);

        tv_tab0 = (TextView) findViewById(R.id.tv_tab0);
        tv_tab1 = (TextView) findViewById(R.id.tv_tab1);
        tv_tab2 = (TextView) findViewById(R.id.tv_tab2);

        myViewPager.setCurrentItem(0);
        tv_tab0.setTextColor(Color.BLACK);
        tv_tab1.setTextColor(Color.BLACK);
        tv_tab2.setTextColor(Color.BLACK);
        tv_tab3.setTextColor(Color.BLACK);

        tv_tab0.setOnClickListener(this);
        tv_tab1.setOnClickListener(this);
        tv_tab2.setOnClickListener(this);
        tv_tab3.setOnClickListener(this);



        myViewPager.setOnPageChangeListener(this);
        line_tab = (ImageView) findViewById(R.id.line_tab);
    }



    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case 1:
                isScrolling = true;
                isBackScrolling = false;
                break;
            case 2:
                isScrolling = false;
                isBackScrolling = true;
                break;
            default:
                isScrolling = false;
                isBackScrolling = false;
                break;
        }
    }

    @Override
    public void onPageScrolled(int position , float positionOffset, int positionOffsetPixels) {
        currentTime = System.currentTimeMillis();
        if(isScrolling && (currentTime - startTime > 200)) {
            movePositionX(position, moveOne * positionOffset);
            startTime = currentTime;
        }
        if(isBackScrolling){
            movePositionX(position);
        }
    }


    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tv_tab0.setTextColor(Color.RED);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(0);
                break;
            case 1:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLUE);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(1);
                break;
            case 2:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.GREEN);
                tv_tab3.setTextColor(Color.BLACK);
                movePositionX(2);
                break;
            case 3:
                tv_tab0.setTextColor(Color.BLACK);
                tv_tab1.setTextColor(Color.BLACK);
                tv_tab2.setTextColor(Color.BLACK);
                tv_tab3.setTextColor(Color.GREEN);
                movePositionX(3);
                break;
            default:
                break;


        }

    }


    private void movePositionX(int toPosition , float positionOffsetPixels) {
        float curTranlationX = line_tab.getTranslationX();
        float toPositionX = moveOne * toPosition + positionOffsetPixels ;
        ObjectAnimator animator = ObjectAnimator.ofFloat(line_tab , "translationX" , curTranlationX , toPositionX);
        animator.setDuration(500);
        animator.start();
    }

    private void movePositionX(int position) {
        movePositionX(position , 0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_tab0:
                myViewPage.setCurrentItem(0);
                initContacts();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                ContactAdapter adapter = new ContactAdapter(contactList);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.tv_tab1:
                myViewPage.setCurrentItem(1);
                break;
            case R.id.tv_tab2:
                myViewPage.setCurrentItem(2);
                break;
            case R.id.tv_tab3:
                myViewPage.setCurrentItem(3);
                break;
            default:
                break;

        }
    }

    private void initContacts() {
        for (int i = 0 ; i < 10 ; i++) {
            Contact contact = new Contact("联系人" +i);
        }
    }
}
