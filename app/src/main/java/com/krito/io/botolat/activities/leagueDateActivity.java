package com.krito.io.botolat.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.krito.io.botolat.R;
import com.krito.io.botolat.model.Team;
import com.krito.io.botolat.adapter.leagueAdapter;

import java.util.ArrayList;
import java.util.List;

public class leagueDateActivity extends AppCompatActivity {
    List<Team> teamList = new ArrayList<>();
    String type;
    TextView txt;
    RecyclerView recyclerView;
    com.krito.io.botolat.adapter.leagueAdapter leagueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_date);
        type = getIntent().getStringExtra("type");
        teamList = (List<Team>) getIntent().getExtras().getSerializable("teamList");
        recyclerView = findViewById(R.id.recycler);
        leagueAdapter=new leagueAdapter(teamList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(leagueAdapter);
    }
}
