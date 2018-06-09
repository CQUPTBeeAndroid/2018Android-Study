package com.example.materiatest3;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("MyService", "startDownload excuted");

        }

        public int getProgress() {
            Log.d("Myservice", "getProgress excuted");
            return 0;
        }
    }
    @Override
    public IBinder onBind(Intent intent){
        return mBinder;
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Myservice", "onCreate executed");
        Intent intent=new Intent(this,LocationActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,intent,0);

        Notification notification=new NotificationCompat.Builder(this)
                .setContentTitle("我的位置信息")
                .setContentText("经度"+"sdf"+"\t"+"纬度"+"fdgfd")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources()
                        ,R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("Myservice", "onStartCommand executed");

        new Thread(new Runnable() {
            @Override
            public void run() {


                //stopSelf();   //终止服务
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "onDestroy exected");
    }
}

