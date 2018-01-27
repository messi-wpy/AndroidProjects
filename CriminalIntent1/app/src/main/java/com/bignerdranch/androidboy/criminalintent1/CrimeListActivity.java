package com.bignerdranch.androidboy.criminalintent1;

import android.support.v4.app.Fragment;

/**
 * Created by androidboy on 18-1-3.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
