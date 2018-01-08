package com.bignerdranch.androidboy.notepad;

/**
 * Created by androidboy on 18-1-8.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by androidboy on 18-1-8.
 */

public class NoteBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME="notebase.db";

    public NoteBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table notebase("
                +"id integer primary key autoincrement,"
                +"title text ,"
                +"content text,"
                +"uuid text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
