package com.example.gankpro.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gankpro.Activity.FirstActivityFragment.NoInternetAtivity;
import com.example.gankpro.HttpUtil;
import com.example.gankpro.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     private EditText user;
     private EditText password;
     private boolean isErrow;
     private String erMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button)findViewById(R.id.login);
        Button register = (Button)findViewById(R.id.register);
        user = (EditText)findViewById(R.id.user_edit);
        password = (EditText)findViewById(R.id.password_edit);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                String pass_word = password.getText().toString();
                final String user22 = user.getText().toString();
                RequestBody requestBody =  new FormBody.Builder()
                        .add("username",user22)
                        .add("password",pass_word)
                        .build();
                HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/user/login",requestBody, new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                e.printStackTrace();
                                Intent intent =new Intent(MainActivity.this, NoInternetAtivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                             String responseData = response.body().string();
                             try {
                                 JSONObject jsonObject = new JSONObject(responseData);
                                 if(jsonObject.getString("errorCode").equals("-1")){
                                     isErrow =true;erMsg = jsonObject.getString("errorMsg");
                                 }else if(jsonObject.getString("errorCode").equals("0")){
                                     isErrow = false;
                                 }
                             }catch (JSONException e){
                                 e.printStackTrace();
                             }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(isErrow){
                                            Toast.makeText(MainActivity.this,erMsg,Toast.LENGTH_SHORT).show();
                                        }else {
                                            Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                                            intent.putExtra("user",user22);
                                            startActivity(intent);
                                        }
                                    }
                                });
                             Log.d("登录返回",responseData);
                            }
                        });
                break;
            case R.id.register:
                Intent intent1 = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent1);
                break;
                default:
                break;
        }

    }
}
