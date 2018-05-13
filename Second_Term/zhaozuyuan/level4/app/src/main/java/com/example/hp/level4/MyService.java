package com.example.hp.level4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

/**
 * 我的后台服务，用于放音乐。
 * 将音乐放在app资源中，打开总是不对，就直接访问手机的sd卡了。
 */
public class MyService extends Service {

    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d("MyService","onCreate");
        initMediaPlayer();

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand");

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Log.d("MyService","关闭！");
        super.onDestroy();
    }

    private void initMediaPlayer(){

        try {
            mediaPlayer.setDataSource(this, Uri.parse("/storage/emulated/0/Passenger - Let Her Go.mp3"));
            mediaPlayer.prepare();
            Log.d("MyService","成功！");
        } catch (IOException e) {
            Log.d("MyService","失败！");
        }
    }
}
