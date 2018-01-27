package com.bignerdranch.androidboy.criminalintent1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by androidboy on 18-1-27.
 */

public class CrimeDatebaseHelper extends SQLiteOpenHelper {
    public CrimeDatebaseHelper(Context context) {
        super(context, "Crime", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + FinaldbName.NAME + "("
                + "id integer primary key autoincrement,"
                + FinaldbName.DATE + ","
                + FinaldbName.SOLVED + ","
                + FinaldbName.TITLE + ","
                + FinaldbName.UUID + ")");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
