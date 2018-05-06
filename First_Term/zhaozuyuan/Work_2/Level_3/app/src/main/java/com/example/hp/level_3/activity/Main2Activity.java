package com.example.hp.level_3.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
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
 * 实现注册的功能
 * @date 2018/5/5
 */
public class Main2Activity extends AppCompatActivity{

    private MySQL dbHelper;

    private Button rigisterBtn;     //实现注册

    private Button backBtn;         //顶部返回键

    private EditText accountEdit;

    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        dbHelper = new MySQL(this,"PersonData.db",null,1);

        rigisterBtn = (Button)findViewById(R.id.main2_register);
        backBtn = (Button)findViewById(R.id.main2_back);
        accountEdit = (EditText)findViewById(R.id.main2_account);
        passwordEdit = (EditText)findViewById(R.id.main2_password);

        rigisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String accountStr = accountEdit.getText().toString();
                String passwordStr = passwordEdit.getText().toString();

                if (passwordStr != "" && passwordStr != null) {     //确保数据不为空
                    if (isRepeat(accountStr)) {
                        rigister(accountStr, passwordStr);
                        finish();
                    } else {
                        Toast.makeText(Main2Activity.this, "用户名重复！", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Main2Activity.this,"请输入密码！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

//    储存注册的用户数据
    private void rigister(String account, String password){

        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("account", account);
            values.put("password", password);
            db.insert("Login", null, values);
            Toast.makeText(Main2Activity.this,"注册成功！",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(Main2Activity.this,"注册失败！",Toast.LENGTH_SHORT).show();
        }
    }

//    判断当前账号是否存在
    private boolean isRepeat(String account){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Login",null,null,null
                ,null,null,null);

        String as = "";
        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(cursor.getColumnIndex("account"));
                for(;a.equals(as);){}       //确保已经读到了下一个账号

                try {
                    if (account.equals(a)) {
                        return false;
                    }
                }catch (Exception e){}

                as = a;
            }while (cursor.moveToNext());
        }
        return true;
    }

//    返回键回到登录界面，而不是销毁当前
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            startActivity(intent);
            return false;
        }else {
            return super.onKeyDown(keyCode,event);
        }
    }
}
