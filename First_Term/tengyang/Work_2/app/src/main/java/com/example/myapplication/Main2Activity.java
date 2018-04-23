package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private List<Constellation> constellationList = new ArrayList<>();
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inconstellation();
        ConstellationAdapter adapter = new ConstellationAdapter(Main2Activity.this,
                R.layout.constellation, constellationList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Constellation c=constellationList.get(position);
                Toast.makeText(Main2Activity.this,c.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void inconstellation() {
        Constellation a=new Constellation("水瓶座   01.21~02.19",R.drawable.shuiping);
        constellationList.add(a);
        Constellation b=new Constellation("双鱼座   02.20~03.20",R.drawable.shuangyu);
        constellationList.add(b);
        Constellation c=new Constellation("白羊座   03.21~04.20",R.drawable.baiyang);
        constellationList.add(c);
        Constellation d=new Constellation("金牛座   04.21~05.21",R.drawable.jinniu);
        constellationList.add(d);
        Constellation e=new Constellation("双子座   05.22~06.21",R.drawable.shuangyu);
        constellationList.add(e);
        Constellation f=new Constellation("巨蟹座   06.22~07.22",R.drawable.juxie);
        constellationList.add(f);
        Constellation g=new Constellation("狮子座   07.23~08.23",R.drawable.shizi);
        constellationList.add(g);
        Constellation h=new Constellation("处女座   08.24~09.23",R.drawable.chunv);
        constellationList.add(h);
        Constellation i=new Constellation("天秤座   09.24~10.23",R.drawable.tianchen);
        constellationList.add(i);
        Constellation j=new Constellation("天蝎座   10.24~11.22",R.drawable.tianxie);
        constellationList.add(j);
        Constellation k=new Constellation("射手座   11.23~12.21",R.drawable.sheshou);
        constellationList.add(k);
        Constellation l=new Constellation("摩羯座   12.22~01.20",R.drawable.mojie);
        constellationList.add(l);
    }
}




