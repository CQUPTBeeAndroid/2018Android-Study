package com.example.administrator.signin;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLDataBaseActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText name,password;
    private MySQLiteOpenHelper dbhelper;
    private SharedPreferences sharedPreferences;
    private MySQLiteOpenHelper db;
    private SQLiteDatabase sd;
    private CheckBox rememberPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqldatabase_activity);
        dbhelper=new MySQLiteOpenHelper(this,"user_info.db",null,1);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        rememberPassword=(CheckBox)findViewById(R.id.rememberPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signin:
                int flag=0;
                db = new MySQLiteOpenHelper(this, "user_info.db", null, 1);
                sd = db.getReadableDatabase();
                Cursor cursor = sd.rawQuery("select * from User", null);
                for (int i=1;i<cursor.getCount();i++){
                    while (cursor.getCount()!=0&&cursor.moveToNext()) {
                        String namedata = cursor.getString(cursor.getColumnIndex("user_name"));
                        String passworddata = cursor.getString(cursor.getColumnIndex("password"));
                        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                            @Override
                            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                if (actionId== EditorInfo.IME_ACTION_DONE){

                                }
                                return false;
                            }
                        });
                        String user_name=name.getText().toString();
                        String user_password=password.getText().toString();
                        if (namedata.equals(user_name)&&passworddata.equals(user_password)){
                            AlertDialog dialog=new AlertDialog.Builder(this)
                                    .setTitle("登录提示")
                                    .setMessage("您已登录成功")
                                    .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).create();
                            dialog.show();
                            flag=1;
                            break;
                        }

                    }
                }
                if (flag==0){
                    AlertDialog dialog=new AlertDialog.Builder(this)
                            .setTitle("登录提示")
                            .setMessage("用户名或密码错误")
                            .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create();
                    dialog.show();
                }
                break;
            case R.id.register:
                int flag1=0;
                    try{
                        dbhelper.getWritableDatabase();
                        String user_name=name.getText().toString();
                        String user_password=password.getText().toString();
                        Cursor cursor1 = sd.rawQuery("select * from User", null);
                        while (cursor1.getCount()!=0&&cursor1.moveToNext()){
                            String namedata1 = cursor1.getString(cursor1.getColumnIndex("user_name"));
                            String user_name1=name.getText().toString();
                            if (user_name1.equals(namedata1)){
                                AlertDialog dialog=new AlertDialog.Builder(this)
                                        .setTitle("注册提示")
                                        .setMessage("一般情况是名字已经有啦，名字不能重复")
                                        .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        }).create();
                                dialog.show();
                                flag1=1;
                            }
                        }
                        if (flag1==0){
                            ContentValues values=new ContentValues();
                            SQLiteDatabase db=dbhelper.getWritableDatabase();
                            values.put("user_name",user_name);
                            values.put("password",user_password);
                            db.insert("User",null,values);
                            Toast.makeText(this,"已创建",Toast.LENGTH_SHORT).show();

                            if (rememberPassword.isChecked()){
                                sharedPreferences=getSharedPreferences(user_name,MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("password",user_password);
                                editor.commit();
                            }
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                break;
            case R.id.button:
                Intent intent=new Intent(this,User_List_Activity.class);
                startActivity(intent);
                break;
        }


    }

}
