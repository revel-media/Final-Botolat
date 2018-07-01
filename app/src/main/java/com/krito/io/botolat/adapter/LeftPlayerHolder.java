package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 01/07/2018.
 */

public class LeftPlayerHolder extends RecyclerView.ViewHolder {
    protected TextView txtPlayer, txtGoal, txtYellow, txtRed;

    public LeftPlayerHolder(View view) {
        super(view);
        txtPlayer=view.findViewById(R.id.txt_lplayer_name);
        txtGoal=view.findViewById(R.id.txt_lplayer_goal);
        txtRed=view.findViewById(R.id.txt_lplayer_red);
        txtYellow=view.findViewById(R.id.txt_lplayer_yellow);
    }
}
