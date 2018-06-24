
package com.krito.io.botolat.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.krito.io.botolat.R;
import com.krito.io.botolat.model.Team;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InsertTeamsActivity extends AppCompatActivity implements View.OnClickListener {
    String numOfTeams;
    List<Team> teamList = new ArrayList<>();
    EditText edtTeamName, edtPlayer1, edtPlayer2, edtPlayer3, edtPlayer4;
    ImageView imageView;
    Button btnAdd, btnDone;
    TextView txtMsg, txtMembers, txtTeamName;
    String type;
    int num;
    private static final String IMAGE_DIRECTORY = "/demonuts";
    private int GALLERY = 1, CAMERA = 2;
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
        imageView = findViewById(R.id.img_team_logo);
        txtMsg = findViewById(R.id.txt_msg);
        txtTeamName = findViewById(R.id.txt_team_name);
        txtMembers = findViewById(R.id.txt_members);
        btnAdd = findViewById(R.id.btn_add);
        btnDone = findViewById(R.id.btn_done);
        numOfTeams = getIntent().getStringExtra("numOfTeams");
        type = getIntent().getStringExtra("type");
        num = Integer.parseInt(numOfTeams);
        btnAdd.setOnClickListener(this);
        imageView.setOnClickListener(this);
        btnDone.setOnClickListener(this);


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
                    if (num == 0) {
                        visiblity();
                    }
                }
                break;

            case R.id.img_team_logo:
                showPictureDialog();
                break;
            case R.id.btn_done:
                Intent intent = new Intent(this, leagueDateActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("teamList", (Serializable) teamList);
                startActivity(intent);
                break;
        }


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
        edtPlayer1.setVisibility(View.GONE);
        edtPlayer2.setVisibility(View.GONE);
        edtPlayer3.setVisibility(View.GONE);
        edtPlayer4.setVisibility(View.GONE);
        edtTeamName.setVisibility(View.GONE);
        txtTeamName.setVisibility(View.GONE);
        txtMembers.setVisibility(View.GONE);
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
                    Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    imageView.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }

    }

    private String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
}


