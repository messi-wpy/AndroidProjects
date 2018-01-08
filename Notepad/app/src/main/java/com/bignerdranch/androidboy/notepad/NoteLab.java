package com.bignerdranch.androidboy.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-6.
 */

public class NoteLab {
    private static NoteLab sNoteLab;

    private SQLiteDatabase mDatabase;



    public static NoteLab get(Context context){
        if(sNoteLab==null){
            sNoteLab=new NoteLab(context);
        }
        return sNoteLab;
    }
    private NoteLab(Context context){
        mDatabase=new NoteBaseHelper(context).getWritableDatabase();

    }
    public void addNote(Note c){
        ContentValues values=getContentValues(c);
        mDatabase.insert("notebase",null,values);
    }
    public List<Note>getNotes(){
        return null;
    }
    public Note getNote(UUID Id){
        return null;
    }
    private static ContentValues getContentValues(Note note){
        ContentValues values=new ContentValues();
        values.put("title",note.getTitle());
        values.put("content",note.getContent());
        values.put("uuid",note.getUUID().toString());
        return values;
    }

}
