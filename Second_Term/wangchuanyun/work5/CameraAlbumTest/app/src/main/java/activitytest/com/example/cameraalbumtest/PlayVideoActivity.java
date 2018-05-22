package activitytest.com.example.cameraalbumtest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.FileFilter;

public class PlayVideoActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        videoView = (VideoView)findViewById(R.id.videoView);
        Button play1 = (Button)findViewById(R.id.play1);
        Button puase1 = (Button)findViewById(R.id.puase1);
        Button repaly = (Button)findViewById(R.id.replay);
        play1.setOnClickListener(this);
        puase1.setOnClickListener(this);
        repaly.setOnClickListener(this);
        if(ContextCompat.checkSelfPermission(PlayVideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PlayVideoActivity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            initVideoPath();
        }
    }
    private void initVideoPath(){
        File file = new File(Environment.getExternalStorageDirectory(),"movie.mp4");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[]permissons,int[]grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initVideoPath();
                }else{
                    Toast.makeText(this,"拒绝权限无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play1:
                if(!videoView.isPlaying()){
                    videoView.start();
                }
                break;
            case R.id.puase1:
                if(videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.replay:
                if(videoView.isPlaying()){
                    videoView.resume();
                }
                break;
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(videoView != null){
            videoView.suspend();
        }
    }
}
