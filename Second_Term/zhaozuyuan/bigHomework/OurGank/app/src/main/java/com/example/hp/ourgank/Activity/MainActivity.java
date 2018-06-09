package com.example.hp.ourgank.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.example.hp.ourgank.Adapter.MyFragmentPagerAdapter;
import com.example.hp.ourgank.Assets.ActivityCollector;
import com.example.hp.ourgank.Assets.GetDataByHttp;
import com.example.hp.ourgank.Assets.GetPositionFormMap;
import com.example.hp.ourgank.Bean.WeatherBean;
import com.example.hp.ourgank.Fragment.AndroidFragment;
import com.example.hp.ourgank.Fragment.IOSFragment;
import com.example.hp.ourgank.Fragment.OtherFragment;
import com.example.hp.ourgank.Fragment.RecommendFragment;
import com.example.hp.ourgank.Fragment.WelfareFragment;
import com.example.hp.ourgank.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private WeatherBean bean = null;                //一个我的天气bean

    private String district = null;                 //区县位置，用于访问天气
    private AMapLocation aMapLocation = null;       //位置信息对象
    private GetPositionFormMap getLocation = null;  //我的获取位置的类对象

    private GetDataByHttp getHttpData = null;       //我的访问网络得到数据对象

    private List<Fragment>fragments  = null;        //放主活动的碎片的容器

    private ViewPager viewPager = null;             //导航ViewPager对象

    private TextView toolBarData ,areaDetail ,weatherDetail ,weatherDetai2;

    private Button toolBarDetail,welfareBtn,recommendBtn,androidBtn,iosBtn,otherBtn;

    private LinearLayout dataDetailLayout;           //详情栏布局

    private ImageView navScrollBar;                 //滑动条

    private int bmpw = 0;                           // 游标宽度
    private int offset = 0;                         // 动画图片偏移量
    private int currIndex = 0;                      // 当前页卡编号

    private static final int SUCCESS = 1;           //成功
    private static final int FAIL = 0;              //失败

    private static int num = 0;                            //获取天气的次数

    private static boolean mapIsGet = false;        //位置是否得到

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        if(bar != null)
            bar.hide();         //隐藏标题栏

        ActivityCollector.removeBeforeAcivity();        //销毁之前的登录、注册活动。

        initView();             //初始化控件

        initFragment();         //初始化碎片

        initViewPager();        //初始化viewpager

        initPositionX();        //初始化滑动条位置

        getPermission();  //获取权限

        //开始定位,在在定位成功后又去访问天气
        getLocation = new GetPositionFormMap(this, mapHandler);
        getLocation.startLocation();

    }

    @SuppressLint("HandlerLeak")
    Handler mapHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUCCESS:
                    aMapLocation = getLocation.getMapLocation();
                    String districts = aMapLocation.getDistrict();      //得到区县

                    //保证天气在未获取到数据情况下能够加载出天气
                    if("".equals(weatherDetail.getText())||weatherDetail.getText() != null
                            &&district == null||!districts.equals(district)){

                        district = districts;
                        if(num <= 100) {            //请求天气失败就不一直请求了，次数有上限。
                            getWeatherData(district, SUCCESS);
                            Log.d("TAG","获取了一次天气");
                        }
                    }
                     mapIsGet = true;
                    break;
                case FAIL:
                    Log.d("TAG", "定位失败");
                    Toast.makeText(MainActivity.this,"获取位置失败",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    @SuppressLint("HandlerLeak")
    Handler weatherHandler = new Handler(){
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SUCCESS:
                    bean = new WeatherBean();
                    bean = (WeatherBean) getHttpData.getBean();     //获取到天气对象

                    if(bean.getStatus() == 200){
                        showBarData();
                    }else {
                        if(num < 2){
                            Toast.makeText(MainActivity.this,"获取天气数据失败",Toast.LENGTH_SHORT).show();
                            if(mapIsGet){           //天气未加载出来就只把位置显示出来（当然位置要已经得到了）
                                toolBarData.setText(aMapLocation.getAoiName());
                                areaDetail.setText(aMapLocation.getCity()+"\t"
                                        +aMapLocation.getDistrict()+"\t"
                                        +aMapLocation.getStreet()+"\t"
                                        +aMapLocation.getStreetNum());

                                mapIsGet = false;
                            }
                        }
                        num++;
                    }
                    break;
                case FAIL:
                    Log.d("TAG","天气失败"+getHttpData.getGetRawData());
                    break;
                default:
                    break;
            }
        }
    };

    /**
     *  获取天气
     * @param districts 区县名字
     */
    private void getWeatherData(String districts,int mapIsGet) {
        String apiUrl = null;
        String city = null;

        try {
            //参数url化
            city = java.net.URLEncoder.encode(districts, "utf-8");

            //拼地址
            apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
        }catch (Exception e){city = "-1";apiUrl = "-1";}

        getHttpData = new GetDataByHttp(apiUrl,weatherHandler,bean,WeatherBean.class);
        getHttpData.startSendRequest();
        }

    /**
     * 初始化控件
     */
    private void initView(){
        Typeface iconfont = Typeface.createFromAsset(this.getAssets(), "updown/iconfont.ttf");

        // 获取手机屏幕参数merics
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        toolBarData = (TextView) findViewById(R.id.show_data);
        areaDetail = (TextView) findViewById(R.id.detail_area);
        weatherDetail = (TextView) findViewById(R.id.detail_weather1);
        weatherDetai2 = (TextView) findViewById(R.id.detail_weather2);
        navScrollBar = (ImageView) findViewById(R.id.nav_scroll_bar);

        toolBarDetail = (Button) findViewById(R.id.tool_bar_detail);
        welfareBtn = (Button) findViewById(R.id.welfare_btn);
        recommendBtn = (Button) findViewById(R.id.recommend_btn);
        androidBtn = (Button) findViewById(R.id.android_btn);
        iosBtn = (Button) findViewById(R.id.ios_btn);
        otherBtn = (Button) findViewById(R.id.other_btn);

        dataDetailLayout = (LinearLayout)findViewById(R.id.data_detail);

        toolBarDetail.setOnClickListener(this);
        welfareBtn.setOnClickListener(this);
        recommendBtn.setOnClickListener(this);
        androidBtn.setOnClickListener(this);
        iosBtn.setOnClickListener(this);
        otherBtn.setOnClickListener(this);

        toolBarDetail.setTypeface(iconfont);

        //将滑动导航条设置宽度为1/5
        ViewGroup.LayoutParams params = navScrollBar.getLayoutParams();
        params.width = metrics.widthPixels/5;
        navScrollBar.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tool_bar_detail:
                if(dataDetailLayout.getVisibility() == View.GONE){
                    dataDetailLayout.setVisibility(View.VISIBLE);
                    toolBarDetail.setText(R.string.up);
                }else {
                    dataDetailLayout.setVisibility(View.GONE);
                    toolBarDetail.setText(R.string.down);
                }
                break;
            case R.id.welfare_btn:
                if(currIndex != 0){
                    viewPager.setCurrentItem(0);
                    currIndex = 0;
                }
                break;
            case R.id.recommend_btn:
                if(currIndex != 1){
                    viewPager.setCurrentItem(1);
                    currIndex = 1;
                }
                break;
            case R.id.android_btn:
                if(currIndex != 2){
                    viewPager.setCurrentItem(2);
                    currIndex = 2;
                }
                break;
            case R.id.ios_btn:
                if(currIndex != 3){
                    viewPager.setCurrentItem(3);
                    currIndex = 3;
                }
                break;
            case R.id.other_btn:
                if(currIndex != 4){
                    viewPager.setCurrentItem(4);
                    currIndex = 4;
                }
                break;
        }
    }

    /**
     * 展示顶部标题栏的数据。
     */
    @SuppressLint("SetTextI18n")
    private void showBarData(){
        toolBarData.setText(aMapLocation.getAoiName()+"\t\t\t"+bean.getData().getWendu()+"℃");

        areaDetail.setText(aMapLocation.getCity()+"\t"
                +aMapLocation.getDistrict()+"\t"
                +aMapLocation.getStreet()+"\t"
                +aMapLocation.getStreetNum());

        WeatherBean.Data.Forecast forecast = bean.getData().getForecast().get(0);
        weatherDetail.setText(forecast.getLow().substring(3)+"～"+forecast.getHigh().substring(3)
                +"\t"+forecast.getType()
                +"\t"+forecast.getFx()
                +"\t"+forecast.getFl());

        weatherDetai2.setText(forecast.getNotice()+"。");
    }

    /**
     * 实例化碎片，放入容器。
     */
    private void initFragment(){
        fragments = new ArrayList<>();

        Fragment welfareFragment = new WelfareFragment();
        Fragment recommendFragment = new RecommendFragment();
        Fragment androidFragment = new AndroidFragment();
        Fragment iosFragment = new IOSFragment();
        Fragment otherFragment = new OtherFragment();

        fragments.add(welfareFragment);
        fragments.add(recommendFragment);
        fragments.add(androidFragment);
        fragments.add(iosFragment);
        fragments.add(otherFragment);

    }

    /**
     * 初始化ViewPager,监听变换事件，更新ui。
     */
    private void initViewPager(){
        ViewPager.OnPageChangeListener listener  =  new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int arg0) {

                int one = offset * 2 + bmpw;// 页卡1 -> 页卡2 偏移量
                int two = one * 2;// 页卡1 -> 页卡3 偏移量

                Animation animation = null;
                switch (arg0) {
                    case 0:
                        animation = new TranslateAnimation(one*currIndex, 0, 0, 0);
                        break;
                    case 1:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, one, 0, 0);
                        } else {
                            animation = new TranslateAnimation(one*currIndex, one, 0, 0);
                        }
                        break;
                    case 2:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, one*2, 0, 0);
                        } else {
                            animation = new TranslateAnimation(one*currIndex, one*2, 0, 0);
                        }
                        break;
                    case 3:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, one*3, 0, 0);
                        } else {
                            animation = new TranslateAnimation(one*currIndex, one*3, 0, 0);
                        }
                        break;
                    case 4:
                        if (currIndex == 0) {
                            animation = new TranslateAnimation(offset, one*4, 0, 0);
                        } else {
                            animation = new TranslateAnimation(one*currIndex, one*4, 0, 0);
                        }
                        break;
                }
                currIndex = arg0;               //使页面索引标记为当前
                animation.setFillAfter(true);   // True:图片停在动画结束位置
                animation.setDuration(300);
                navScrollBar.startAnimation(animation);
            }

            @Override
            //当页面的滑动状态改变时该方法会被触发，页面的滑动状态有3个：“0”表示什么都不做，“1”表示开始滑动，2滑动结束
            public void onPageScrollStateChanged(int state) {

            }
        };

        FragmentManager manager = getSupportFragmentManager();
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(manager,fragments);

        //初始化viewpager
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(listener);
        viewPager.setCurrentItem(0);
    }

    /**
     * 初始化滑动条位置
     */
    private void initPositionX() {
        // 初始化动画
        bmpw = navScrollBar.getWidth();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 5 - bmpw) / 2;// 计算偏移量

        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        navScrollBar.setImageMatrix(matrix);// 设置动画初始位置
    }

    /**
     *  第一行代码 上的获取手机权限的方法
     */
    private void getPermission(){
        List<String>pemissionList = new ArrayList<>();
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            pemissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            pemissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(!pemissionList.isEmpty()){
            String[] permissions = pemissionList.toArray(new String[pemissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissions,1); //标记为1
        }
    }

    /**
     * @param requestCode
     * @param permissions
     * @param grantResults
     * 处理取权限返回的数据
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1){
            if(grantResults.length > 0){
                for(int r:grantResults){
                    if(r != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"权限未全部开启，请检查",Toast.LENGTH_SHORT).show();
                    }
                }
            }else {
                Toast.makeText(this,"发生某些未知错误",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
