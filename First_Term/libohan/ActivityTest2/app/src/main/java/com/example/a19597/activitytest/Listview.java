package com.example.a19597.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listview extends AppCompatActivity {

    private List<Card> cardList = new ArrayList<>();

    /*private String[] data = {"黑龙骑士·法露特","不死斗士·莫迪凯","暗夜公主·斑比","闪耀之瞳·叮当天使",
            "皇家剑士·奥蕾莉亚","凯尔贝洛斯","美杜莎","咏唱：神域守护者","精灵少女·莉莎", "炽天使","巴哈姆特",
            "远古之森的白狼","雷维翁剑士·阿尔贝尔","次元魔女·桃乐丝","帝国龙骑士","破魂少女","精灵女王","圆桌骑士·高文","黑暗贞德","邪恶妖精·卡拉波斯"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initCards();
        CardAdapter adapter = new CardAdapter(Listview.this,R.layout.card_item, cardList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Card card = cardList.get(position);
                switch (card.getName()){
                    case "黑龙骑士·法露特": {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/13255"));
                        startActivity(intent);
                        break;
                    }
                    case "不死斗士·莫迪凯":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/13315"));
                        startActivity(intent);
                        break;
                    }
                    case "暗夜公主·斑比":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31661"));
                        startActivity(intent);
                        break;
                    }
                    case "闪耀之瞳·叮当天使":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/41844"));
                        startActivity(intent);
                        break;
                    }
                    case "皇家剑士·奥蕾莉亚":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/13149"));
                        startActivity(intent);
                        break;
                    }
                    case "凯尔贝洛斯":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/13303"));
                        startActivity(intent);
                        break;
                    }
                    case "美杜莎":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/41722"));
                        startActivity(intent);
                        break;
                    }
                    case "咏唱：神域守护者":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/13395"));
                        startActivity(intent);
                        break;
                    }
                    case "精灵少女·莉莎":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31561"));
                        startActivity(intent);
                        break;
                    }
                    case "炽天使":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31617"));
                        startActivity(intent);
                        break;
                    }
                    case "巴哈姆特":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31767"));
                        startActivity(intent);
                        break;
                    }
                    case "远古之森的白狼":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31688"));
                        startActivity(intent);
                        break;
                    }
                    case "雷维翁剑士·阿尔贝尔":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31675"));
                        startActivity(intent);
                        break;
                    }
                    case "次元魔女·桃乐丝":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31702"));
                        startActivity(intent);
                        break;
                    }
                    case "帝国龙骑士":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/31728"));
                        startActivity(intent);
                        break;
                    }
                    case "破魂少女":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/32628"));
                        startActivity(intent);
                        break;
                    }
                    case "圆桌骑士·高文":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/32593"));
                        startActivity(intent);
                        break;
                    }
                    case "黑暗贞德":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/32657"));
                        startActivity(intent);
                        break;
                    }
                    case "邪恶妖精·卡拉波斯":{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://sv.37man.com/card/39204"));
                        startActivity(intent);
                        break;
                    }
                }
            }
        });
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
