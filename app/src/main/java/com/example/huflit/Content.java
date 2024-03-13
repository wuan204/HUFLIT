package com.example.huflit;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class Content extends AppCompatActivity {
    ImageView imgBack, imgMenu2;
    TextView txtTenChapter, txtConTent;

    private  RequestQueue requestQueue;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        anhXa();
        setClick();
        requestQueue = Volley.newRequestQueue(this);

        // Nhận dữ liệu từ Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String content = extras.getString("conTent");
            String chapter = extras.getString("tenChap");
            txtConTent.setText(content);
            txtTenChapter.setText(chapter);
        }

    }

    private void setClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        imgBack = findViewById(R.id.imgBack);
        imgMenu2 = findViewById(R.id.imgMenu2);
        txtTenChapter = findViewById(R.id.txtTenChapter);
        txtConTent = findViewById(R.id.txtConTent);
    }

}
