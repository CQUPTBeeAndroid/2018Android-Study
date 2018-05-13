package com.example.hp.level4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MyLocationStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包含NavigationLayout+地图，可以打开一个服务、跳至Main3Activity。
 */
public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,AMapLocationListener
            ,LocationSource{

    //AMap是地图对象
    private AMap aMap;
    private MapView mapView;

    private AMapLocationClient mLocationClient = null;      //声明AMapLocationClient类对象，定位发起端

    public AMapLocationClientOption mLocationOption = null; //声明mLocationOption对象，定位参数

    private LocationSource.OnLocationChangedListener mListener = null;     //声明mListener对象，定位监听器

    private static boolean isFirstLoc = true;       //标识，用于判断是否只显示一次定位信息和用户重新定位

    private static boolean isOpen = false;      //用于控制音乐的启动和停止

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //实例化MapView
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        if (aMap == null) {
            aMap = mapView.getMap();

            UiSettings settings = aMap.getUiSettings();
            aMap.setLocationSource((LocationSource) this);                   //设置了定位的监听
            settings.setMyLocationButtonEnabled(true);      // 是否显示定位按钮

            aMap.setMyLocationStyle(new MyLocationStyle()); //定位的小蓝点

            aMap.setMyLocationEnabled(true);                //显示定位层并且可以触发定位,默认是flase
        }


        location();         //开始定位

        getPermission();    //访问sd卡权限
    }

//    下面NavigationLayout涉及的

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.na_music) {          //打开音乐（MyService）
            Intent intent = new Intent(Main2Activity.this, MyService.class);
            if(!isOpen) {
                isOpen = true;
                Toast.makeText(Main2Activity.this,"开始了",Toast.LENGTH_SHORT).show();
                startService(intent);
            }else {
                isOpen = false;
                stopService(intent);
                Toast.makeText(Main2Activity.this,"结束了",Toast.LENGTH_SHORT).show();
            }
        }else if(id == R.id.nav_beauty){        //打开图片（Main3Activity）
            Intent intent1 = new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(intent1);
        }

        return true;
    }


//    往下是地图定位涉及的

    private void location() {

        mLocationClient = new AMapLocationClient(getApplicationContext());      //初始化定位
        mLocationClient.setLocationListener(this);              //设置定位回调监听
        mLocationOption = new AMapLocationClientOption();       //初始化定位参数

        //高精度模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        // mLocationOption.setGpsFirst(true);          //优先使用GPS这里，GPS出问题，设置true，则会到最大加载时间。

        mLocationOption.setNeedAddress(true);       //设置是否返回地址信息（默认返回地址信息）

        mLocationOption.setOnceLocation(true);      //设置是否只定位一次,默认为false

        mLocationOption.setWifiActiveScan(true);    //设置是否强制刷新WIFI，默认为强制刷新

        mLocationOption.setMockEnable(false);       //设置是否允许模拟位置,默认为false，不允许模拟位置

        mLocationOption.setInterval(3000);          //设置定位间隔,单位毫秒,默认为2000ms

        mLocationClient.setLocationOption(mLocationOption);//给定位客户端对象设置定位参数

        mLocationClient.startLocation();            //启动定位
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        mLocationClient.stopLocation(); //停止定位
        mLocationClient.onDestroy();    //销毁定位客户端。
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {

        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {         //定位成功回调信息，设置相关消息

                aMapLocation.getLocationType();     //获取当前定位结果来源，如网络定位结果，详见官方定位类型表
                aMapLocation.getLatitude();         //获取纬度
                aMapLocation.getLongitude();        //获取经度
                aMapLocation.getAccuracy();         //获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);                    //定位时间
                aMapLocation.getAddress();          //地址，如果option中设置isNeedAddress为false，则没有此结果
//网络定位结果中会有地址信息，GPS定位不返回地址信息。

                aMapLocation.getCountry();          //国家信息
                aMapLocation.getProvince();         //省信息
                aMapLocation.getCity();             //城市信息
                aMapLocation.getDistrict();         //城区信息
                aMapLocation.getStreet();           //街道信息
                aMapLocation.getStreetNum();        //街道门牌号信息
                aMapLocation.getCityCode();         //城市编码
                aMapLocation.getAdCode();           //地区编码

                if (isFirstLoc) {       // 第一次的标记位置

                    aMap.moveCamera(CameraUpdateFactory.zoomTo(17));        //设置缩放级别

                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude()
                            , aMapLocation.getLongitude())));               //将地图移动到定位点


                    mListener.onLocationChanged(aMapLocation);  //点击定位按钮 能够将地图的中心移动到定位点

                    StringBuffer buffer = new StringBuffer();
                    buffer.append(aMapLocation.getProvince() + ""
                            + aMapLocation.getDistrict() + ""
                            + aMapLocation.getStreet() + ""
                            + aMapLocation.getStreetNum());

                    Toast.makeText(getApplicationContext(), buffer.toString(), Toast.LENGTH_LONG).show();

                    isFirstLoc = false;             //取消第一次标记
                }
            } else {

                //打印错误信息
                Toast.makeText(getApplicationContext(), aMapLocation.getErrorInfo(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        location();
    }

    @Override
    public void deactivate() {
        mListener = null;
    }


//    获取访问sd卡权限
    private void getPermission(){
        if(ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Main2Activity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }
    }
}
