package com.example.huflit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Nhan_xet_cua_toi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhan_xet_cua_toi);


        Button buttonViet = findViewById(R.id.btnvietnhanxet);
        buttonViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nhan_xet_cua_toi.this, Y_kien.class);
                startActivity(intent);
            }
        });

        Button buttonback =findViewById((R.id.btnvietnhanxet));

        buttonViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Nhan_xet_cua_toi.this, android.R.menu.class);
                startActivity(intent);
            }
        });


    }
}
