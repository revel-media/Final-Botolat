package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 23/06/2018.
 */

public class TeamPosHolder extends RecyclerView.ViewHolder {
    protected TextView txtTeam,txtPos,txtPlay,txtWin,txtLose,txtDraw,txtDeff,txtPoints;
    public TeamPosHolder(View view) {
        super(view);
        txtPos=view.findViewById(R.id.txt_pos);
        txtDeff=view.findViewById(R.id.txt_deff);
        txtTeam=view.findViewById(R.id.txt_team);
        txtPlay=view.findViewById(R.id.txt_play);
        txtPoints=view.findViewById(R.id.txt_points);
        txtDraw=view.findViewById(R.id.txt_draw);
        txtLose=view.findViewById(R.id.txt_lose);
        txtWin=view.findViewById(R.id.txt_win);
    }
}
