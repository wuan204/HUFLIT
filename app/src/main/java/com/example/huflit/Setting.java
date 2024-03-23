package com.example.huflit;// ...

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Setting extends AppCompatActivity implements Confirm_LogOut.ConfirmLogoutListener {

    TextView txtLogOut;
    ImageView imgBack,imgnext,btntest;
    LinearLayout NgonNgu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        txtLogOut = findViewById(R.id.txtLogOut);
        imgBack = findViewById(R.id.imgBack);
        imgnext = findViewById(R.id.imgnext);
        NgonNgu = findViewById(R.id.NgonNgu);
        btntest=findViewById(R.id.btntest);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Setting.this, QLyDanhMuc.class);
                startActivity(i);
            }
        });
        txtLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmLogoutDialog();
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        NgonNgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Setting.this,Language_Setting.class);
                startActivity(i);
            }
        });
    }

    private void showConfirmLogoutDialog() {
        Confirm_LogOut dialog = new Confirm_LogOut();
        dialog.setConfirmLogoutListener(this);
        dialog.show(getSupportFragmentManager(), "confirm_logout_dialog");
    }

    @Override
    public void onConfirmLogout() {
        Intent intent = new Intent(Setting.this, Confirm_LogOut.class);
        startActivity(intent);
    }

    @Override
    public void onCancelLogout() {
    }
}
