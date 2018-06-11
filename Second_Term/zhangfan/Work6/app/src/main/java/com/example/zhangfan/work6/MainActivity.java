package com.example.zhangfan.work6;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhangfan.work6.FrameLayout.FirstFrameLayout;
import com.example.zhangfan.work6.FrameLayout.LastFrameLayout;
import com.example.zhangfan.work6.FrameLayout.ScendFrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FirstFrameLayout firstFrameLayout;
    private ScendFrameLayout scendFrameLayout;
    private LastFrameLayout lastFrameLayout;

    private TextView firstText;
    private TextView scendText;
    private TextView lastText;
    private View firstLayout;
    private View scendLayout;
    private View lastLayout;
    private  FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);

    }
    private void init(){


        firstText = findViewById(R.id.first_text);
        scendText = findViewById(R.id.scend_text);
        lastText = findViewById(R.id.last_text);

        firstLayout = findViewById(R.id.first_layout);
        scendLayout= findViewById(R.id.scend_layout);
        lastLayout = findViewById(R.id.last_layout);

       firstLayout.setOnClickListener(this);
       scendLayout.setOnClickListener(this);
       lastLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first_layout:
                setTabSelection(0);
                break;
            case R.id.scend_layout:
                setTabSelection(1);
                break;
            case  R.id.last_layout:
                setTabSelection(2);
                 break;
        }

    }
    private void setTabSelection(int index) {
        clearSelection();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                firstText.setTextColor(Color.parseColor("#08D683"));
                scendText.setTextColor(Color.parseColor("#888888"));
               lastText.setTextColor(Color.parseColor("#888888"));
                if (firstFrameLayout == null) {
                    firstFrameLayout = new FirstFrameLayout();
                    transaction.add(R.id.frame_totol, firstFrameLayout);
                } else {
                    transaction.show(firstFrameLayout);
                }
                break;
            case 1:
                firstText.setTextColor(Color.parseColor("#888888"));
                scendText.setTextColor(Color.parseColor("#08D683"));
                lastText.setTextColor(Color.parseColor("#888888"));
                if (scendFrameLayout == null) {
                    scendFrameLayout = new ScendFrameLayout();
                    transaction.add(R.id.frame_totol, scendFrameLayout);
                } else {
                    transaction.show(scendFrameLayout);
                }
                break;
            case 2:
                firstText.setTextColor(Color.parseColor("#888888"));
                scendText.setTextColor(Color.parseColor("#888888"));
                lastText.setTextColor(Color.parseColor("#08D683"));;
                if (lastFrameLayout == null) {
                    lastFrameLayout = new LastFrameLayout();
                    transaction.add(R.id.frame_totol, lastFrameLayout);
                } else {
                    transaction.show(lastFrameLayout);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragments(android.support.v4.app.FragmentTransaction transaction) {
        if (firstFrameLayout != null){
            transaction.hide(firstFrameLayout);
        }
        if (scendFrameLayout != null){
            transaction.hide(scendFrameLayout);
        }
        if (lastFrameLayout != null){
            transaction.hide(lastFrameLayout);
        }
    }

    private void clearSelection() {
        firstText.setTextColor(Color.parseColor("#888888"));
        scendText.setTextColor(Color.parseColor("#888888"));
        lastText.setTextColor(Color.parseColor("#888888"));
    }

}
