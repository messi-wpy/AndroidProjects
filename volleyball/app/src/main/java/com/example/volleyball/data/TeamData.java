package com.example.volleyball.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class TeamData implements Serializable {

    private  String name;
    private MemberData teamMember[];
    private static final long serialVersionUID = 153565;

    public TeamData(){}

    public TeamData(String name, MemberData[] teamMember) {
        this.name = name;
        this.teamMember = teamMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberData[] getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(MemberData[] teamMember) {
        this.teamMember = teamMember;
    }

}
