package com.bignerdranch.androidboy.notepad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;


/**
 * Created by androidboy on 18-1-6.
 * note明细fragment的托管activity
 */

public class NoteActivity extends AppCompatActivity {
    public static final String EXTRA_NOTE_ID = "com.bignerdranch.android.";

    //建立用于启动时的activity之间的数据传输
    public static Intent newIntent(Context context, UUID noteId) {
        Intent intent = new Intent(context, NoteActivity.class);
        intent.putExtra(EXTRA_NOTE_ID, noteId);
        return intent;
    }

    //托管fragment
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.note_main);

        if (fragment == null) {
            fragment = new NoteFragment();
            fm.beginTransaction().add(R.id.note_main, fragment)
                    .commit();

        }
    }


}
