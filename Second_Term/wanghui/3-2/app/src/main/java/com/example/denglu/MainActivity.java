package com.example.denglu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //创建控件对象以及sharedpreferences的对象和编写对象。
private SharedPreferences pref;
private SharedPreferences.Editor editor;
private EditText accoutEdit;
private  EditText passwordEdit;
private Button login;
private CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到sharedpreferences对象，得到其他控件对象。
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accoutEdit =(EditText)findViewById(R.id.accout);
        passwordEdit =(EditText)findViewById(R.id.password);
        rememberPass =(CheckBox)findViewById(R.id.remember_pass);
        login=(Button)findViewById(R.id.login);

        //设定一开始没有被记住，如果后面勾选了被记住，则读取原来存储在pref中的数据。
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String account = pref.getString("account","");
            String password =pref.getString("password","");
            accoutEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }

        //设置登录的监听器
        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                String account = accoutEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("admin") && password.equals("123456")){
                    editor =pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }
                    else{
                        editor.clear();
                    }
                    //提交修改
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"account or password is wrong",0).show();
                }
            }
        });
    }
}
