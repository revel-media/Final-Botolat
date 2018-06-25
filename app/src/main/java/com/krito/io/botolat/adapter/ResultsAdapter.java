package com.krito.io.botolat.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 24/06/2018.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsHolder> implements View.OnClickListener {
    Context context;
    List<String> dates = new ArrayList<>();
    TeamResultAdapter teamResultAdapter;

    public ResultsAdapter(Context context, List<String> dates) {
        this.context = context;
        this.dates = dates;
    }

    @Override
    public ResultsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.results_item_row, parent, false);
        return new ResultsHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultsHolder holder, int position) {
        String date = dates.get(position);
        holder.textView.setText(date);
        holder.recyclerView.setVisibility(View.GONE);
        holder.imageView.setOnClickListener(this);
        holder.imageView.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onClick(View view) {
        ResultsHolder holder = (ResultsHolder) view.getTag();
        if (holder.recyclerView.getVisibility() == View.GONE) {
            teamResultAdapter = new TeamResultAdapter(context);
            holder.imageView.setImageResource(R.drawable.ic_arrow_up);
            holder.recyclerView.setVisibility(View.VISIBLE);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            holder.recyclerView.setLayoutManager(layoutManager);
            holder.recyclerView.setAdapter(teamResultAdapter);
        }else {
            holder.imageView.setImageResource(R.drawable.ic_arrow);
            holder.recyclerView.setVisibility(View.GONE);
        }

    }
}
