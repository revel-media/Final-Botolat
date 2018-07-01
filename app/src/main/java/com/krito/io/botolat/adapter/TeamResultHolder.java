package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 24/06/2018.
 */

public class TeamResultHolder extends RecyclerView.ViewHolder {
    ImageView imgTeam1,imgTeam2;
    TextView txtDate,txtTime,txtName1,txtName2;
    public TeamResultHolder(View view) {
        super(view);
        imgTeam1=view.findViewById(R.id.image_result_team1);
        imgTeam2=view.findViewById(R.id.image_result_team2);
        txtDate=view.findViewById(R.id.text_match_start);
        txtTime=view.findViewById(R.id.text_details);
        txtName1=view.findViewById(R.id.text_team1);
        txtName2=view.findViewById(R.id.text_team2);
    }
}
