package com.bignerdranch.androidboy.notepad;

import java.util.Date;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-6.
 */

public class Note {
    private String content;
    private String title;
    private Date mDate;
    private UUID mId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Note(){
        mDate=new Date();
        mId=UUID.randomUUID();

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getUUID() {
        return mId;
    }

    public void setUUID(UUID UUID) {
        mId = UUID;
    }
}
