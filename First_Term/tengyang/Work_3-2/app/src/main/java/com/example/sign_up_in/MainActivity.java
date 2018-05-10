package com.example.sign_up_in;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText accountEdit, passEdit;
    private Button login;



    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    String returnedData1 = data.getStringExtra("data_returny");

                }
                break;
            default:
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountEdit = (EditText) findViewById(R.id.account);
        passEdit = (EditText) findViewById(R.id.password);


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
                    Intent intent = new Intent("com.example.mainactivity.ACTION_STARTQ");
                    intent.addCategory("com.example.mainactivity.MY_CATEGORYQ");
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
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
