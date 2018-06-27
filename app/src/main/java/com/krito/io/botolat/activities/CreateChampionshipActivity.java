package com.krito.io.botolat.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.krito.io.botolat.R;

public class CreateChampionshipActivity extends AppCompatActivity implements View.OnClickListener {
    String[] typeArray, matchArray;
    Spinner spinType, spinMatch;
    Button btnSub;
    EditText edtName;
    TextView txtAdd, txtDec, txtNum;
    int incr;
    int spType ,spMatch;
    String type;
    String home;
    String NumOfTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_championship);
        getSupportActionBar().setTitle("rezetopia");
        getSupportActionBar().setIcon(R.drawable.ic_logo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#021408")));
        spinMatch = findViewById(R.id.spn_match);
        spinType = findViewById(R.id.spn_type);
        btnSub = findViewById(R.id.btn);
        edtName = findViewById(R.id.edt_name);
        txtDec = findViewById(R.id.txt_decr);
        txtAdd = findViewById(R.id.txt_incr);
        txtNum = findViewById(R.id.txt_count);
        settype();
        setmatches();
        spinMatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                home = adapterView.getItemAtPosition(i).toString();
                if (i==0){
                    spinMatch.setSelection(0);
                }

                spMatch=i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = adapterView.getItemAtPosition(i).toString();
                if (i==0){
                    spinType.setSelection(0);
                }
                if (type.equals("League")) {
                    NumOfTeams = String.valueOf(3);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Cup")) {
                    NumOfTeams = String.valueOf(2);
                    txtNum.setText(NumOfTeams);
                } else {
                    NumOfTeams = String.valueOf(4);
                    txtNum.setText(NumOfTeams);
                }
                spType=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        txtDec.setOnClickListener(this);
        txtAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
    }

    private void setmatches() {
        matchArray = getResources().getStringArray(R.array.Home);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_text,R.id.spn_match, matchArray);
        spinMatch.setAdapter(adapter);
    }

    private void settype() {
        typeArray = getResources().getStringArray(R.array.Type);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, R.layout.spinner_text, R.id.spn_match, typeArray);
        spinType.setAdapter(typeAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_decr:
                if (type.equals("League") && Integer.parseInt(txtNum.getText().toString()) > 3) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    count--;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Knockout") && Integer.parseInt(txtNum.getText().toString()) > 4) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    incr = incr / 2;
                    count -= incr;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Cup") && Integer.parseInt(txtNum.getText().toString()) > 2) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    incr = incr / 2;
                    count -= incr;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                }
                break;
            case R.id.txt_incr:
                if (type.equals("League") && Integer.parseInt(txtNum.getText().toString()) >= 3) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    count++;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Knockout") && Integer.parseInt(txtNum.getText().toString()) >= 4) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());

                    count += count;
                    incr = count;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Cup") && Integer.parseInt(txtNum.getText().toString()) >= 2) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    count += count;
                    incr = count;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                }
                break;
            case R.id.btn:
                if ((edtName.getText().toString().isEmpty()) || spType==0 || spMatch==0 ) {

                    Toast.makeText(this, "please insert champion name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), InsertTeamsActivity.class);
                    intent.putExtra("numOfTeams", NumOfTeams);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }
        }
    }
}



