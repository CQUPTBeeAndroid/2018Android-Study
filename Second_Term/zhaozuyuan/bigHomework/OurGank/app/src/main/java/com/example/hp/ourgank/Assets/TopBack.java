package com.example.hp.ourgank.Assets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hp.ourgank.R;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/8 2:25
 * @简述: 自定义的顶部返回标题栏
 */
public class TopBack extends LinearLayout {

    public TopBack(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.top_back,this);

        Button back = findViewById(R.id.top_back_btn);
        Typeface iconfont = Typeface.createFromAsset(context.getAssets(),"back/iconfont.ttf");
        back.setTypeface(iconfont);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

}
