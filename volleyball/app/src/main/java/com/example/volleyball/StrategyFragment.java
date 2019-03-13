package com.example.volleyball;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.volleyball.data.VolleyballTAG;

public class StrategyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_strategy,container,false);
        return view;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(VolleyballTAG.TAG, "onDestroy: stragyfragment ondestroy");

    }


}