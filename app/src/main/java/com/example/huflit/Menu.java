package com.example.huflit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.huflit.adapter.TruyenTranhAdapter;
import com.example.huflit.truyen_tranh.Truyen_tranh;

public class Menu extends AppCompatActivity {

    Button btnTaiKhoan,btnXu,btnDoiXu;
    ImageView imgSetting;
    LinearLayout History,Heart,Down,List,Star,GiaoDien,Background,ThongTin,YKien,TrangChu,Search,TheLoai,Menu,Truyen_cua_toi,ThemTruyen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnDoiXu = findViewById(R.id.btnDoiXu);
        btnXu = findViewById(R.id.btnXu);
        btnTaiKhoan= findViewById(R.id.btnTaiKhoan);
        History = findViewById(R.id.History);
        Heart = findViewById(R.id.Heart);
        Down = findViewById(R.id.Down);
        List = findViewById(R.id.List);
        Star= findViewById(R.id.Star);
        GiaoDien= findViewById(R.id.GiaoDien);
        Background= findViewById(R.id.Background);
        ThongTin=findViewById(R.id.ThongTin);
        YKien = findViewById(R.id.YKien);
        TrangChu = findViewById(R.id.TrangChu);
        Search = findViewById(R.id.Search);
        TheLoai =findViewById(R.id.TheLoai);
        Menu = findViewById(R.id.Menu);
        Truyen_cua_toi= findViewById(R.id.Truyen_cua_toi);
        ThemTruyen = findViewById(R.id.ThemTruyen);
        imgSetting = findViewById(R.id.imgSetting);


        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Setting.class);
                startActivity(i);
            }
        });
        ThemTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
        Truyen_cua_toi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Truyen_da_dang.class);
                startActivity(i);
            }
        });
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Truyen_da_xem.class);
                startActivity(i);
            }
        });
        Heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Truyen_da_thich.class);
                startActivity(i);
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Truyen_da_tai.class);
                startActivity(i);
            }
        });
        List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, My_Collection.class);
                startActivity(i);
            }
        });
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Nhan_xet_cua_toi.class);
                startActivity(i);
            }
        });
        GiaoDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Setting_Interface.class);
                startActivity(i);
            }
        });
        Background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Setting_Background.class);
                startActivity(i);
            }
        });
        ThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Thong_tin.class);
                startActivity(i);
            }
        });
        YKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Y_kien.class);
                startActivity(i);
            }
        });
        TrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Menu.this, Trang_Chu.class);
                startActivity(i);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Search.class);
                startActivity(i);
            }
        });
        TheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Menu.this, The_loai.class);
                startActivity(i);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,Menu.class);
                startActivity(i);
            }
        });
    }
    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_diolog_them_truyen, null);
        builder.setView(dialogView);
        builder.setPositiveButton(null, null);
        builder.setNegativeButton(null, null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button btnTranh = dialogView.findViewById(R.id.btnTranh);
        Button btnChu = dialogView.findViewById(R.id.btnChu);

        btnTranh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranh = new Intent(Menu.this, Dang_bai_truyen_tranh.class);
                startActivity(intentTranh);
                alertDialog.dismiss();
            }
        });

        btnChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChu = new Intent(Menu.this, Dang_bai_truyen_chu.class);
                startActivity(intentChu);
                alertDialog.dismiss();
            }
        });
    }
}