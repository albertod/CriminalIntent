package com.example.alberto.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Alberto on 12/8/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.example.alberto.criminalintent.extra_crime_id";

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
