package com.example.sign_up_in;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText accountEdit1,passEdit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        accountEdit1=(EditText)findViewById(R.id.account1);
        passEdit1=(EditText)findViewById(R.id.password1);
        Button button3=(Button)findViewById(R.id.login1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account1=accountEdit1.getText().toString();
                String password1=passEdit1.getText().toString();

                Sql sql=new Sql();
                sql.setAccountId(account1);
                sql.setPasswordId(password1);
                sql.save();
                Intent intent=new Intent(Main3Activity.this,MainActivity.class);
                intent.putExtra("data_return",account1);
                intent.putExtra("data_returny",password1);
                startActivity(intent);
                Toast.makeText(Main3Activity.this,"你已经创建成功了，请尝试登录一下吧！",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
