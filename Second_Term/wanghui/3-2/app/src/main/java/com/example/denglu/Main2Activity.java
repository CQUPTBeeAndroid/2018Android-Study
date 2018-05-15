package com.example.denglu;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    //创建适配器以及集合
ArrayAdapter<String> adapter;
ArrayList<String> contactList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //适配器读入
        ListView contactView = (ListView)findViewById(R.id.view);
        adapter = new ArrayAdapter<String>(this,R.layout.list_item,contactList);
        contactView.setAdapter(adapter);
        //权限申请，如果没有则申请，有则读取联系人
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }
        else {
            readContacts();
        }
    }
    //读取联系人
    private  void readContacts(){
        Cursor cursor = null;
        try{
            //使用ContentResolver的query方法建立cursor对象
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            if(cursor != null){
                // 读取联系人姓名，以及联系人电话。
                while (cursor.moveToNext()){
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contactList.add(displayName +"\n" + number);
                }
                //告知listview数据发生变化需要更新
                adapter.notifyDataSetChanged();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(cursor != null){
                cursor.close();
            }
        }

    }
    //读取方法，如果读取成功则读取信息，如果不成功则弹出信息。
    public void onRequestPermissionsResult(int requestCode, String[]permissions,int[] grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length >0 && grantResults [0] == PackageManager.PERMISSION_GRANTED){
                    readContacts();
                }
                else {
                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }
}
