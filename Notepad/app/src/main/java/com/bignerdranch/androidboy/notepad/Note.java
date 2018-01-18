package com.bignerdranch.androidboy.notepad;

import java.util.Date;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-6.
 * 创建一个note类
 */

public class Note {
    //content代表note输入的内容
    private String content;
    //title代表note的标题
    private String title;
    //创建note的日期
    private Date mDate;
    //每个note的id，用于寻找该note
    private UUID mId;

    private Boolean mchecked=false;

    public void setMchecked(Boolean mchecked) {
        this.mchecked = mchecked;
    }

    public Boolean getMchecked() {
        return mchecked;
    }

    public Note() {

        mId=UUID.randomUUID();

    }

    public Note(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
