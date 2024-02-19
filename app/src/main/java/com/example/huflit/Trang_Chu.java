package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Trang_Chu extends AppCompatActivity {
    ImageButton trangchu, timkiem, dangbai, menu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        trangchu=findViewById(R.id.buttomtrangchu);
        timkiem=findViewById(R.id.buttomtim);
        dangbai=findViewById(R.id.butomdangbai);
        menu=findViewById(R.id.buttommenu);


        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Trang_Chu.class);
                startActivity(intent);
            }
        });


        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Search.class);
                startActivity(intent);
            }
        });

        dangbai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Trang_Chu.this, Diolog_dang_ki_truyen.class);
                 startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Trang_Chu.this, Menu.class);
                startActivity(intent);
            }


        });




    }




}
