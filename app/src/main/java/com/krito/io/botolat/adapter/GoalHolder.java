package com.krito.io.botolat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.krito.io.botolat.R;

import org.w3c.dom.Text;

/**
 * Created by Goda on 24/06/2018.
 */

public class GoalHolder extends RecyclerView.ViewHolder {
    TextView txtGoalsCount,txtPos,txtteam;
    ImageView imgPlayer;
    public GoalHolder(View v) {
        super(v);
        txtGoalsCount=v.findViewById(R.id.text_goal);
        txtPos=v.findViewById(R.id.text_player_pos);
        txtteam=v.findViewById(R.id.text_team);
        imgPlayer=v.findViewById(R.id.image_player);
    }
}
