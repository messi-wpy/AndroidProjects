package com.example.volleyball;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {

    private TextView mTextView;
    public static BaseFragment newInstance(String name){
        Bundle args=new Bundle();
        BaseFragment baseFragment=new BaseFragment();
        args.putString("name",name);
        baseFragment.setArguments(args);
        return baseFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_base,null);
        mTextView=view.findViewById(R.id.fragment_text);
        mTextView.setText(getArguments().getString("name"));
        return  view;
    }

}
