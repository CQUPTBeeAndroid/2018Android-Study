package com.example.a10442.worktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private List<Phone>phoneList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        initphone();
        PhoneAdapter adapter1 = new PhoneAdapter(FirstActivity.this,R.layout.phone_item,phoneList);
        ListView listView =(ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Phone phone = phoneList.get(position);
                Toast.makeText(FirstActivity.this,phone.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initphone(){
        for (int i = 0;i < 2;i++){
            Phone iphonex = new Phone("IPhoneX",R.drawable.apple);
            phoneList.add(iphonex);
            Phone iphone8 = new Phone("IPhone8",R.drawable.apple);
            phoneList.add(iphone8);
            Phone android1 = new Phone("android1",R.drawable.android);
            phoneList.add(android1);
            Phone android2 = new Phone("android2",R.drawable.android);
            phoneList.add(android2);
            Phone p20 = new Phone("P20",R.drawable.huawei);
            phoneList.add(p20);
            Phone mate10 = new Phone("mate10",R.drawable.huawei);
            phoneList.add(mate10);
            Phone xiaomi6 = new Phone("小米6",R.drawable.xiaomi);
            phoneList.add(xiaomi6);
            Phone xiaominote = new Phone("小米note",R.drawable.xiaomi);
            phoneList.add(xiaominote);
            Phone surfacepro = new Phone("Surface Pro",R.drawable.windows);
            phoneList.add(surfacepro);
            Phone surfacebook = new Phone("Surface Book",R.drawable.windows);
            phoneList.add(surfacebook);

        }
    }
}
