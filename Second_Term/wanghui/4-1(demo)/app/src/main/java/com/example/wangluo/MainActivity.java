package com.example.wangluo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest = (Button)findViewById(R.id.send);
        responseText =(TextView)findViewById(R.id.text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.send){
            sendRequestWithOkHttp();
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client =new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://www.baidu.com")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showResponse(final String responseData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(responseData);
            }
        });
    }
}
