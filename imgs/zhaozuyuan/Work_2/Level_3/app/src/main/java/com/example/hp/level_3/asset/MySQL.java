package com.example.hp.level_3.asset;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MySQL extends SQLiteOpenHelper {

    public static final String CREATE_LOGIN = "create table Login("
            + "id integer primary key autoincrement,"
            + "account text,"
            + "password text)";

    public static final String CREATE_DATA = "create table data("
            + "id integer primary key autoincrement,"
            + "person text,"
            + "phone integer)";

    private Context mContext;

    public MySQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATA);
        sqLiteDatabase.execSQL(CREATE_LOGIN);
        Toast.makeText(mContext,"成功！",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
