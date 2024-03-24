package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Truyen_da_xem extends AppCompatActivity {
Button imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_da_xem);

        anhxa();
        xuli();

    }

    private void xuli() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressLint("WrongViewCast")
    private void anhxa() {
        imgBack = findViewById(R.id.imgBack);
    }
}