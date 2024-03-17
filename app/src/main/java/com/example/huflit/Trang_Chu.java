package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.PixelCopy;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.TrangChuAdapter;
import com.example.huflit.api.APILayTruyenVe;
import com.example.huflit.interfaces.LayTruyenVe;
import com.example.huflit.item.StoryFull;
import com.example.huflit.item.itemTrangchu;
import com.example.huflit.object.Truyen_tranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.JarException;

public class Trang_Chu extends AppCompatActivity   {

    LinearLayout TrangChu, Search, TheLoai, Menu;

    RecyclerView grvhoanthanh, grvdexuat, grvmoinhat, grvxemnhieu;

    TrangChuAdapter hoanthanhAdapter, moinhatAdapter, dexuatAdapter, xemnhieuAdapter;
    ArrayList<itemTrangchu> hoanthanhList, moinhatList, dexuatList, xemnhieuList;
    RequestQueue queue;

    String urlgetitem="https://huf-android.000webhostapp.com/getItem.php";

    String urlgetitem="https://huf-android.000webhostapp.com/layTruyen.php" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        TrangChu = findViewById(R.id.TrangChu);
        Search = findViewById(R.id.Search);
        TheLoai = findViewById(R.id.TheLoai);
        Menu = findViewById(R.id.Menu);
        
        hoanthanhList=new ArrayList<>();
        queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, urlgetitem,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray array=new JSONArray(response);
                            for(int i=0;i<array.length();i++){
                            JSONObject o=array.getJSONObject(i);
                                String tenTruyen,linkAnh;
                                 int id;
                                id=o.getInt("ID");
                                tenTruyen = o.getString("tenTruyen");
                                linkAnh = o.getString("linkAnh");
                                itemTrangchu item=new itemTrangchu(id,tenTruyen,linkAnh);
                                hoanthanhList.add(item);
                                hoanthanhAdapter.notifyDataSetChanged();
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

        // Khởi tạo RecyclerView và adapter cho mục hoàn thành
        initHoanthanh();
        anhxaHoanThanh();
        setupHoanThanh();

        // Khởi tạo RecyclerView và adapter cho mục mới nhất
        initmoinhat();
        anhxamoinhat();
        setupmoinhat();

        // Khởi tạo RecyclerView và adapter cho mục đề xuất
        initdexuat();
        anhxadexuat();
        setupdexuat();

        // Khởi tạo RecyclerView và adapter cho mục xem nhiều
        initxemnhieu();
        anhxaxemnhieu();
        setupxemnhieu();

        // Xử lý sự kiện onClick
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

        TheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, The_loai.class);
                startActivity(intent);
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trang_Chu.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    // Khởi tạo RecyclerView và adapter cho mục hoàn thành
    public void initHoanthanh() {
        hoanthanhList = new ArrayList<>();
        hoanthanhAdapter = new TrangChuAdapter(this, hoanthanhList);
    }

    public void anhxaHoanThanh() {
        grvhoanthanh = findViewById(R.id.viewhoanthanh);
    }

    public void setupHoanThanh() {
        grvhoanthanh.setAdapter(hoanthanhAdapter);
    }

    // Khởi tạo RecyclerView và adapter cho mục mới nhất
    public void initmoinhat() {
        moinhatList = new ArrayList<>();
        moinhatAdapter = new TrangChuAdapter(this, moinhatList);
    }

    public void anhxamoinhat() {
        grvmoinhat = findViewById(R.id.viewmoinhat);
    }

    public void setupmoinhat() {
        grvmoinhat.setAdapter(moinhatAdapter);
    }

    // Khởi tạo RecyclerView và adapter cho mục đề xuất
    public void initdexuat() {
        dexuatList = new ArrayList<>();
        dexuatAdapter = new TrangChuAdapter(this, dexuatList);
    }

    public void anhxadexuat() {
        grvdexuat = findViewById(R.id.viewdexuat);
    }

    public void setupdexuat() {
        grvdexuat.setAdapter(dexuatAdapter);
    }

    // Khởi tạo RecyclerView và adapter cho mục xem nhiều
    public void initxemnhieu() {
        xemnhieuList = new ArrayList<>();
        xemnhieuAdapter = new TrangChuAdapter(this, xemnhieuList);
    }

    public void anhxaxemnhieu() {
        grvxemnhieu = findViewById(R.id.viewxemnhieu);
    }

    public void setupxemnhieu() {
        grvxemnhieu.setAdapter(xemnhieuAdapter);
    }


}