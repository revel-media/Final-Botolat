
package com.krito.io.botolat.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.krito.io.botolat.R;
import com.krito.io.botolat.adapter.InsertPlayerAdapter;
import com.krito.io.botolat.model.Champoinship;
import com.krito.io.botolat.model.Team;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertTeamsActivity extends AppCompatActivity implements View.OnClickListener {
    String numOfTeams, url, teamImage;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    List<Team> teamList = new ArrayList<>();
    Champoinship champoinship;
    EditText edtTeamName, edtPlayer1, edtPlayer2, edtPlayer3, edtPlayer4;
    ImageView imageView;
    Button btnAdd, btnDone;
    TextView txtMsg, txtMembers, txtTeamName;
    String type;
    int num, playersCount;
    String json;

    List<String> teamPlayers = new ArrayList<>();
    String[] players;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;
    private static int RESULT_LOAD_IMAGE = 1;
    int test;
    RecyclerView recyclerPlayers;
    InsertPlayerAdapter insertPlayerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_teams);
        recyclerPlayers = findViewById(R.id.recycler_players);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        champoinship = new Champoinship();
        edtTeamName = findViewById(R.id.edt_team_name);
        imageView = findViewById(R.id.img_team_logo);
        txtMsg = findViewById(R.id.txt_msg);
        txtTeamName = findViewById(R.id.txt_team_name);
        txtMembers = findViewById(R.id.txt_members);
        btnAdd = findViewById(R.id.btn_add);
        btnDone = findViewById(R.id.btn_done);
        numOfTeams = getIntent().getStringExtra("numOfTeams");
        type = getIntent().getStringExtra("type");
        playersCount = getIntent().getIntExtra("players", 4);
        Toast.makeText(this, " players count is " + playersCount, Toast.LENGTH_SHORT).show();
        num = Integer.parseInt(numOfTeams);

        btnAdd.setOnClickListener(this);
        imageView.setOnClickListener(this);
        btnDone.setOnClickListener(this);
        recyclerPlayers.setLayoutManager(layoutManager);
        insertPlayerAdapter = new InsertPlayerAdapter(this, playersCount);
        recyclerPlayers.setAdapter(insertPlayerAdapter);


    }

    @Override
    public void onClick(View view) {
        String teamName;

        switch (view.getId()) {
            case R.id.btn_add:
                Team team=new Team();
                if (!edtTeamName.getText().toString().isEmpty()) {
                    num--;
                    String name;
                    teamName = edtTeamName.getText().toString();
                    edtTeamName.setText("");
                    players = insertPlayerAdapter.getPlayers();
                    team.setPlayers(players);
                    team.setTeamImage(teamImage);
                    team.setTeamName(teamName);
                    teamList.add(team);
                    if (players.length != playersCount) {
                        Toast.makeText(this, " insert all players", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, " player 1 " + players[0], Toast.LENGTH_SHORT).show();
                        // create object of team and set data inside it then inside champ obj
                        insertPlayerAdapter = new InsertPlayerAdapter(this, playersCount);
                        recyclerPlayers.setAdapter(insertPlayerAdapter);
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        Toast.makeText(this, "you add team" + (num), Toast.LENGTH_SHORT).show();
                        if (num == 0) {
                            visiblity();
                        }
                    }
                }

                break;

            case R.id.img_team_logo:
                showPictureDialog();
                break;
            case R.id.btn_done:
                champoinship.setTeamList(teamList);
                Gson gson = new Gson();
                json = gson.toJson(champoinship);
                Toast.makeText(getApplicationContext(), json, Toast.LENGTH_SHORT).show();
                // sendRequest();
                break;
        }


    }

    private void sendRequest() {
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("data", json);
                return params;
            }
        };
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    private void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }


    private void visiblity() {

        recyclerPlayers.setVisibility(View.GONE);
        edtTeamName.setVisibility(View.GONE);
        txtTeamName.setVisibility(View.GONE);
        txtMembers.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        btnAdd.setVisibility(View.GONE);
        btnDone.setVisibility(View.VISIBLE);
        txtMsg.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);

                    imageView.setImageBitmap(bitmap);
                    saveImage(bitmap);
                    Log.i("team image", teamImage);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnail);
            saveImage(thumbnail);
        }

    }

    private String saveImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        teamImage = Base64.encodeToString(bytes, Base64.DEFAULT);
        return teamImage;
    }
}


