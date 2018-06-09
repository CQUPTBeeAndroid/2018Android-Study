package com.example.materiatest3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EnterActivity extends AppCompatActivity {


    private EditText accountEdit, passEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        accountEdit = (EditText) findViewById(R.id.account);
        passEdit = (EditText) findViewById(R.id.password);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
        boolean isRemember=pref.getBoolean("remember_password",false);
        if(isRemember){
            String account=pref.getString("账户","");
            String password=pref.getString("密码","");
            accountEdit.setText(account);
            passEdit.setText(password);
            rememberPass.setChecked(true);
        }

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passEdit.getText().toString();

                Intent intent1 = getIntent();
                String a = intent1.getStringExtra("data_return");
                String b = intent1.getStringExtra("data_returny");

                if (account.equals(a) && password.equals(b)) {

                    editor=pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("账户",account);
                        editor.putString("密码",password);
                    }else{
                        editor.clear();
                    }editor.apply();

                    Intent intent = new Intent("com.example.mainactivity.ACTION_STARTQ");
                    intent.addCategory("com.example.mainactivity.MY_CATEGORYQ");
                    startActivity(intent);
                } else {
                    Toast.makeText(EnterActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button login2 = (Button) findViewById(R.id.login2);
        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("com.example.mainactivity.ACTION_STARTHQ");
                intent.addCategory("com.example.mainactivity.MY_CATEGORYHQ");
                startActivity(intent);
                finish();
            }
        });
    }

}