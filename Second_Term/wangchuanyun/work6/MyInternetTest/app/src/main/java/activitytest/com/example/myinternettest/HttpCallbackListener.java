package activitytest.com.example.myinternettest;

/**
 * Created by 问荆 on 2018/6/1.
 */
public interface HttpCallbackListener {
    public void onFinish(String response);
    public void error(Exception e);
}
