package com.krito.io.botolat.activities;

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
    Spinner spinTybe, spinmatch;
    Button btnSub;
    EditText edtName;
    TextView txtAdd, txtDec, txtNum;
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
        spinmatch = findViewById(R.id.spn_match);
        spinTybe = findViewById(R.id.spn_tybe);
        btnSub = findViewById(R.id.btn);
        edtName = findViewById(R.id.edt_name);
        txtDec = findViewById(R.id.txt_decr);
        txtAdd = findViewById(R.id.txt_incr);
        txtNum = findViewById(R.id.txt_count);
        settype();
        setmatches();
        spinmatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                home = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinTybe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "type is " + type, Toast.LENGTH_LONG).show();
                if (type.equals("League")){
                    NumOfTeams=String.valueOf(3);
                    txtNum.setText(NumOfTeams);
                }else if (type.equals("Cup")){
                    NumOfTeams=String.valueOf(2);
                    txtNum.setText(NumOfTeams);
                }else {
                    NumOfTeams=String.valueOf(4);
                    txtNum.setText(NumOfTeams);
                }
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_type_row, matchArray);
        adapter.setDropDownViewResource(R.layout.row_spinners_dropdown);
        spinmatch.setAdapter(adapter);
    }

    private void settype() {
        typeArray = getResources().getStringArray(R.array.Type);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, R.layout.spinner_type_row, typeArray);
        spinTybe.setAdapter(typeAdapter);
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
                    count -= 4;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Cup") && Integer.parseInt(txtNum.getText().toString()) > 2) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    count -= 2;
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
                    count += 4;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                } else if (type.equals("Cup") && Integer.parseInt(txtNum.getText().toString()) >= 2) {
                    int count;
                    count = Integer.parseInt(txtNum.getText().toString());
                    count += 2;
                    NumOfTeams = String.valueOf(count);
                    txtNum.setText(NumOfTeams);
                }
                break;
            case R.id.btn:
                Intent intent = new Intent(getApplicationContext(), InsertTeamsActivity.class);
                intent.putExtra("numOfTeams", NumOfTeams);
                intent.putExtra("type",type);
                startActivity(intent);
        }
    }
}



