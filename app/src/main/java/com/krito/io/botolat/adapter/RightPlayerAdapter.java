package com.krito.io.botolat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.krito.io.botolat.R;
import com.krito.io.botolat.activities.MatchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 01/07/2018.
 */

public class RightPlayerAdapter extends RecyclerView.Adapter<RightPlayerHolder> implements View.OnClickListener {
    private String goal;
    private int total = 0;
    Context context;
    MatchCallback callback;
    List<String> players = new ArrayList<>();
    int startMatch;

    public RightPlayerAdapter(Context context, List<String> players) {
        this.context = context;
        this.players = players;
    }

    @Override
    public RightPlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_right_item_row, parent, false);
        return new RightPlayerHolder(view);
    }

    @Override
    public void onBindViewHolder(final RightPlayerHolder holder, int position) {
        holder.txtGoal.setOnClickListener(this);
        holder.txtYellow.setOnClickListener(this);
        holder.txtYellow.setTag(holder);
        holder.txtRed.setOnClickListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, R.layout.spinner_text, R.id.spn_match, players);
        holder.playerName.setAdapter(arrayAdapter);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View view) {
        RightPlayerHolder rightPlayerHolder = new RightPlayerHolder(view);
        RightPlayerHolder playerHolder = (RightPlayerHolder) view.getTag();
        if (startMatch == 1) {
            switch (view.getId()) {
                case R.id.txt_rplayer_goal:
                    int n = Integer.parseInt(rightPlayerHolder.txtGoal.getText().toString());
                    n++;
                    total++;
                    goal = String.valueOf(n);
                    rightPlayerHolder.txtGoal.setText(goal);
                    String totalGoal = String.valueOf(total);
                    callback.onGoalScored(totalGoal);
                    break;
                case R.id.txt_rplayer_yellow:
                    int yellowNum = Integer.parseInt(rightPlayerHolder.txtYellow.getText().toString());
                    int red = Integer.parseInt(playerHolder.txtRed.getText().toString());

                    if (yellowNum == 2 || red == 1) {
                        Toast.makeText(context, "player is suspended", Toast.LENGTH_SHORT).show();
                    } else if (yellowNum == 1) {
                        rightPlayerHolder.txtYellow.setText("2");
                        playerHolder.txtRed.setText("1");
                    } else
                        rightPlayerHolder.txtYellow.setText("1");
                    break;
                case R.id.txt_rplayer_red:
                    int redCard = Integer.parseInt(rightPlayerHolder.txtRed.getText().toString());
                    if (redCard == 0) {
                        rightPlayerHolder.txtRed.setText("1");
                    } else
                        Toast.makeText(context, "player is suspended", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void setCallback(MatchCallback matchCallback) {
        callback = matchCallback;
    }

    public interface MatchCallback {
        void onGoalScored(String goal);
    }

    public void setStart(int start){
        this.startMatch=start;
    }
}
