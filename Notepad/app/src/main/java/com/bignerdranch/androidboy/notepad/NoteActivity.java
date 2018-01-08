package com.bignerdranch.androidboy.notepad;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;


/**
 * Created by androidboy on 18-1-6.
 */

public class NoteActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE_ID="com.bignerdranch.android.";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);

        if(fragment==null){
            fragment=new NoteFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment)
                    .commit();

        }
    }
    public static Intent newIntent(Context context, UUID noteId){
        Intent intent=new Intent(context,NoteActivity.class);
        intent.putExtra(EXTRA_NOTE_ID,noteId);
        return intent;
    }



}
