package com.krito.io.botolat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.krito.io.botolat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 01/07/2018.
 */

public class LeftPlayerAdapter extends RecyclerView.Adapter<LeftPlayerHolder>
        implements View.OnClickListener {
    public String goal;
    Context context;
    MatchCallback callback;
    int total = 0;
    List<String> players = new ArrayList<>();
    private int startMatch;

    public LeftPlayerAdapter(Context context, List<String> players) {
        this.context = context;
        this.players = players;
    }

    @Override
    public LeftPlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_left_item_row, parent, false);
        return new LeftPlayerHolder(view);
    }

    @Override
    public void onBindViewHolder(LeftPlayerHolder holder, int position) {
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
        LeftPlayerHolder leftPlayerHolder = new LeftPlayerHolder(view);
        if (startMatch == 1) {
            switch (view.getId()) {
                case (R.id.txt_lplayer_goal):
                    int n = Integer.parseInt(leftPlayerHolder.txtGoal.getText().toString());
                    n++;
                    total++;
                    goal = String.valueOf(n);
                    leftPlayerHolder.txtGoal.setText(goal);
                    String totalGoal = String.valueOf(total);
                    callback.onGoalScored(totalGoal);
                    break;
                case (R.id.txt_lplayer_yellow):
                    int yellowNum = Integer.parseInt(leftPlayerHolder.txtYellow.getText().toString());
                    LeftPlayerHolder leftHolder = (LeftPlayerHolder) view.getTag();
                    int red = Integer.parseInt(leftHolder.txtRed.getText().toString());

                    if (yellowNum == 2 || red == 1) {
                        Toast.makeText(context, "player is suspended", Toast.LENGTH_SHORT).show();
                    } else if (yellowNum == 1) {
                        leftPlayerHolder.txtYellow.setText("2");
                        leftHolder.txtRed.setText("1");
                    } else
                        leftPlayerHolder.txtYellow.setText("1");
                    break;
                case (R.id.txt_lplayer_red):
                    int redCard = Integer.parseInt(leftPlayerHolder.txtRed.getText().toString());
                    if (redCard == 0) {
                        leftPlayerHolder.txtRed.setText("1");
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

    public void setStart(int start) {
        this.startMatch = start;
    }
}
