package com.example.a19597.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recyclerview extends AppCompatActivity {

    private List<Card> cardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        initCards();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CardAdapter1 adapter = new CardAdapter1(cardList);
        recyclerView.setAdapter(adapter);
    }
    private void initCards(){
        Card falute = new Card("黑龙骑士·法露特", R.drawable.em_100010401_s);
        cardList.add(falute);
        Card modikai = new Card("不死斗士·莫迪凯",R.drawable.em_100010501_s);
        cardList.add(modikai);
        Card banbi = new Card("暗夜公主·斑比",R.drawable.em_100010601_s);
        cardList.add(banbi);
        Card dingdang = new Card("闪耀之瞳·叮当天使",R.drawable.em_101021010_s);
        cardList.add(dingdang);
        Card leiao = new Card("皇家剑士·奥蕾莉亚",R.drawable.em_101241020_s);
        cardList.add(leiao);
        Card kaier = new Card("凯尔贝洛斯",R.drawable.em_101541010_s);
        cardList.add(kaier);
        Card maidusha = new Card("美杜莎",R.drawable.em_101631060_s);
        cardList.add(maidusha);
        Card yongchang = new Card("咏唱：神域守护者",R.drawable.em_101733020_s);
        cardList.add(yongchang);
        Card lisha = new Card("精灵少女·莉莎",R.drawable.em_102131030_s);
        cardList.add(lisha);
        Card tianshi = new Card("炽天使",R.drawable.em_102743010_s);
        cardList.add(tianshi);
        Card baha = new Card("巴哈姆特",R.drawable.em_103041010_s);
        cardList.add(baha);
        Card bailang = new Card("远古之森的白狼",R.drawable.em_103141010_s);
        cardList.add(bailang);
        Card leigay = new Card("雷维翁剑士·阿尔贝尔",R.drawable.em_103241010_s);
        cardList.add(leigay);
        Card duoluoxi = new Card("次元魔女·桃乐丝",R.drawable.em_103341010_s);
        cardList.add(duoluoxi);
        Card longqi = new Card("帝国龙骑士",R.drawable.em_103441010_s);
        cardList.add(longqi);
        Card pohun = new Card("破魂少女",R.drawable.em_104531020_s);
        cardList.add(pohun);
        Card jiling = new Card("精灵女王",R.drawable.em_1041410100_s);
        cardList.add(jiling);
        Card gaowen = new Card("圆桌骑士·高文",R.drawable.em_1042410200_s);
        cardList.add(gaowen);
        Card zhende = new Card("黑暗贞德",R.drawable.em_1047410100_s);
        cardList.add(zhende);
        Card kala = new Card("邪恶妖精·卡拉波斯",R.drawable.em_1056410100_s);
        cardList.add(kala);
    }
}
