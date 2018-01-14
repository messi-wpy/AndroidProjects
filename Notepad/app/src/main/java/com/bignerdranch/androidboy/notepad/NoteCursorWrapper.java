package com.bignerdranch.androidboy.notepad;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

/**
 * Created by androidboy on 18-1-9.
 * 辅助读取数据储存的内容
 */

public class NoteCursorWrapper extends CursorWrapper {
    public NoteCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Note getNote() {
        String uuidString = getString(getColumnIndex("uuid"));
        String titile = getString(getColumnIndex("title"));
        String content = getString(getColumnIndex("content"));

        Note note = new Note(UUID.fromString(uuidString));
        note.setTitle(titile);
        note.setContent(content);
        return note;
    }

}
