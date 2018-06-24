package com.krito.io.botolat.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.krito.io.botolat.R;

/**
 * Created by Goda on 24/06/2018.
 */

public class ResultsHolder extends RecyclerView.ViewHolder{
    TextView textView;
    RecyclerView recyclerView;
    ImageView imageView;
    public ResultsHolder(View view) {
        super(view);
        textView=view.findViewById(R.id.res_date);
        imageView=view.findViewById(R.id.img_arrw);
        recyclerView=view.findViewById(R.id.rcycler_teams_result);
    }
}
