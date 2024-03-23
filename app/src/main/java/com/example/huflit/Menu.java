package com.example.huflit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    Button btnTaiKhoan;
    ImageView imgSetting;
    TextView txtTK;
    private boolean isLoggedIn = false;
    LinearLayout History,Heart,Down,List,Star,GiaoDien,Background,ThongTin,YKien,TrangChu,Search,TheLoai,Menu,Truyen_cua_toi,ThemTruyen,LoginSignIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



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
        LoginSignIn=findViewById(R.id.LoginSignIn);
        txtTK = findViewById(R.id.txtTK);


        TextView txtTK = findViewById(R.id.txtTK);
        String username = getIntent().getStringExtra("username");

        if(username != null && !username.isEmpty()) {
            // Nếu đã đăng nhập, hiển thị tên người dùng
            txtTK.setText(username);

            // Gắn sự kiện lắng nghe để chuyển hướng đến trang profile khi người dùng click vào tên
            txtTK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Thực hiện chuyển hướng đến trang profile
                    // Ví dụ:
                    Intent intent = new Intent(Menu.this, Profile_User.class);
                    startActivity(intent);
                }
            });
        } else {
            // Nếu chưa đăng nhập, hiển thị "Đăng kí/ Đăng nhập"
            txtTK.setText("Đăng kí/ Đăng nhập");
        }



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
                Intent i =new Intent(Menu.this, create_story.class);
                startActivity(i);
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
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Nhan_xet_cua_toi.class);
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

        LoginSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra trạng thái đăng nhập
                if (isLoggedIn) {
                    // Nếu đã đăng nhập, chuyển sang Activity Profile
                    Intent i = new Intent(Menu.this, Profile_User.class);
                    startActivity(i);
                } else {
                    // Nếu chưa đăng nhập, chuyển sang Activity đăng nhập
                    Intent i = new Intent(Menu.this, Login.class);
                    startActivity(i);
                }
            }
        });


    }
}