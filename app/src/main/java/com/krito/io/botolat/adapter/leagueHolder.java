package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 21/06/2018.
 */

public class leagueHolder extends RecyclerView.ViewHolder {
    ImageView imgTeam1,imgTeam2;
    TextView txtTeam1,txtTeam2;
    EditText edtTime,edtDate;
    public leagueHolder(View view) {
        super(view);
        txtTeam1=view.findViewById(R.id.txt_team1);
        txtTeam2=view.findViewById(R.id.txt_team1);
        imgTeam1=view.findViewById(R.id.img_team1);
        imgTeam2=view.findViewById(R.id.img_team2);
        edtTime=view.findViewById(R.id.time);
        edtDate=view.findViewById(R.id.date);


    }
}
