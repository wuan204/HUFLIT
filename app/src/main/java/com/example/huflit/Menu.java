package com.example.huflit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Menu extends AppCompatActivity {
    TextView txtTK,txtLogOut;
    private boolean isLoggedIn = false;
    int userid;
    int authorid;
    private SharedPreferences sharedPreferences;
    LinearLayout History,List,Star,TrangChu,Search,TheLoai,Menu,Truyen_cua_toi,ThemTruyen,LoginSignIn,Admintrator;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //btnTaiKhoan= findViewById(R.id.btnTaiKhoan);
        History = findViewById(R.id.History);

        Star= findViewById(R.id.Star);
        TrangChu = findViewById(R.id.TrangChu);
        Search = findViewById(R.id.Search);
        TheLoai =findViewById(R.id.TheLoai);
        Menu = findViewById(R.id.Menu);
        Truyen_cua_toi= findViewById(R.id.Truyen_cua_toi);
        ThemTruyen = findViewById(R.id.ThemTruyen);
        //imgSetting = findViewById(R.id.imgSetting);
        LoginSignIn=findViewById(R.id.LoginSignIn);
        txtTK = findViewById(R.id.txtTK);
       txtLogOut = findViewById(R.id.txtLogOut);
       Admintrator=findViewById(R.id.layoutAdmintrator);


        // TextView để hiển thị tên người dùng hoặc nút Đăng ký/Đăng nhập
        TextView txtTK = findViewById(R.id.txtTK);



        // Trích xuất tên người dùng từ SharedPreferences
        sharedPreferences= getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        int roleid =sharedPreferences.getInt("roleid",0);
        Boolean check=sharedPreferences.getBoolean("isLoggedIn",false);
        userid  =sharedPreferences.getInt("userid",0);
        if(roleid>1){  getalias();};

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

        txtLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogOutUser();
            }
        });
        ThemTruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){ Intent i;
                    if(roleid>1){ i=new Intent(Menu.this, create_story.class);
                    }
                    else {i=new Intent(Menu.this, Register_Author.class);}
                    startActivity(i);}
               else Toast.makeText(com.example.huflit.Menu.this,"Bạn cần phải đăng nhập trước",Toast.LENGTH_LONG).show();
            }
        });
        Truyen_cua_toi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){ Intent i;
                    if(roleid>1){ i=new Intent(Menu.this, Truyen_da_dang.class);
                    }
                    else {i=new Intent(Menu.this, Register_Author.class);}
                    startActivity(i);}
                else Toast.makeText(com.example.huflit.Menu.this,"Bạn cần phải đăng nhập trước",Toast.LENGTH_LONG).show();
            }
        });
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Truyen_da_xem.class);
                startActivity(i);
            }
        });

      ;
        Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Nhan_xet_cua_toi.class);
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

        Admintrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
                int roleid = sharedPreferences.getInt("roleid", 0);

                xulichuyenAdmin(roleid);

            }
        });






    }
    private void xulichuyenAdmin(int role)
    {
        if(role>2)
        {
            Intent intent=new Intent(Menu.this,Administrator.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(Menu.this," chỉ cho phép tài khoản admin truy cập",Toast.LENGTH_LONG).show();
        }
    }

    private void getalias() {
         String  url="https://huf-android.000webhostapp.com/getAlias.php?UserID="+userid;
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array=new JSONArray(response);
                            for(int i=0;i<array.length();i++)
                            {
                                JSONObject o= array.getJSONObject(i);
                                authorid=o.getInt("AuthorID");
                                Log.d("Notthing", "onResponse: "+authorid);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putInt("authorid",authorid);
                                editor.apply();
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(request);
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



}