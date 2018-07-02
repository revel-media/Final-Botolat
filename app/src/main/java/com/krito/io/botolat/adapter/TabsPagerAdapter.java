package com.krito.io.botolat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.krito.io.botolat.activities.TodayMatchFragment;
import com.krito.io.botolat.fragments.GoalsFragment;
import com.krito.io.botolat.fragments.ResultsFragment;
import com.krito.io.botolat.fragments.TeamsPositionFragment;

/**
 * Created by Goda on 23/06/2018.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TodayMatchFragment();
            case 1:
                return new GoalsFragment();
            case 2:
                return new TeamsPositionFragment();
            case 3:
                return new ResultsFragment();
            default:
                return new TeamsPositionFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
