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

public class RegisterActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private EditText repassword;
    private boolean isErrow;
    private String errMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = (Button)findViewById(R.id.confirm_register);
        user = (EditText)findViewById(R.id.user_edit2);
        password = (EditText)findViewById(R.id.password_edit2);
        repassword = (EditText)findViewById(R.id.confirm_edit);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass_word = password.getText().toString();
                final String user22 = user.getText().toString();
                String confirm = repassword.getText().toString();
                RequestBody requestBody =  new FormBody.Builder()
                        .add("username",user22)
                        .add("password",pass_word)
                        .add("repassword",confirm)
                        .build();
                HttpUtil.sendOkHttpRequest("http://www.wanandroid.com/user/register",requestBody, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Intent intent =new Intent(RegisterActivity.this, NoInternetAtivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        try {
                            JSONObject jsonObject = new JSONObject(responseData);

                            if(jsonObject.getString("errorCode").equals("-1")){
                                isErrow =true;errMsg = jsonObject.getString("errorMsg");
                            }else if(jsonObject.getString("errorCode").equals("0")){
                                isErrow =false;
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(isErrow){
                                    Toast.makeText(RegisterActivity.this,errMsg,Toast.LENGTH_SHORT).show();
                                }else{
                                    Intent intent =new Intent(RegisterActivity.this,FirstActivity.class);
                                    intent.putExtra("user",user22);
                                    startActivity(intent);
                                }
                            }
                        });
                        Log.d("注册返回",responseData);
                    }
                });
            }
        });
    }
}
