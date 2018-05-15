package com.example.zhangfan.work3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RegisterActivity extends AppCompatActivity {
    private EditText counterText;
    private EditText passwordText;
    private Button button;
    private Button saveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        passwordText = (EditText)findViewById(R.id.password_register);
        saveData = (Button)findViewById(R.id.sharedpreferences);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("share",MODE_PRIVATE).edit();
                String userName = counterText.getText().toString();
                String passWord = passwordText.getText().toString();
                editor.putString(userName,userName);
                editor.putString(passWord,passWord);
                editor.apply();
            }
        });
        counterText = (EditText)findViewById(R.id.edt_counter_register);
        button = (Button)findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = counterText.getText().toString();
                String password = passwordText.getText().toString();
                String count = userName;
                String word = password;
                save(count);
                save(password);
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("inputText",count);
                intent.putExtra("word",word);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void save(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("count", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            {
                try{
                    if (writer != null){
                        writer.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
