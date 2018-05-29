package com.example.super_chao.a3d_map_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements LocationSource, AMapLocationListener {
    MapView mMapView = null;
    private AMap aMap;
    public AMapLocationClient mLocationClient;
    public AMapLocationClientOption mLocationOption=null;
    private static boolean FirstLoc = true;
    private LocationSource.OnLocationChangedListener mListener = null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);// 此方法必须重写

//初始化地图控制器对象

        if (aMap == null) {
            aMap = mMapView.getMap();
            aMap.setLocationSource((LocationSource) this);
            location();
        }




    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mMapView.onDestroy();
    }
    @Override
    protected void onResume(){
        super.onResume();
        mMapView.onResume();
    }
    @Override
    protected void onPause(){
        super.onPause();
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    @Override
    public void deactivate() {

    }
    private void location() {

        mLocationClient = new AMapLocationClient(getApplicationContext());      //初始化定位
        mLocationClient.setLocationListener(this);              //设置定位回调监听
        mLocationOption = new AMapLocationClientOption();       //初始化定位参数

        //高精度模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);





        mLocationOption.setInterval(2000);          //设置定位间隔,单位毫秒,默认为2000ms

        mLocationClient.setLocationOption(mLocationOption);//给定位客户端对象设置定位参数

        mLocationClient.startLocation();            //启动定位
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

                if (FirstLoc) {       // 第一次的标记位置

                    aMap.moveCamera(CameraUpdateFactory.zoomTo(17));        //设置缩放级别

                    //将地图移动到定位点
                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude()
                            , aMapLocation.getLongitude())));


                    mListener.onLocationChanged(aMapLocation);  //点击定位按钮 能够将地图的中心移动到定位点

                    StringBuffer buffer = new StringBuffer();
                    buffer.append(aMapLocation.getProvince() + ""
                            + aMapLocation.getDistrict() + ""
                            + aMapLocation.getStreet() + ""
                            + aMapLocation.getStreetNum());

                    Toast.makeText(getApplicationContext(), buffer.toString(), Toast.LENGTH_LONG).show();

                    FirstLoc = false;             //取消第一次标记
                }
            } else {

                //打印错误信息
                Toast.makeText(getApplicationContext(), aMapLocation.getErrorInfo(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
