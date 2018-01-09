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
        List<Note>notes=new ArrayList<>();
        NoteCursorWrapper cursor=queryNotes(null,null);

        try{
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                notes.add(cursor.getNote());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return notes;

    }
    public Note getNote(UUID Id){
        NoteCursorWrapper cursorWrapper=queryNotes("uuid=?",new String[]{Id.toString()});
        try{
            if(cursorWrapper.getCount()==0){
                return null;
            }
            cursorWrapper.moveToFirst();
            return cursorWrapper.getNote();
        }finally {
            cursorWrapper.close();
        }
    }

    private static ContentValues getContentValues(Note note){
        ContentValues values=new ContentValues();
        values.put("title",note.getTitle());
        values.put("content",note.getContent());
        values.put("uuid",note.getUUID().toString());
        return values;
    }

    private NoteCursorWrapper queryNotes(String whereClause,String[] whereArgs){
        Cursor cursor=mDatabase.query(
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
    public void updateNote(Note note){
        String uuidstring=note.getUUID().toString();
        ContentValues values=getContentValues(note);
        mDatabase.update("notebase",values,"uuid=?",
                new String[]{uuidstring});
    }

}
