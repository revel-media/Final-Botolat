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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.krito.io.botolat.R;

import java.util.HashMap;
import java.util.Map;

public class CreateChampionshipActivity extends AppCompatActivity implements View.OnClickListener {
    StringRequest request;
    RequestQueue requestQueue;
    String[] typeArray, matchArray;
    Spinner spinType, spinMatch;
    Button btnSub;
    EditText edtName;
    TextView txtAdd, txtDec, txtNum, txtAddPlayer, txtDecPlayer, txtPlayerCount;
    int incr, playerCount;
    int spType, spMatch;
    String type, champName;
    String home, NumOfTeams;
    String url = "http://192.168.1.4/champions4/public/dashboard/champions";

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
        txtPlayerCount = findViewById(R.id.txt_players_count);
        txtDecPlayer = findViewById(R.id.txt_decr_player);
        txtAddPlayer = findViewById(R.id.txt_incr_player);
        requestQueue = Volley.newRequestQueue(this);
        settype();
        setmatches();
        spinMatch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                home = adapterView.getItemAtPosition(i).toString();
                if (i == 0) {
                    spinMatch.setSelection(0);
                }

                spMatch = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type = adapterView.getItemAtPosition(i).toString();
                if (i == 0) {
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
                spType = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        txtDec.setOnClickListener(this);
        txtAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        txtDecPlayer.setOnClickListener(this);
        txtAddPlayer.setOnClickListener(this);
        btnSub.setOnClickListener(this);
    }

    private void setmatches() {
        matchArray = getResources().getStringArray(R.array.Home);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_text, R.id.spn_match, matchArray);
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
            case R.id.txt_decr_player:
                int count;
                count = Integer.parseInt(txtPlayerCount.getText().toString());
                if (count < 4) {
                    Toast.makeText(this, "this is the minimum count", Toast.LENGTH_SHORT).show();
                } else {
                    count--;
                    txtPlayerCount.setText(String.valueOf(count));
                }
                //playerCount=count;
                break;

            case R.id.txt_incr_player:
                int pcount;
                pcount = Integer.parseInt(txtPlayerCount.getText().toString());
                pcount++;
                txtPlayerCount.setText(String.valueOf(pcount));
                break;

            case R.id.btn:
                if ((edtName.getText().toString().isEmpty()) || spType == 0 || spMatch == 0) {

                    Toast.makeText(this, "please insert champion name", Toast.LENGTH_SHORT).show();
                } else {
                    champName = edtName.getText().toString();
                    playerCount = Integer.parseInt(txtPlayerCount.getText().toString());
                    sendRequest();
                    Intent intent = new Intent(getApplicationContext(), InsertTeamsActivity.class);
                    intent.putExtra("numOfTeams", NumOfTeams);
                    intent.putExtra("type", type);
                    intent.putExtra("players", playerCount);
                    startActivity(intent);
                }
        }
    }

    private void sendRequest() {
        request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(CreateChampionshipActivity.this, "sucessful request", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CreateChampionshipActivity.this, "failed request", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("name", champName);
                map.put("champion_type_id", String.valueOf(spType));
                map.put("teams_number", String.valueOf(NumOfTeams));
                map.put("home_away", String.valueOf(spMatch - 1));
                return map;
            }
        };

        requestQueue.add(request);
    }
}



