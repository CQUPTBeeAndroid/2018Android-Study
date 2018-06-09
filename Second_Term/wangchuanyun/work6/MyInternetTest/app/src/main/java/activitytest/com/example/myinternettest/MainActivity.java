package activitytest.com.example.myinternettest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity{
    private List<String>girlPicUrl = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUrl(this);

    }
    public void initUrl(final Context mcontext){
        /*HttpUtil2.sendHttpRequest("http://gank.io/api/data/福利/10/1", new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
               String responseData =response.toString();
                try {
                    JSONObject jsonObject=new JSONObject(responseData);
                    String result=jsonObject.getString("results");
                    JSONArray jsonArray=new JSONArray(result);
                    for(int i =0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        girlPicUrl.add(jsonObject1.getString("url"));
                        //     Log.d("shuju ",girlPicUrl.get(i));
                    }
                    //setUrl(girlPicUrl,mcontext);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.girlpic_recycler);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(mcontext,2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        GirlAdapter adapter = new GirlAdapter(mcontext,girlPicUrl);
                        //Log.d("shuju ",girlPicUrl.get(0));
                        recyclerView.setAdapter(adapter);
                    }
                });
            }

                    @Override
                    public void error(Exception e) {
                         e.printStackTrace();
            }
        });*/
       HttpUtil.sendOkHttpRequest("http://gank.io/api/data/福利/10/1",new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData =response.body().string();

                try {
                    JSONObject jsonObject=new JSONObject(responseData);
                    String result=jsonObject.getString("results");
                    JSONArray jsonArray=new JSONArray(result);
                    for(int i =0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        girlPicUrl.add(jsonObject1.getString("url"));
                   //     Log.d("shuju ",girlPicUrl.get(i));
                    }
                    //setUrl(girlPicUrl,mcontext);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.girlpic_recycler);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(mcontext,2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        GirlAdapter adapter = new GirlAdapter(mcontext,girlPicUrl);
                        //Log.d("shuju ",girlPicUrl.get(0));
                        recyclerView.setAdapter(adapter);
                    }
                });

            }
        });

    }
   /* public void setUrl(final List<String>girlPicUrl,final Context mcontext){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.girlpic_recycler);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mcontext,2);
            recyclerView.setLayoutManager(gridLayoutManager);
            GirlAdapter adapter = new GirlAdapter(mcontext,girlPicUrl);
            //Log.d("shuju ",girlPicUrl.get(0));
            recyclerView.setAdapter(adapter);
        }
    });}*/
}
