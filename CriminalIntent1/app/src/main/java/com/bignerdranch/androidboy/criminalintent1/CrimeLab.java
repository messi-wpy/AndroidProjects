package com.bignerdranch.androidboy.criminalintent1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-3.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private SQLiteDatabase mDatabase;
    private Context mContext;


    private CrimeLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CrimeDatebaseHelper(mContext).getWritableDatabase();
    }

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery("select*from Crime", null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                crimes.add(cursorCrime(cursor));
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return crimes;
    }

    public Crime getCrime(UUID id) {
        Cursor cursor = mDatabase.query("Crime", null, "uuid=?", new String[]{id.toString()}, null, null, null);
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursorCrime(cursor);
        } finally {
            cursor.close();
        }
    }

    public void addCrime(Crime crime) {
        ContentValues values = getContentValues(crime);
        mDatabase.insert("Crime", null, values);
    }

    public static ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(FinaldbName.UUID, crime.getId().toString());
        values.put(FinaldbName.DATE, crime.getDate().getTime());
        values.put(FinaldbName.SOLVED, crime.isSolved() ? 1 : 0);
        values.put(FinaldbName.TITLE, crime.getTitle());
        return values;
    }

    public void updateCrime(Crime crime) {
        String uuidstring = crime.getId().toString();
        ContentValues values = getContentValues(crime);
        mDatabase.update("Crime", values, FinaldbName.UUID + "=?", new String[]{uuidstring});
    }

    private Cursor queryCrimes() {
        Cursor cursor = mDatabase.rawQuery("select*from Crime", null);
        return cursor;
    }

    private Crime cursorCrime(Cursor cursor) {
        Crime crime = new Crime(UUID.fromString(cursor.getString(cursor.getColumnIndex(FinaldbName.UUID))));
        crime.setDate(new Date(cursor.getLong(cursor.getColumnIndex(FinaldbName.DATE))));
        crime.setSolved(cursor.getInt(cursor.getColumnIndex(FinaldbName.SOLVED)) != 0);
        crime.setTitle(cursor.getString(cursor.getColumnIndex(FinaldbName.TITLE)));
        return crime;
    }

}
