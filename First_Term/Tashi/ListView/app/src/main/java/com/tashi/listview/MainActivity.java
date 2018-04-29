package com.tashi.listview;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
public class MainActivity extends Activity {
    private ArrayList<String> texts = null;
    private ArrayList<Integer> images = null;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);   //透明状态栏（顶部）
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   //透明操作栏（底部）

        initImageView();
        initAnswer();

        mAdapter adapter = new mAdapter(images,texts);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    public void initAnswer() {
        texts = new ArrayList<>();
        texts.add("宠辱不惊，看庭前花开花落；去留无意，望天空云卷云舒。" );
        texts.add("岁月本长，而忙者自促； 天地本宽，而鄙者自隘； 风花雪月本闲，而扰攘者自冗。");
        texts.add("风来疏竹，风过而竹不留声； 雁渡寒潭，雁去而潭不留影。 故君子事来而心始现，事去而心随空。");
        texts.add("鱼得水逝，而相忘乎水，鸟乘风飞，而不知有风。");
        texts.add("建功立业者，多虚圆之士；偾事失机者，必执拗之人。");
        texts.add("处世而欲人感恩，便为敛怨之道；遇事而为人除害，即是导利之机。");
        texts.add("没有理想的人，才能过得上理想的生活，有理想的人，一直都在追逐理想。");
        texts.add("看破有尽身躯，万境之尘缘自息；悟入无坏境界，一轮之心月独明。");
        texts.add("秋虫春鸟共畅天机，何必浪生悲喜；老树新花同含生意，胡为妄别媸妍。");
        texts.add("完名美节，不宜独任，分些与人，能够远害全身；辱行污名，不宜全推，引些归己，能够韬光养德。");
        texts.add("休与小人仇雠，小人自有对头；休向君子谄媚，君子原无私惠。");
        texts.add("功名富贵，直从灭处观究竟，则贪恋自轻；横逆困穷，直从起处究由来，则怨尤自息。");
        texts.add("勿对别人有太多的期待，无论是在道德上，还是在才智上。");
        texts.add("听静夜之钟声，唤醒梦中之梦；观澄潭之月影，窥见身外之身。");
        texts.add("千载奇逢，无如好书良友；一生清福，只在碗茗炉烟。");
        texts.add("建功立业者，多虚圆之士；偾事失机者，必执拗之人。");
        texts.add("处世而欲人感恩，便为敛怨之道；遇事而为人除害，即是导利之机。");
        texts.add("没有理想的人，才能过得上理想的生活，有理想的人，一直都在追逐理想。");
        texts.add("看破有尽身躯，万境之尘缘自息；悟入无坏境界，一轮之心月独明。");
        texts.add("秋虫春鸟共畅天机，何必浪生悲喜；老树新花同含生意，胡为妄别媸妍。");
        texts.add("完名美节，不宜独任，分些与人，能够远害全身；辱行污名，不宜全推，引些归己，能够韬光养德。");
        texts.add("休与小人仇雠，小人自有对头；休向君子谄媚，君子原无私惠。");
        texts.add("功名富贵，直从灭处观究竟，则贪恋自轻；横逆困穷，直从起处究由来，则怨尤自息。");
        texts.add("勿对别人有太多的期待，无论是在道德上，还是在才智上。");
    }
    public void initImageView() {
        this.images = new ArrayList<>();
        images.add(R.drawable.one);
        images.add(R.drawable.two);
        images.add(R.drawable.three);
        images.add(R.drawable.four);
        images.add(R.drawable.five);
        images.add(R.drawable.six);
        images.add(R.drawable.seven);
        images.add(R.drawable.eight);
        images.add(R.drawable.nine);
        images.add(R.drawable.ten);
        images.add(R.drawable.eleven);
        images.add(R.drawable.twlve);
        images.add(R.drawable.thriteen);
        images.add(R.drawable.fourteen);
        images.add(R.drawable.fifteen);
        images.add(R.drawable.sixteen);
        images.add(R.drawable.seventeen);
        images.add(R.drawable.eighteen);
        images.add(R.drawable.nineteen);
        images.add(R.drawable.twnty);
        images.add(R.drawable.twety_one);
        images.add(R.drawable.two_two);
        images.add(R.drawable.two_three);
        images.add(R.drawable.two_four);
    }
}








