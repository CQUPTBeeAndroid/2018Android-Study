package com.example.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    private List<Constellation_2> constellationList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        inconstellation_2();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ConstellationAdapter_2 adapter = new ConstellationAdapter_2(constellationList);
        recyclerView.setAdapter(adapter);
    }
    private void inconstellation_2() {
        Constellation_2 a = new Constellation_2("水瓶座   01.21~02.19", R.drawable.shuiping);
        constellationList.add(a);
        Constellation_2 b = new Constellation_2("双鱼座   02.20~03.20", R.drawable.shuangyu);
        constellationList.add(b);
        Constellation_2 c = new Constellation_2("白羊座   03.21~04.20", R.drawable.baiyang);
        constellationList.add(c);
        Constellation_2 d = new Constellation_2("金牛座   04.21~05.21", R.drawable.jinniu);
        constellationList.add(d);
        Constellation_2 e = new Constellation_2("双子座   05.22~06.21", R.drawable.shuangyu);
        constellationList.add(e);
        Constellation_2 f = new Constellation_2("巨蟹座   06.22~07.22", R.drawable.juxie);
        constellationList.add(f);
        Constellation_2 g = new Constellation_2("狮子座   07.23~08.23", R.drawable.shizi);
        constellationList.add(g);
        Constellation_2 h = new Constellation_2("处女座   08.24~09.23", R.drawable.chunv);
        constellationList.add(h);
        Constellation_2 i = new Constellation_2("天秤座   09.24~10.23", R.drawable.tianchen);
        constellationList.add(i);
        Constellation_2 j = new Constellation_2("天蝎座   10.24~11.22", R.drawable.tianxie);
        constellationList.add(j);
        Constellation_2 k = new Constellation_2("射手座   11.23~12.21", R.drawable.sheshou);
        constellationList.add(k);
        Constellation_2 l = new Constellation_2("摩羯座   12.22~01.20", R.drawable.mojie);
        constellationList.add(l);
    }
}
