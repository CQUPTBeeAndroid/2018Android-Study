package com.example.administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FristActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showImage:
                Intent intent =new Intent(this,ImageActivity.class);
                startActivity(intent);
                break;
            case R.id.showVideo:
                Intent intent1 =new Intent(this,VideoActivity.class);
                startActivity(intent1);
                break;
            case R.id.showMusic:
                Intent intent2 =new Intent(this,musicActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
