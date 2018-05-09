package com.example.administrator.signin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button SQLDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLDataBase=(Button)findViewById(R.id.SQLDataBase);
        SQLDataBase.setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SQLDataBase:
                Intent intent=new Intent(this,SQLDataBaseActivity.class);
                this.startActivity(intent);
                break;
        }

    }
}
