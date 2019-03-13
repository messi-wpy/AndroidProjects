package com.example.volleyball.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MatchData implements Serializable {
    private TeamData[] team;
    private int[] score;
    private String time;
    private String date;
    private String name;
    public static final long serialVersionUID = 2221313;

    public MatchData(){

    }
    public MatchData(TeamData[] team, int[] score, String time, String date, String name) {
        this.team = team;
        this.score = score;
        this.time = time;
        this.date = date;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamData[] getTeam() {
        return team;
    }

    public void setTeam(TeamData[] team) {
        this.team = team;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
