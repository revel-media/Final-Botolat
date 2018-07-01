package com.krito.io.botolat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.GoalAdapter;
import com.krito.io.botolat.adapter.TeamPosAdapter;
import com.krito.io.botolat.model.ChampTeam;
import com.krito.io.botolat.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 23/06/2018.
 */

public class GoalsFragment extends Fragment {
    RecyclerView recyclerView;
    List<Team> teams=new ArrayList<>();
    GoalAdapter goalAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view=inflater.inflate(R.layout.fragment_goals,parent,false);
        recyclerView=view.findViewById(R.id.recyclers_goals);
        goalAdapter=new GoalAdapter();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(goalAdapter);
        return view;

    }


}
