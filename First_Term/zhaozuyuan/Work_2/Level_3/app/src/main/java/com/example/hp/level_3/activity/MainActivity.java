package com.example.hp.level_3.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.level_3.asset.ActivityCollector;
import com.example.hp.level_3.asset.MySQL;
import com.example.hp.level_3.R;

/**
 * 实现登录界面
 * @date 2018/5/5
 */
public class MainActivity extends AppCompatActivity {

    private MySQL dbHelper;     //SQL数据库

    private Button rigisterBtn;     //点击前往注册

    private Button loginBtn;        //登录

    private EditText accountEdit;   //账号
    private EditText passwordEdit;  //密码

    /**
     * 为了投方便，直接在主方法里面写了按钮及点击事件这些。
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_main);

//        数据库的初始化
        dbHelper = new MySQL(this,"PersonData.db",null,1);
        dbHelper.getWritableDatabase();

        rigisterBtn = (Button)findViewById(R.id.main_register);
        loginBtn = (Button)findViewById(R.id.main_login);
        accountEdit = (EditText)findViewById(R.id.main_account);
        passwordEdit = (EditText)findViewById(R.id.main_password);

        rigisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a =accountEdit.getText().toString();
                String b =passwordEdit.getText().toString();
                try {
                    if(isDiscover(a, b)){
                        Intent i = new Intent(MainActivity.this,Main3Activity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(MainActivity.this,"登录失败！",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"登录失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

//    是否发现当前账号密码，发现即返回ture
    private boolean isDiscover(String account,String password){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Login",null,null,null
                ,null,null,null);

        String as = "";
        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(cursor.getColumnIndex("account"));
                String b = cursor.getString(cursor.getColumnIndex("password"));
                for(;a.equals(as);){}       //确保已经读到了下一个账号

                try {
                    if (account.equals(a)) {
                        if(password.equals(b))
                            return true;
                    }
                }catch (Exception e){}
                as = a;
            }while (cursor.moveToNext());
        }

        return false;
    }

//    确保在登录页面返回键是退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            ActivityCollector.finishAll();
            return false;
        }else {
            return super.onKeyDown(keyCode,event);
        }
    }
}
