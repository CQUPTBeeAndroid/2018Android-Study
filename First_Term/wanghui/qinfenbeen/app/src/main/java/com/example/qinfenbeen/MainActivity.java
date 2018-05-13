package com.example.qinfenbeen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private ListView listView;
private List<Map<String,Object>> list;
private int [] images ={R.mipmap.aus,R.mipmap.esp,R.mipmap.fra,R.mipmap.ger,R.mipmap.usa};
private String [] name = {"澳大利亚","西班牙","法国","德国","美国"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview);
        list =new ArrayList<Map<String, Object>>();
        for(int i =0;i<5;i++){
            Map<String,Object>map =new HashMap<String, Object>();
            map.put("img",images[i]);
            map.put("contry",name[i]);
            list.add(map);
        }
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,list,R.layout.listview,new String[]{"img","contry"},new
        int[] {R.id.imageView,R.id.textView2});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"国家",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClick(View view){
        startActivity(new Intent("com.example.qinfenbeen.SecondActivity"));
    }
}
