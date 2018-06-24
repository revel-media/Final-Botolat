package com.krito.io.botolat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.krito.io.botolat.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn,btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.tbnn);
        btnCreate=findViewById(R.id.btn_create_champ);
        btnCreate.setOnClickListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tbnn:
                Intent intent=new Intent(this,LeagueDetailsActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.btn_create_champ:
                Intent createIntent=new Intent(this,CreateChampionshipActivity.class);
                startActivity(createIntent);
                finish();

        }

    }
}
