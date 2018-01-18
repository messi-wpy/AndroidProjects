package com.bignerdranch.androidboy.notepad;

/**
 * Created by androidboy on 18-1-8.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by androidboy on 18-1-8.
 * 建立sqlhelper类，用Android自带类辅助处理sql数据库
 */

public class NoteBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;//数据库版本号
    private static final String DATABASE_NAME = "notebase.db";//数据库名称

    //实现其三个方法
    public NoteBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    //建立数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notebase("
                + "id integer primary key autoincrement,"
                + "title ,"
                + "content ,"
                + "uuid )");
    }

    //更新升级，现在没用上
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void delete(String UUID){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("delete from notebase where uuid=?",new String []{UUID});
    }


}
