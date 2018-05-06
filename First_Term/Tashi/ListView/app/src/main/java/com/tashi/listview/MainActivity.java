package com.tashi.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<String> texts_normal = null;
    private ArrayList<Integer> images_normal = null;
    private ArrayList<Integer> image_first = null;
    private ArrayList<String> texts_first = null;
    RecyclerView recyclerView;
    Intent intent ;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);   //透明状态栏（顶部）
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   //透明操作栏（底部）
        initImageView();
        initAnswer();
        mAdapter adapter = new mAdapter(images_normal, texts_normal);
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        intent = new Intent(MainActivity.this,Main2Activity.class);

//        ImageButton button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(intent);
//                finish();
//            }
//        });

    }



    public void initAnswer() {
        texts_normal = new ArrayList<>();

        texts_normal.add("宠辱不惊，看庭前花开花落；去留无意，望天空云卷云舒。");
        texts_normal.add("岁月本长，而忙者自促； 天地本宽，而鄙者自隘； 风花雪月本闲，而扰攘者自冗。");
        texts_normal.add("风来疏竹，风过而竹不留声； 雁渡寒潭，雁去而潭不留影。 故君子事来而心始现，事去而心随空。");
        texts_normal.add("鱼得水逝，而相忘乎水，鸟乘风飞，而不知有风。");
        texts_normal.add("建功立业者，多虚圆之士；偾事失机者，必执拗之人。");
        texts_normal.add("处世而欲人感恩，便为敛怨之道；遇事而为人除害，即是导利之机。");
        texts_normal.add("没有理想的人，才能过得上理想的生活，有理想的人，一直都在追逐理想。");
        texts_normal.add("看破有尽身躯，万境之尘缘自息；悟入无坏境界，一轮之心月独明。");
        texts_normal.add("秋虫春鸟共畅天机，何必浪生悲喜；老树新花同含生意，胡为妄别媸妍。");
        texts_normal.add("完名美节，不宜独任，分些与人，能够远害全身；辱行污名，不宜全推，引些归己，能够韬光养德。");
        texts_normal.add("休与小人仇雠，小人自有对头；休向君子谄媚，君子原无私惠。");
        texts_normal.add("功名富贵，直从灭处观究竟，则贪恋自轻；横逆困穷，直从起处究由来，则怨尤自息。");
        texts_normal.add("勿对别人有太多的期待，无论是在道德上，还是在才智上。");
        texts_normal.add("听静夜之钟声，唤醒梦中之梦；观澄潭之月影，窥见身外之身。");
        texts_normal.add("千载奇逢，无如好书良友；一生清福，只在碗茗炉烟。");
        texts_normal.add("建功立业者，多虚圆之士；偾事失机者，必执拗之人。");
        texts_normal.add("处世而欲人感恩，便为敛怨之道；遇事而为人除害，即是导利之机。");
        texts_normal.add("没有理想的人，才能过得上理想的生活，有理想的人，一直都在追逐理想。");
        texts_normal.add("看破有尽身躯，万境之尘缘自息；悟入无坏境界，一轮之心月独明。");
        texts_normal.add("秋虫春鸟共畅天机，何必浪生悲喜；老树新花同含生意，胡为妄别媸妍。");
        texts_normal.add("完名美节，不宜独任，分些与人，能够远害全身；辱行污名，不宜全推，引些归己，能够韬光养德。");
        texts_normal.add("休与小人仇雠，小人自有对头；休向君子谄媚，君子原无私惠。");
        texts_normal.add("功名富贵，直从灭处观究竟，则贪恋自轻；横逆困穷，直从起处究由来，则怨尤自息。");
        texts_normal.add("勿对别人有太多的期待，无论是在道德上，还是在才智上。");
        texts_normal.add("千载奇逢，无如好书良友；一生清福，只在碗茗炉烟。");


    }

    public void initImageView() {
        this.images_normal = new ArrayList<>();


        images_normal.add(R.drawable.one);
        images_normal.add(R.drawable.two);
        images_normal.add(R.drawable.three);
        images_normal.add(R.drawable.four);
        images_normal.add(R.drawable.five);
        images_normal.add(R.drawable.six);
        images_normal.add(R.drawable.seven);
        images_normal.add(R.drawable.eight);
        images_normal.add(R.drawable.nine);
        images_normal.add(R.drawable.ten);
        images_normal.add(R.drawable.eleven);
        images_normal.add(R.drawable.twlve);
        images_normal.add(R.drawable.thriteen);
        images_normal.add(R.drawable.fourteen);
        images_normal.add(R.drawable.fifteen);
        images_normal.add(R.drawable.sixteen);
        images_normal.add(R.drawable.seventeen);
        images_normal.add(R.drawable.eighteen);
        images_normal.add(R.drawable.nineteen);
        images_normal.add(R.drawable.twnty);
        images_normal.add(R.drawable.twety_one);
        images_normal.add(R.drawable.two_two);
        images_normal.add(R.drawable.two_three);
        images_normal.add(R.drawable.two_four);
        images_normal.add(R.drawable.five);

    }
}








