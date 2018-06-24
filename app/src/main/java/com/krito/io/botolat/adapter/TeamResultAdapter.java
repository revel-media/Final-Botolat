package com.krito.io.botolat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;

import java.util.Date;
import java.util.List;

/**
 * Created by Goda on 24/06/2018.
 */

public class TeamResultAdapter extends RecyclerView.Adapter<TeamResultHolder> {
    Context context;
    public TeamResultAdapter (Context context){
        this.context=context;
    }
    @Override
    public TeamResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_result_row,parent,false);
        return new TeamResultHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamResultHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
