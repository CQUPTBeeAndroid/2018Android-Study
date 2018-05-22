package com.example.super_chao.loginwork;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registerActivity extends AppCompatActivity {


    private SharedPreferences.Editor editor;

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        accountEdit=(EditText)findViewById(R.id.register_account);


        passwordEdit = (EditText)findViewById(R.id.register_password);


        yes = (Button)findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor =getSharedPreferences("data",MODE_PRIVATE).edit();

                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();


                editor.putString("account",account);
                editor.putString("password",password);
                editor.apply();
                finish();
            }
        });
    }
}
