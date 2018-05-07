package com.example.hp.level_3.fragment;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.level_3.R;
import com.example.hp.level_3.activity.Main3Activity;
import com.example.hp.level_3.adapter.MyListAdapter;

import java.util.ArrayList;

/**
 * 将手机联系人读取并放在列表中去
 * @date:2018/5/5
 */
public class ContactFragment extends android.support.v4.app.Fragment {

    private ArrayList<Person>people = new ArrayList<>();    //联系人数据

    private ListView listView;

    private Main3Activity activity;

    private MyListAdapter myListAdapter;        //列表适配器

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        activity = (Main3Activity)getActivity();

        View view = inflater.inflate(R.layout.contact_fragment,container,false);

//        初始化列表
        initListView(view);

//        获取权限
        if(ContextCompat.checkSelfPermission(activity,Manifest.permission.READ_CONTACTS) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,new String[]{ Manifest.permission
                    .READ_CONTACTS },1);
        }else {
            readData();
        }


        return view;
    }

//初始化ListView
    private void initListView(View view){

        listView = (ListView)view.findViewById(R.id.contact_list);
        myListAdapter = new MyListAdapter(people,activity);
        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(activity,"您选择了--"+people.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

//    获取读取联系人的权限
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else {
                    Toast.makeText(activity,"无访问权限！",Toast.LENGTH_SHORT);
                }
                break;
            default:
                break;
        }
    }

//    读取联系人资料
    private void readData(){
        Cursor cursor = null;
        Person one ;
        try {
            cursor = activity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,null,null,null);
            if(cursor != null){
                while (cursor.moveToNext()){
//                    姓名
                    String displayName = cursor.getString(cursor.getColumnIndex
                            (ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                    手机号
                    String displayNum = cursor.getString(cursor.getColumnIndex
                            (ContactsContract.CommonDataKinds.Phone.NUMBER));

                    one = new Person(displayName,displayNum);

                    people.add(one);
                }
                myListAdapter.notifyDataSetChanged();       //提示刷新列表
            }
        }catch (Exception e){}finally {
            if(cursor != null){
                cursor.close();
            }
        }
    }

    /**
     * 联系人
     */
    public class Person{
        String name;
        String phoneNumb;

        Person(String name,String phoneNumb){
            this.name = name;
            this.phoneNumb = phoneNumb;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumb() {
            return phoneNumb;
        }
    }
}
