package com.krito.io.botolat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.ChampionshipAdapter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn, btnCreate;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] text={"text0","text0","text0","text0","text0","text0"};
        gridView=findViewById(R.id.grid_champs);
        ChampionshipAdapter adapter=new ChampionshipAdapter(MainActivity.this,text);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get data of item by object.get(i);

                Intent intent =new Intent(MainActivity.this ,LeagueDetailsActivity.class);
                startActivity(intent);
            }
        });
        btnCreate = findViewById(R.id.btn_create_champ);
        btnCreate.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.btn_create_champ:
                Intent createIntent = new Intent(this, CreateChampionshipActivity.class);
                startActivity(createIntent);


        }
    }

}
