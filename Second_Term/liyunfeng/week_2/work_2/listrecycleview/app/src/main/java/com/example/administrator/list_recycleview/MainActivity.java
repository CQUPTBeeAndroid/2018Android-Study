package com.example.administrator.list_recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RecyclerView:
                Intent intent=new Intent(MainActivity.this,MyRecyclerView.class);
                startActivity(intent);
                break;
            case R.id.ListView:
                Intent intent1=new Intent(MainActivity.this,MyListView.class);
                startActivity(intent1);
                break;
            default:
                    break;
        }
    }
}
