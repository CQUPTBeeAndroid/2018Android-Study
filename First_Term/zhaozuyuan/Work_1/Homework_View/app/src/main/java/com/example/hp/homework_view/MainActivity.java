package com.example.hp.homework_view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;


/**
 * @author 赵祖元
 * @date 2017/4/12
 * 这个app开始是ListView，然后选择类型，跳到RecyclerView的界面，根据在主活动传过来的数据，判断加载什么样
 * 的图片，图片来源是百度图片。
 * 这个app的bug超级多，修改得实在不要不要的了，决定交了。
 */
public class MainActivity extends AppCompatActivity {

    private ListView mListView = null;
    private MyListAdapater myListAdapater = null;       //创建一个适配器对象

//    数据资源
    private String[] titles = {"军事","人文","美女","-","-","-","-","-","-"};
    private String[] texts = {"坦克-五代战机-航母-东方导弹","大街小巷-伟大艺术-真实人心"
            ,"国内明星-韩国组合-日本女优"};
    private int[] imageId = {R.drawable.junshi_2,R.drawable.shehui,R.drawable.beauty_2};

    private static int windowHeight;        //用于得到屏幕的高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        状态栏透明，对安卓要求5.0以上才可实现状态栏透明
       getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

//        获取窗口的高度和宽度
        WindowManager wm1 = this.getWindowManager();
        windowHeight = wm1.getDefaultDisplay().getHeight();


//        对顶部照片的大小进行设置
        ImageView main_image = (ImageView) findViewById(R.id.image_view);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) main_image.getLayoutParams();
        params.height = windowHeight / 4;
        main_image.setLayoutParams(params);

//        实例LIstView，实例我的适配器，将数据传入，将适配器放入ListView
        mListView = (ListView)findViewById(R.id.list_view);
        myListAdapater = new MyListAdapater(titles,texts,windowHeight,imageId,this);
        mListView.setAdapter(myListAdapater);

//        实现item的监听事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ShowImage.class);
                intent.putExtra("Type",position);
                startActivity(intent);
            }
        });

    }

}
