package com.example.huflit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    Button btnTaiKhoan;
    ImageView imgSetting,imgPlus;

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
        imgPlus = findViewById(R.id.imgPlus);

        // TextView để hiển thị tên người dùng hoặc nút Đăng ký/Đăng nhập
        TextView txtTK = findViewById(R.id.txtTK);

        // Gọi phương thức updateUI() để cập nhật giao diện người dùng
       // updateUI();

        // Trích xuất tên người dùng từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        // Kiểm tra xem có tên người dùng từ SharedPreferences hay không
        if (!username.isEmpty()) {
            // Nếu đã đăng nhập, hiển thị tên người dùng và gắn sự kiện click để chuyển hướng đến trang Profile
            txtTK.setText(username);
            txtTK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chuyển hướng đến trang Profile
                    Intent intent = new Intent(Menu.this, Profile_User.class);
                    startActivity(intent);
                }
            });
        } else {
            // Nếu chưa đăng nhập, hiển thị "Đăng ký/Đăng nhập"
            txtTK.setText("Đăng ký/Đăng nhập");
        }
        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển hướng đến trang Profile
                Intent intent = new Intent(Menu.this, Profile_User.class);
                startActivity(intent);
            }
        });



        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogOutUser();
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
                Intent i = new Intent(Menu.this, NguoiDungQly.class);
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

    private void LogOutUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("tk_mk_login",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(Menu.this, Menu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    // Phương thức lưu tên người dùng vào SharedPreferences khi đăng nhập thành công
    private void saveUsernameToSharedPreferences(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username); // lưu tên người dùng
        editor.apply();
    } // Phương thức xóa thông tin về tên người dùng từ SharedPreferences khi đăng xuất
    private void clearUsernameFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username"); // xóa tên người dùng
        editor.apply();
    }


//    private void updateUI() {
//        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
//        String username = sharedPreferences.getString("username", "");
//        if (!username.isEmpty()) {
//            // Nếu đã đăng nhập, hiển thị tên người dùng và gắn sự kiện click để chuyển hướng đến trang Profile
//            txtTK.setText(username);
//            txtTK.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Chuyển hướng đến trang Profile
//                    Intent intent = new Intent(Menu.this, Profile_User.class);
//                    startActivity(intent);
//                }
//            });
//            isLoggedIn = true; // Cập nhật trạng thái đăng nhập
//        } else {
//            // Nếu chưa đăng nhập, hiển thị "Đăng ký/Đăng nhập"
//            txtTK.setText("Đăng ký/Đăng nhập");
//            // Gắn sự kiện click để chuyển hướng đến trang đăng nhập
//            txtTK.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Chuyển hướng đến trang đăng nhập
//                    Intent intent = new Intent(Menu.this, Login.class);
//                    startActivity(intent);
//                }
//            });
//            isLoggedIn = false; // Cập nhật trạng thái đăng nhập
//        }
//    }


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
                Intent intentTranh = new Intent(Menu.this, create_story.class);
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