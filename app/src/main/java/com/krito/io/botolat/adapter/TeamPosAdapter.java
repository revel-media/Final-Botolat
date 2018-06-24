package com.krito.io.botolat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;
import com.krito.io.botolat.model.ChampTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 23/06/2018.
 */

public class TeamPosAdapter extends RecyclerView.Adapter<TeamPosHolder> {
    List<ChampTeam>champTeams=new ArrayList<>();
    Context context;
    public TeamPosAdapter(Context context, List<ChampTeam> champTeams){
        this.context=context;
        this.champTeams=champTeams;
    }
    @Override
    public TeamPosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.team_position_row,parent,false);
        return new TeamPosHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamPosHolder holder, int position) {
        ChampTeam team=champTeams.get(position);
        holder.txtPos.setText(String.valueOf(team.getPos()));
        holder.txtPoints.setText(String.valueOf(team.getPoints()));
        holder.txtDraw.setText(String.valueOf(team.getDraw()));
        holder.txtDeff.setText(String.valueOf(team.getDeff()));
        holder.txtPlay.setText(String.valueOf(team.getPlay()));
        holder.txtWin.setText(String.valueOf(team.getWins()));
        holder.txtLose.setText(String.valueOf(team.getLose()));
        holder.txtTeam.setText(team.getTeamName());

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
