package com.example.hp.level4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 *使用LoadImage，解析百度图片网址，异步加载图片。
 */
public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ImageView imageView = (ImageView)findViewById(R.id.image);

        new LoadImage(imageView).execute();
    }
}
