package com.example.administrator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ArrayAdapter arrayAdapter;
    private String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequestWithOkHttp();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:

                arrayAdapter=new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1,data);
                ListView listView=(ListView)findViewById(R.id.listView);
                listView.setAdapter(arrayAdapter);
        }
    }
    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder()
                            .url("http://gank.io/api/data/Android/10/1")
                            .build();
                    Response response=client.newCall(request).execute();
                    String responeData=response.body().string();
                    parseJSONWithJSONOject("["+responeData+"]");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }


            }
        }).start();
    }

    private void parseJSONWithJSONOject(String jsonData){
        try{
            JSONArray jsonArray=new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String results=jsonObject.getString("results");
                parseJSONWithJSONOjectresults(results);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void parseJSONWithJSONOjectresults(String jsonData){
        try{
            JSONArray jsonArray=new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("_id");
                data[i]=id;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
