package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.huflit.truyen_tranh.Truyen_tranh;

import java.util.ArrayList;

public class Trang_Chu extends AppCompatActivity {
    LinearLayout TrangChu, Search, TheLoai, Menu;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        TrangChu=findViewById(R.id.TrangChu);
        Search=findViewById(R.id.Search);
        TheLoai=findViewById(R.id.TheLoai);
        Menu=findViewById(R.id.Menu);


        // onclick
        TrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Trang_Chu.class);
                startActivity(intent);
            }
        });


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Search.class);
                startActivity(intent);
            }
        });



        TheLoai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(Trang_Chu.this, The_loai.class);
                 startActivity(intent);
            }
        });

        Menu.setOnClickListener(new View.OnClickListener()
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
