package com.example.volleyball.data;

import java.util.ArrayList;
import java.util.List;

public class MatchDataLab {

    private static MatchDataLab sMatchdata;
    private List<MatchData>list;
    private boolean hasUpload=false;


    public boolean isHasUpload() {
        return hasUpload;
    }

    public void setHasUpload(boolean hasUpload) {
        this.hasUpload = hasUpload;
    }


    private MatchDataLab(){
        list=new ArrayList<>();
    }
    public static MatchDataLab getInstance(){
        if (sMatchdata==null)
            sMatchdata=new MatchDataLab();
        return sMatchdata;

    }

    public MatchData getMatchData(int i){
        if (i<list.size())
            return list.get(i);
        return null;
    }

    public List<MatchData> getList() {
        return list;
    }

    public void addList(List<MatchData>l){
        list.addAll(l);

    }
    public void addMatch(MatchData matchData){
        list.add(matchData);

    }

    public MatchData getLast(){
        return list.get(list.size()-1);

    }

}
