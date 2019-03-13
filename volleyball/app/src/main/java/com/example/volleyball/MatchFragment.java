package com.example.volleyball;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.volleyball.adapter.MatchRecycleAdapter;
import com.example.volleyball.data.MatchData;
import com.example.volleyball.data.MatchDataLab;
import com.example.volleyball.data.MemberData;
import com.example.volleyball.data.TeamData;
import com.example.volleyball.data.VolleyballTAG;

import java.util.ArrayList;
import java.util.List;

public class MatchFragment extends Fragment  {
    private RecyclerView mRecycleView;
    private MatchRecycleAdapter adapter;
    private FloatingActionButton floatingActionButton;
    public static final String TAG="VOLLEYBALL";

    public static final int  REQUESTCODE=333;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_match,container,false);
        mRecycleView=view.findViewById(R.id.match_recycle);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecycleView.addItemDecoration(new DividerItemDecoration(this.getContext(),DividerItemDecoration.VERTICAL));
        setAdapter(MatchDataLab.getInstance().getList());
        Log.i(TAG, "onCreateView:  matchfragment");
        floatingActionButton=view.findViewById(R.id.float_bt);
        floatingActionButton.setOnClickListener(v->{
            Log.i(TAG, "FAB click");
           Intent intent=new Intent(this.getContext(),AddMatchActivity.class);
            startActivity(intent);
        //    if (adapter!=null)
        //        adapter.addItem(createMatch());
        });

        RxBus.getDefault().toObservable(UpdataEvent.class)
                .subscribe(updataEvent -> adapter.updataUi());


        return view;
    }




    public static MatchData createMatch(){
        TeamData[] teamData=new TeamData[2];
        teamData[0]=new TeamData("中国",null);
        teamData[1]=new TeamData("日本",null);
        int score[]={3,0};
        MatchData  match= new MatchData(teamData,score,"100min","2019.1.1","测试数据比赛");
        return match;

    }

    public void setAdapter(List<MatchData> list) {
        adapter=new MatchRecycleAdapter(this.getContext(),list);
        mRecycleView.setAdapter(adapter);
    }


    public void updata(MatchData matchData) {
            adapter.addItem(matchData);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.i(VolleyballTAG.TAG, "onDestroyView: ondestroy");
        
    }
}
