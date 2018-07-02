package com.krito.io.botolat.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;
import com.krito.io.botolat.activities.MatchActivity;

/**
 * Created by Goda on 01/07/2018.
 */

public class TodatMatchAdabter extends RecyclerView.Adapter<TodayMatchHolder> implements View.OnClickListener {
    Context context;

    public TodatMatchAdabter(Context context) {
        this.context = context;
    }

    @Override
    public TodayMatchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_match_row, parent, false);
        return new TodayMatchHolder(view);
    }

    @Override
    public void onBindViewHolder(TodayMatchHolder holder, int position) {
        holder.btnMatchStart.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(view.getContext(),MatchActivity.class);
        context.startActivity(intent);
    }

}
