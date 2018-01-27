package com.bignerdranch.androidboy.criminalintent1;


import java.util.Date;
import java.util.UUID;

/**
 * Created by androidboy on 18-1-2.
 */

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private java.text.DateFormat mDateFormat;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
        // mDateFormat=DateFormat.getMediumDateFormat(context);
    }
  public Crime(UUID id){
        mId=id;

  }
    public void setId(UUID uuid){
        mId=uuid;
    }
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
