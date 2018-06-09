package com.example.materiatest3;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Main3Activity extends AppCompatActivity {

    public static final int UPDATA_TEXT = 1;
    private ListView listView;

    String a1, a2, a3, a4;
    String b1, b2, b3, b4;
    String c1, c2, c3, c4;
    private String[] a = { a1, a2, a3, a4, b1, b2, b3, b4,
            c1, c2, c3, c4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.list_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.apiopen.top/novelApi")
                            .build();
                    Response response = client.newCall(request).execute();
                    String JSONString = response.body().string();

                    Gson gson = new Gson();

                    Story story = gson.fromJson(JSONString, Story.class);

                    a[0] = story.data.get(0).author_name;//作者
                    a[1] = story.data.get(0).bookname;//书名
                    a[2] = story.data.get(0).first_cate_name;//类型
                    a[3] = story.data.get(0).introduction;//简介
                    Log.e("Q", a[0]);
                    a[4] = story.data.get(1).author_name;//作者
                    a[5] = story.data.get(1).bookname;//书名
                    a[6] = story.data.get(1).first_cate_name;//类型
                    a[7] = story.data.get(1).introduction;//简介
                    Log.e("Q", a[5]);
                    a[8] = story.data.get(2).author_name;//作者
                    a[9] = story.data.get(2).bookname;//书名
                    a[10] = story.data.get(2).first_cate_name;//类型
                    a[11] = story.data.get(2).introduction;//简介
                    Log.e("Q", a[8]);


                    Message message = new Message();
                    message.what = UPDATA_TEXT;
                    handler.sendMessage(message);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATA_TEXT:

                    getData();

                    break;
                default:
                    break;
            }
        }
    };

    private void getData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Main3Activity.this, android.R.layout.simple_list_item_1, a);

        listView.setAdapter(adapter);
    }


}
