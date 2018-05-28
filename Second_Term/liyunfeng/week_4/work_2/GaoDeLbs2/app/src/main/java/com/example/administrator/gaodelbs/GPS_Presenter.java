package com.example.administrator.gaodelbs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;

/**
 * Created by ${zhaoyanjun} on 2017/3/29.
 * GPS 开关监听
 */
public class GPS_Presenter {
    private Context mContext ;
    private Receiver receiver ;
    private GPS_Interface mInterface ;
    private String GPS_ACTION = "android.location.PROVIDERS_CHANGED" ;


    public GPS_Presenter(Context context , GPS_Interface mInterface ){
        this.mContext = context ;
        this.mInterface = mInterface ;

        observeWifiSwitch();
    }

    private void observeWifiSwitch(){
        IntentFilter filter = new IntentFilter();
        filter.addAction( GPS_ACTION );
        receiver = new Receiver() ;
        mContext.registerReceiver(receiver, filter);
    }

    /**
     * 释放资源
     */
    public void onDestroy(){
        if ( receiver != null ){
            mContext.unregisterReceiver( receiver );
        }
        if (mContext!=null){
            mContext = null;
        }
    }

    class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().matches( GPS_ACTION )) {
                if ( mInterface != null ){
                    mInterface.gpsSwitchState( gpsIsOpen( context ));
                }
            }
        }
    }

    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     * @param context
     * @return true 表示开启
     */
    public boolean gpsIsOpen(final Context context) {
        LocationManager locationManager
                = (LocationManager) context.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps ) {
            return true;
        }

        return false;
    }
}
