package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Diolog_Them_Truyen extends AppCompatActivity {
    Button btnChu, btnTranh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diolog_them_truyen);

        btnChu = findViewById(R.id.btnChu);
        btnTranh = findViewById(R.id.btnTranh);

        btnChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Diolog_Them_Truyen.this, Dang_bai_truyen_chu.class);
                startActivity(i);
            }
        });
        btnTranh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Diolog_Them_Truyen.this, Dang_bai_truyen_tranh.class);
                startActivity(i);
            }
        });
    }
}