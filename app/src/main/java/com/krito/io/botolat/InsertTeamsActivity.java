
package com.krito.io.botolat;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InsertTeamsActivity extends AppCompatActivity implements View.OnClickListener {
    String numOfTeams;
    List<Team> teamList = new ArrayList<>();
    EditText edtTeamName, edtPlayer1, edtPlayer2, edtPlayer3, edtPlayer4;
    ImageView imgTeamLogo;
    Button btnAdd, btnDone;
    String type;
    int num;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_teams);
        edtTeamName = findViewById(R.id.edt_team_name);
        edtPlayer1 = findViewById(R.id.edt_player1);
        edtPlayer2 = findViewById(R.id.edt_player2);
        edtPlayer3 = findViewById(R.id.edt_player3);
        edtPlayer4 = findViewById(R.id.edt_player4);
        imgTeamLogo = findViewById(R.id.img_team_logo);
        btnAdd = findViewById(R.id.btn_add);
        numOfTeams = getIntent().getStringExtra("numOfTeams");
        type = getIntent().getStringExtra("type");
        num = Integer.parseInt(numOfTeams);
        btnAdd.setOnClickListener(this);
        imgTeamLogo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Team team = new Team();
        String teamName;
        List<String> players = new ArrayList<>();
        switch (view.getId()) {
            case R.id.btn_add:
                if (!edtTeamName.getText().toString().isEmpty() && !edtPlayer4.getText().toString().isEmpty() &&
                        !edtPlayer1.getText().toString().isEmpty() && !edtPlayer2.getText().toString().isEmpty()
                        && !edtPlayer3.getText().toString().isEmpty() && num != 0) {
                    teamName = edtTeamName.getText().toString();
                    players.add(edtPlayer1.getText().toString());
                    players.add(edtPlayer2.getText().toString());
                    players.add(edtPlayer3.getText().toString());
                    players.add(edtPlayer4.getText().toString());
                    team.setPlayers(players);
                    team.setTeamName(teamName);
                    teamList.add(team);
                    edtTeamName.setText("");
                    edtPlayer1.setText("");
                    edtPlayer2.setText("");
                    edtPlayer3.setText("");
                    edtPlayer4.setText("");
                    Log.i("player 0 is ", players.get(0));
                    Log.i("num is ", String.valueOf(num--));
                } else if (num == 0) {
                    Toast.makeText(this, "you inserted all teams", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, leagueDateActivity.class);
                    intent.putExtra("type", type);
                    intent.putExtra("teamList", (Serializable) teamList);
                    startActivity(intent);
                }
                break;

            case R.id.img_team_logo:
                Intent imgIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imgIntent.setType("image/*");
                startActivityForResult(imgIntent, RESULT_LOAD_IMAGE);
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            Log.i("IMAGE_URL", "onActivityResult: " + data.getData().getEncodedPath());
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            imgTeamLogo.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }
}
