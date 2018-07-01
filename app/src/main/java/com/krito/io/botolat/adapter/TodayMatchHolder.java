package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 01/07/2018.
 */

public class TodayMatchHolder extends RecyclerView.ViewHolder {
    ImageView teamImage1,teamImage2;
    TextView txtTeam1,txtTeam2,txtTime,txtMatchStart,txtDetails;

    public TodayMatchHolder(View view) {
        super(view);
        teamImage1=view.findViewById(R.id.image_result_team1);
        teamImage2=view.findViewById(R.id.image_result_team2);
        txtTeam1=view.findViewById(R.id.text_team1);
        txtTeam2=view.findViewById(R.id.text_team2);
        txtTime=view.findViewById(R.id.text_time);
        txtMatchStart=view.findViewById(R.id.text_match_start);
        txtDetails=view.findViewById(R.id.text_details);
    }
}
