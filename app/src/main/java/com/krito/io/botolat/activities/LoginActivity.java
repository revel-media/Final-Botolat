package com.krito.io.botolat.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.krito.io.botolat.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtUsername,edtPassword;
    Button btnLogin , btnReg;
    TextView txtForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername=findViewById(R.id.edit_username);
        edtPassword=findViewById(R.id.edt_password);
        btnLogin=findViewById(R.id.btn_sign);
        btnReg=findViewById(R.id.reg);
        txtForget=findViewById(R.id.txt_forget);
        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);
        txtForget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
