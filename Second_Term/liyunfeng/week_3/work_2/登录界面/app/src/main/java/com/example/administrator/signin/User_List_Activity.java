package com.example.administrator.signin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class User_List_Activity extends AppCompatActivity{
    private MySQLiteOpenHelper db;
    private SQLiteDatabase sd;
    private ArrayList<UserInfo> userInfoArrayList;
    private ListView lv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        db = new MySQLiteOpenHelper(this, "user_info.db", null, 1);
        sd = db.getReadableDatabase();
        userInfoArrayList = new ArrayList<>();
        Cursor cursor = sd.rawQuery("select * from User", null);
        while (cursor.getCount()!=0&&cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("user_name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            UserInfo userInfo = new UserInfo(password, name);
            userInfoArrayList.add(userInfo);
        }
        lv = (ListView) findViewById(R.id.listView);
        ListViewAdapter listViewAdapter=new ListViewAdapter(this,R.layout.listviewitem,userInfoArrayList);
        lv.setAdapter(listViewAdapter);
    }

}
