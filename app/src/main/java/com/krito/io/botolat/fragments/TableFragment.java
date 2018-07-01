package com.krito.io.botolat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 23/06/2018.
 */

public class TableFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view=inflater.inflate(R.layout.fragment_table,parent,false);
        return view;

    }
}
