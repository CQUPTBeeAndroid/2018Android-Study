package com.example.zhangfan.work3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
 private Button sharedpreferencesBtn;
 private EditText counterLogin;
 private EditText passwordLogin;
 private TextView textView;
 private Button fileButton;
 private CheckBox checkBox;
 private Button login;
 private SharedPreferences preferences;
 private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        passwordLogin = (EditText)findViewById(R.id.password_login);
        checkBox = (CheckBox)findViewById(R.id.text_check);
        counterLogin = (EditText)findViewById(R.id.counter_login);

        Intent intent = getIntent();
        final String text = intent.getStringExtra("inputText");
        final String passWord = intent.getStringExtra("word");
        sharedpreferencesBtn = (Button)findViewById(R.id.sharedpreferences_btn);
        sharedpreferencesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("share",MODE_PRIVATE);
                String usersName = pref.getString(text,"");
                String word = pref.getString(passWord,"");
                counterLogin.setText(usersName);
            }
        });
        login = (Button)findViewById(R.id.login);
        boolean isRemeber = preferences.getBoolean("remember_word",false);
        if (isRemeber){
            String account = preferences.getString("account","");
            String password = preferences.getString("password","");
            counterLogin.setText(account);
            passwordLogin.setText(password);
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("share",MODE_PRIVATE);
                String account = counterLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                String usersName = pref.getString(text,"");
                String word = pref.getString(passWord,"");
                if (account.equals(usersName) && password.equals(word)){
                    editor = preferences.edit();
                    if (checkBox.isChecked()){
                        editor.putBoolean("remenber_password",true);
                        editor.putString("account",account);
                        editor.putString("password",passWord);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent1 = new Intent(MainActivity.this,ThirdActivity.class);
                    startActivity(intent1);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        textView = (TextView)findViewById(R.id.intent_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        fileButton = (Button)findViewById(R.id.file_login);
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = load();
                if (!TextUtils.isEmpty(inputText)){
                    counterLogin.setText(inputText);
                    counterLogin.setSelection(inputText.length());
                }
            }
        });
    }

    public String load(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = openFileInput("count");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine()) != null){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            {
                if (reader != null){
                    try {
                        reader.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return content.toString();
    }
    }
