package com.example.hp.ourgank.Assets;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @类名:${CLASS_NAME}
 * @创建人:赵祖元
 * @创建时间：2018/6/9 14:27
 * @简述:  MySQL数据库
 */
public class MySQL extends SQLiteOpenHelper {

    private Context context = null ;

    private static final String CREATE_LOGIN = "create table loginData("
            +"id integer primary key autoincrement,"
            +"account text,"
            +"password text)";

    public MySQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LOGIN);
        Log.d("TAG","建表成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
