package com.example.zhangfan.work4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener{
    private VideoView videoView;
    private Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView)findViewById(R.id.video_view);
        video = (Button)findViewById(R.id.video);
        Button play = (Button)findViewById(R.id.btn_play);
        Button pause = (Button)findViewById(R.id.btn_pause);
        Button replay = (Button)findViewById(R.id.btn_replay);
        video.setOnClickListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(VideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(VideoActivity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }else{
          initVideo();
        }
    }

    private void initVideo() {
        String str[] = { MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DATA};
        Cursor cursor = VideoActivity.this.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str, null, null, null);
        videoView.setVideoPath("/mnt/sdcard/DCIM/Camera/VID_20180520_093325.mp4");
    }


    @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                   initVideo();
                }else {
                    Toast.makeText(this,"拒绝权限无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();

                }
                break;
            default:
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null){
            videoView.suspend();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                if (!videoView.isPlaying()){
                    videoView.start();
                }break;
            case R.id.btn_pause:
                if (videoView.isPlaying()){
                    videoView.pause();
                }break;
            case R.id.btn_replay:
                if (videoView.isPlaying()& !videoView.isPlaying()){
                    videoView.start();
                }break;
            case R.id.video:
                initVideo();
                }
        }

    }
