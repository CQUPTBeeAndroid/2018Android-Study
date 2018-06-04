package activitytest.com.example.myinternettest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 问荆 on 2018/6/1.
 */

public class HttpUtil2 {
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
    new Thread(new Runnable() {
        @Override
        public void run() {
            HttpURLConnection connection = null;
            try{
                URL url =new URL(address);
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                connection.setDoInput(true);
                connection.setDoOutput(true);
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine())!=null){
                    response.append(line);
                }
                if(listener != null){
                    listener.onFinish(response.toString());
                }
            }catch (Exception e){
                if(listener!=null){
                    listener.error(e);
                }
            }finally {
                if(connection != null){
                    connection.disconnect();
                }
            }
        }
    }).start();
    }
}
