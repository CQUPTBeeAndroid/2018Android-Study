package com.example.a10442.worktwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

private List<Phone> phoneList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initphone();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PhoneAdapter2 adapter2 = new PhoneAdapter2(phoneList);
        recyclerView.setAdapter(adapter2);
        CircleimageView icon;
        icon= (CircleimageView) findViewById(R.id.circleImageView);
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
}}
