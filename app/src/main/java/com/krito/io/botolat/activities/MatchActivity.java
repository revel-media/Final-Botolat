package com.krito.io.botolat.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.LeftPlayerAdapter;
import com.krito.io.botolat.adapter.RightPlayerAdapter;

public class MatchActivity extends AppCompatActivity {

    RecyclerView rightRecycler, leftRecycler;
    RightPlayerAdapter rightPlayerAdapter;
    LeftPlayerAdapter leftPlayerAdapter;
    TextView txtTeam1Goal, txtTeam2Goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        txtTeam1Goal = findViewById(R.id.txt_team1_goal);
        txtTeam2Goal = findViewById(R.id.txt_team2_goal);
        rightPlayerAdapter = new RightPlayerAdapter(this);
        leftPlayerAdapter = new LeftPlayerAdapter(this);
        rightRecycler = findViewById(R.id.recycler_team2);
        leftRecycler = findViewById(R.id.recycler_team1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        leftRecycler.setLayoutManager(layoutManager);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        rightRecycler.setLayoutManager(layoutManager1);
        rightRecycler.setAdapter(rightPlayerAdapter);
        leftRecycler.setAdapter(leftPlayerAdapter);
        rightPlayerAdapter.setCallback(new RightPlayerAdapter.MatchCallback() {
            @Override
            public void onGoalScored(String goal) {
                txtTeam2Goal.setText(goal);
            }
        });
        leftPlayerAdapter.setCallback(new LeftPlayerAdapter.MatchCallback() {
            @Override
            public void onGoalScored(String goal) {
                txtTeam1Goal.setText(goal);
            }
        });


    }
}
