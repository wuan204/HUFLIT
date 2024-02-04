package com.example.huflit;

import static com.example.huflit.R.id.btnOK;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Trang_Chu extends AppCompatActivity {
     Button btnOK,btnOk2,btviewstr;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        btnOK = findViewById(R.id.btnOK);
        btnOk2= findViewById(R.id.btnOk2);
        btviewstr=findViewById(R.id.btviewstory);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trang_Chu.this, Menu.class);
                startActivity(i);
            }
        });
        btnOk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Trang_Chu.this, Content.class);
                startActivity(i);
            }
        });
        btviewstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Trang_Chu.this, ViewStory.class);
                startActivity(i);
            }
        });
    }
}