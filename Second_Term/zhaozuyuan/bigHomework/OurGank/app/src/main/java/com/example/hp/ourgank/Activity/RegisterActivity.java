package com.example.hp.ourgank.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
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
 * @简述:  注册的活动
 */
public class RegisterActivity extends AppCompatActivity {

    //输入框，账号、密码1、密码2
    private EditText account;
    private EditText password1;
    private EditText password2;

    private Button register;

    private MySQL mySQL;

    //三个输入的数据
    String accountStr = null;
    String passwordStr1  = null;
    String passwordStr2 = null;

    private static final int NULL = 1;          //账号密码为空
    private static final int SUCCESS = 2;       //成功
    private static final int ACCOUNT_IS_NO = 3;        //账号不规范
    private static final int ACCOUNT_IS_EXSIT = 4;     //账号存在
    private static final int PASSWORD_IS_NOT_SAME = 5;     //密码相同


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActivityCollector.addActivity(this);
        ActionBar bar = getSupportActionBar();
        if (bar != null)
            bar.hide();

        mySQL = new MySQL(this,"AccountData.db",null,1);

        initView();     //初始化控件，并设置了监听事件
    }

    private void initView(){
        account = (EditText)findViewById(R.id.register_edit_count);
        password1 = (EditText) findViewById(R.id.register_edit_password1);
        password2 = (EditText)findViewById(R.id.register_edit_password2);
        register = (Button)findViewById(R.id.register_register);

        password2.setTransformationMethod(PasswordTransformationMethod.getInstance());   //隐藏密码
        password1.setTransformationMethod(PasswordTransformationMethod.getInstance());   //隐藏密码

        //输入回车监听事件

        password2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND
                    || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(password2.getWindowToken(), 0); //关闭输入框
                    return true;
                }
                return false;
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountStr = account.getText().toString();
                passwordStr1 = password1.getText().toString();
                passwordStr2 = password2.getText().toString();

                show();
            }
        });
    }

    private void show(){
        switch (isRegister()){
            case NULL:
                Toast.makeText(this,"账号密码不可为空",Toast.LENGTH_SHORT).show();
                break;
                case ACCOUNT_IS_NO:
                Toast.makeText(this,"账号输入不规范",Toast.LENGTH_SHORT).show();
                break;
            case PASSWORD_IS_NOT_SAME:
                Toast.makeText(this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                break;
            case ACCOUNT_IS_EXSIT:
                Toast.makeText(this,"账号已存在",Toast.LENGTH_SHORT).show();
                break;
            case SUCCESS:
                if(register()){
                    Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }else {Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();}
                break;
            default:
                break;
        }
    }

    /**
     * @return 选择注册后返回的结果
     */
    private int isRegister(){
        String accountStr = account.getText().toString();
        String passwordStr1 = password1.getText().toString();
        String passwordStr2 = password2.getText().toString();

        if("".equals(accountStr) || "".equals(passwordStr1)){
            return NULL;
        }

        if(!passwordStr1.equals(passwordStr2)){
            return PASSWORD_IS_NOT_SAME;
        }

        for (int i = accountStr.length(); --i>=0;){
            if (!Character.isDigit(accountStr.charAt(i))){
                return ACCOUNT_IS_NO;
            }
        }

        SQLiteDatabase db = mySQL.getWritableDatabase();
        Cursor cursor = db.query("loginData",null,null,null
                ,null,null,null);

        if(cursor.moveToFirst()){
            do{
                String a = cursor.getString(cursor.getColumnIndex("account"));

                if(a.equals(accountStr))
                    return ACCOUNT_IS_EXSIT;
            }while (cursor.moveToNext());
        }

        return SUCCESS;
    }

    /**
     * @return 满足注册条件后进行注册返回的结果
     */
    private boolean register(){
        try {
            SQLiteDatabase db = mySQL.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("account", accountStr);
            values.put("password", passwordStr1);
            db.insert("loginData", null, values);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
