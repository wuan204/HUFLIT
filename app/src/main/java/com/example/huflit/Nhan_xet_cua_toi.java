package com.example.huflit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Nhan_xet_cua_toi extends AppCompatActivity {
    ImageView imgBack;
     Button btnDanhGia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhan_xet_cua_toi);

        imgBack = findViewById(R.id.imgBack);
        btnDanhGia = findViewById(R.id.btnDanhGia);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
