package com.krito.io.botolat.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.TodayMatchAdapter;

public class TodayMatchFragment extends Fragment {
    RecyclerView recyclerView;
    TodayMatchAdapter todayMatchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
        View view = inflater.inflate(R.layout.activity_today_match, parent, false);
        recyclerView = view.findViewById(R.id.recycler_today);
        todayMatchAdapter =new TodayMatchAdapter(getContext());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(todayMatchAdapter);
        return view;
    }
}

