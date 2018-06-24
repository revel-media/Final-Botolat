package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 24/06/2018.
 */

public class GoalAdapter extends RecyclerView.Adapter<GoalHolder> {

    @Override
    public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.goals_item_row,parent,false);
        return new GoalHolder(view);
    }

    @Override
    public void onBindViewHolder(GoalHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
