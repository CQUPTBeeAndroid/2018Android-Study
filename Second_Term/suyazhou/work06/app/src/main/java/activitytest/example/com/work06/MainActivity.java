package activitytest.example.com.work06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button choosephoto = (Button) findViewById(R.id.choose_photo);
        Button audioplay = (Button) findViewById(R.id.audio_play);
        Button videoplay = (Button) findViewById(R.id.video_play);
        choosephoto.setOnClickListener(this);
        audioplay.setOnClickListener(this);
        videoplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.choose_photo:
                Intent intent1 = new Intent(MainActivity.this , PhotoTest.class);
                startActivity(intent1);
                break;
            case R.id.audio_play:
                Intent intent2 = new Intent(MainActivity.this , AudioTest.class);
                startActivity(intent2);
                break;
            case R.id.video_play:
                Intent intent3 = new Intent(MainActivity.this , VideoTest.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
