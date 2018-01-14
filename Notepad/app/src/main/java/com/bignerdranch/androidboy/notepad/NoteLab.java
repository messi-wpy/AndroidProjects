package com.bignerdranch.androidboy.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-6.
 * note类的总处理，建立数据库，所有关于处理note数据的方法都在该类中
 * 建立了一个该类的静态全局变量sNoteLab，所有类都使用这一对象的方法和数据库
 */

public class NoteLab {
    private static NoteLab sNoteLab;

    private SQLiteDatabase mDatabase;

    //构造器
    private NoteLab(Context context) {
        mDatabase = new NoteBaseHelper(context).getWritableDatabase();

    }

    public static NoteLab get(Context context) {
        if (sNoteLab == null) {
            sNoteLab = new NoteLab(context);
        }
        return sNoteLab;
    }

    //用于将note里的数据输入数据库
    private static ContentValues getContentValues(Note note) {
        ContentValues values = new ContentValues();
        values.put("title", note.getTitle());
        values.put("content", note.getContent());
        values.put("uuid", note.getUUID().toString());
        return values;
    }

    //添加note到数据库中
    public void addNote(Note c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert("notebase", null, values);
    }

    //读取数据库的内容，转为note集合，以便于recycle使用
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        NoteCursorWrapper cursor = queryNotes(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                notes.add(cursor.getNote());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return notes;

    }

    //查询特定的符合id的note
    public Note getNote(UUID Id) {
        NoteCursorWrapper cursorWrapper = queryNotes("uuid=?", new String[]{Id.toString()});
        try {
            if (cursorWrapper.getCount() == 0) {
                return null;
            }
            cursorWrapper.moveToFirst();
            return cursorWrapper.getNote();
        } finally {
            cursorWrapper.close();
        }
    }

    //查询符合条件的数据
    private NoteCursorWrapper queryNotes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                "notebase",
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new NoteCursorWrapper(cursor);
    }

    //更新特定的符合id的note数据库
    public void updateNote(Note note) {
        String uuidstring = note.getUUID().toString();
        ContentValues values = getContentValues(note);
        mDatabase.update("notebase", values, "uuid=?",
                new String[]{uuidstring});
    }

}
