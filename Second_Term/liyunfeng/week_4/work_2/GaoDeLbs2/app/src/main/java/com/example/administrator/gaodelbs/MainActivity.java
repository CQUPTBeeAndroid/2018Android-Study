package com.example.administrator.gaodelbs;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.MyLocationStyle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements LocationSource,AMapLocationListener,GPS_Interface{
    private GPS_Presenter gps_presenter ;
    MapView mapView=null;//地图视图
    AMap aMap;//地图对象
    OnLocationChangedListener mlistener;//定位监听
    AMapLocationClient mlocationClient;//定位者
    AMapLocationClientOption  mLocationOption = null;//定位参数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gps_presenter = new GPS_Presenter( this , this ) ;
        mapView= (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);//创建地图
        init();
    }

    public void init(){
        aMap=mapView.getMap();//获取地图对象
        UiSettings settings=aMap.getUiSettings();//获取定位按钮
        aMap.setLocationSource(this);//设置定位监听
        settings.setMyLocationButtonEnabled(true);//显示定位按钮
        aMap.setMyLocationEnabled(true);//显示定位层并可触发定位
    }

    //activate初始化定位
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mlistener=onLocationChangedListener;
        mlocationClient=new AMapLocationClient(this);
        mlocationClient.setLocationListener(this);//定位回调监听
        mLocationOption=new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//高进度定位
        mlocationClient.setLocationOption(mLocationOption);//加载定位参数
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        requestPermission();//申请权限

    }

    //申请权限
    private void requestPermission(){
        List<String> permissionList=new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!permissionList.isEmpty()){
            String[] permissions=permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this,permissions,1);
        }else{
            mlocationClient.startLocation();//开始定位
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0){
                    for(int result:grantResults){
                        if(result!=PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"必须同意所有权限才能使用本程序",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    mlocationClient.startLocation();//开始定位
                }else{
                    Toast.makeText(this,"发生未知错误",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    //deactivate停止定位
    @Override
    public void deactivate() {
        mlistener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    //定位成功后回调函数
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if(mlistener!=null){
            if(aMapLocation!=null&&aMapLocation.getErrorCode()==0){

                Log.e("经度: ", String.valueOf(aMapLocation.getLatitude()));
                Log.e("纬度: ", String.valueOf(aMapLocation.getLongitude()));
                Log.e("地址：",aMapLocation.getAddress());
                mlistener.onLocationChanged(aMapLocation);
            }
            else Log.e("定位结果","定位失败");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        if(mlocationClient!=null)
            mlocationClient.onDestroy();
        //释放资源
        if ( gps_presenter != null ){
            gps_presenter.onDestroy();
        }
    }

    @Override
    public void gpsSwitchState(boolean gpsOpen) {
        if ( gpsOpen ){
            Toast.makeText(this, " 手机GPS 打开", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, " 手机GPS 关闭", Toast.LENGTH_SHORT).show();
        }
    }
}