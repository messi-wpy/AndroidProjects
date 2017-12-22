package com.bignerdranch.androidboy.geoquiz;

/**
 * Created by androidboy on 17-12-15.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    private int tag;
    private boolean HaveCheated;

    public boolean isHaveCheated() {
        return HaveCheated;
    }

    public void setHaveCheated(boolean haveCheated) {
        HaveCheated = haveCheated;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public Question(int textResId, boolean answerTrue){
        mTextResId=textResId;
        mAnswerTrue=answerTrue;
        tag=0;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
