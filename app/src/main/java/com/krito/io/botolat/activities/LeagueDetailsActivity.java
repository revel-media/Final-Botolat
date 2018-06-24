package com.krito.io.botolat.activities;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.TabsPagerAdapter;

public class LeagueDetailsActivity extends FragmentActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabItem tabArrang, tabTable, tabResult, tabGoal;
    TabsPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_details);
        tabLayout = findViewById(R.id.tablayout);
        tabArrang = findViewById(R.id.tab_arrangement);
        tabGoal = findViewById(R.id.tab_goals);
        tabTable = findViewById(R.id.tab_table);
        tabResult = findViewById(R.id.tab_results);
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}