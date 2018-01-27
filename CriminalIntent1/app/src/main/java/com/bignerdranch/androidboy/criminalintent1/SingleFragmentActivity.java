package com.bignerdranch.androidboy.criminalintent1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by androidboy on 18-1-3.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract android.support.v4.app.Fragment createFragment();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
