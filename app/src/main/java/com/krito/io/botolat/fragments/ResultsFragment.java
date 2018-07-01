package com.krito.io.botolat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.ResultsAdapter;
import com.krito.io.botolat.adapter.ResultsHolder;
import com.krito.io.botolat.adapter.TeamPosAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 23/06/2018.
 */

public class ResultsFragment extends Fragment {
    RecyclerView recyclerView;
    ResultsAdapter resultsAdapter;
    List<String> dates;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_results, parent, false);
        dates = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        resultsAdapter = new ResultsAdapter(getActivity(), dates);
        recyclerView.setAdapter(resultsAdapter);
        dates.add("1994  10  16");
        return view;

    }
}
