package com.example.hp.ourgank.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.ourgank.Assets.ActivityCollector;
import com.example.hp.ourgank.Assets.MySQL;
import com.example.hp.ourgank.R;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/9 14:27
 * @简述: 登录的活动
 */
public class LoginActivity extends AppCompatActivity {

    private MySQL mySQL;

    private static final int VERSION = 1;       //建数据库的版本

    private EditText account;
    private EditText password;

    private Button login;
    private Button register;

    private static final int NULL = 1;          //账号密码为空
    private static final int SUCCESS = 2;       //成功
    private static final int ACCOUNT_IS_NO = 3;     //账号错误
    private static final int PASSWORD_IS_NO = 4;    //密码错误

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityCollector.addActivity(this);
        ActionBar bar = getSupportActionBar();
        if (bar != null)
            bar.hide();

        //建表
        mySQL = new MySQL(this,"AccountData.db",null,VERSION);
        mySQL.getWritableDatabase();

        initView();     //初始化控件，并设置了监听事件
    }

    private void initView(){
        account = (EditText)findViewById(R.id.login_edit_count);
        password = (EditText)findViewById(R.id.login_edit_password);
        login = (Button)findViewById(R.id.login_login);
        register = (Button)findViewById(R.id.login_register);

        password.setTransformationMethod(PasswordTransformationMethod.getInstance());   //隐藏密码

        //输入回车监听事件
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND
                        || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(password.getWindowToken(), 0);      //关闭输入框
                    return true;
                }
                return false;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 分析实现登录返回的结果
     */
    private void show(){
        switch (isLogin()){
            case SUCCESS:
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case NULL:
                Toast.makeText(this,"账号密码不可为空",Toast.LENGTH_SHORT).show();
                break;
            case ACCOUNT_IS_NO:
                Toast.makeText(this,"账号不存在",Toast.LENGTH_SHORT).show();
                break;
            case PASSWORD_IS_NO:
                Toast.makeText(this,"密码输入有误",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


    /**
     * @return 返回登录的结果
     */
    private int isLogin(){
        String accountStr = account.getText().toString();
        String passwordStr = password.getText().toString();

        //输入为空
        if("".equals(accountStr)||"".equals(passwordStr)){
            return NULL;
        }

        SQLiteDatabase db = mySQL.getWritableDatabase();
        Cursor cursor = db.query("loginData",null,null,null
                ,null,null,null);

        //判断是否读取到数据
        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(cursor.getColumnIndex("account"));
                String b = cursor.getString(cursor.getColumnIndex("password"));

                try {
                    if (accountStr.equals(a)) {
                        if(passwordStr.equals(b)){
                            return SUCCESS;
                        }else {return PASSWORD_IS_NO;}
                    }else {}

                }catch (Exception e){}
            }while (cursor.moveToNext());
        }

        return ACCOUNT_IS_NO;
    }


    /**
     * @param keyCode
     * @param event
     * @return  确保返回键能够退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
            return false;
        }else {
            return super.onKeyDown(keyCode,event);
        }
    }
}
