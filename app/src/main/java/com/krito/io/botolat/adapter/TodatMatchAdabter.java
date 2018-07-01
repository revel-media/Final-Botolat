package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 01/07/2018.
 */

public class TodatMatchAdabter extends RecyclerView.Adapter<TodayMatchHolder> {
    @Override
    public TodayMatchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.today_match_row,parent,false);
        return new TodayMatchHolder(view);
    }

    @Override
    public void onBindViewHolder(TodayMatchHolder holder, int position) {

        
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
