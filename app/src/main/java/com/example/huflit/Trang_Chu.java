package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Trang_Chu extends AppCompatActivity {
    Button btnOK, btnOk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        btnOK = findViewById(R.id.btnOK);
        btnOk2 = findViewById(R.id.btnOk2);

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
    }
    @Override
    public void onBackPressed() {
        // Chuyển về màn hình chính của điện thoại khi nhấn nút Back ở trang này
        super.onBackPressed();
        finishAffinity();
    }

}
