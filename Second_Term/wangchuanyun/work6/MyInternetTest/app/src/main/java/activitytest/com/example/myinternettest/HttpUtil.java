package activitytest.com.example.myinternettest;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 问荆 on 2018/5/28.
 */

public class HttpUtil {

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
