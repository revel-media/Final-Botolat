package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.krito.io.botolat.R;

/**
 * Created by Goda on 01/07/2018.
 */

public class RightPlayerHolder extends RecyclerView.ViewHolder {
    protected TextView txtPlayer,txtGoal,txtYellow,txtRed;

    public RightPlayerHolder(View v) {
        super(v);
        txtPlayer=v.findViewById(R.id.txt_rplayer_name);
        txtGoal=v.findViewById(R.id.txt_rplayer_goal);
        txtRed=v.findViewById(R.id.txt_rplayer_red);
        txtYellow=v.findViewById(R.id.txt_rplayer_yellow);
    }
}
