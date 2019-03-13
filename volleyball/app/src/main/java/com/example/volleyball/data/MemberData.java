package com.example.volleyball.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MemberData implements Serializable {
    private String name;
    private String position;
    private String country;
    private int[] score;
    private String[] successRate;
    private float[] statistics;

    private static final long serialVersionUID = 1234567890L;

    public MemberData(String name, String position, int[] score, String[] successRate, String country) {
        this.name = name;
        this.position = position;
        this.score = score;
        this.successRate = successRate;
        this.country = country;
    }

    public float[] getStatistics() {
        return statistics;
    }

    public void setStatistics(float[] statistics) {
        this.statistics = statistics;
    }

    public MemberData(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public String[] getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(String[] successRate) {
        this.successRate = successRate;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
