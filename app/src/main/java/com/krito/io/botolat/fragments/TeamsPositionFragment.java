package com.krito.io.botolat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.TeamPosAdapter;
import com.krito.io.botolat.model.ChampTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 23/06/2018.
 */

public class TeamsPositionFragment extends Fragment {
    List<ChampTeam> champTeams=new ArrayList<>();
    RecyclerView recyclerView;
    TeamPosAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view=inflater.inflate(R.layout.fragment_teams_position,parent,false);
        recyclerView=view.findViewById(R.id.recycler_position);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new TeamPosAdapter(getActivity(),champTeams);
        recyclerView.setAdapter(adapter);
        tryData();
        return view;

    }
    private void tryData() {
        ChampTeam team=new ChampTeam();
        team.setDeff(8);
        team.setPlay(4);
        team.setWins(3);
        team.setLose(1);
        team.setDraw(0);
        team.setPoints(9);
        team.setPos(2);
        team.setTeamName("lol");
        champTeams.add(team);
    }
}
