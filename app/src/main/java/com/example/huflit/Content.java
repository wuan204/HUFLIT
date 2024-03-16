package com.example.huflit;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.NoiDungAdapter;
import com.example.huflit.item.StoryFull;
import com.example.huflit.object.NoiDung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Content extends AppCompatActivity {
    ImageView imgBack, imgMenu2;
    TextView txtTenChapter, txtConTent;

    RequestQueue requestQueue;
    String StrID;
    NoiDungAdapter noiDungAdapter;
ArrayList<NoiDung> arrayList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        anhXa();
        setClick();

        arrayList=new ArrayList<>();
        Intent i=getIntent();
        if(i!=null){
         String tenchuong=i.getStringExtra("name");
            String noidung=i.getStringExtra("content");
            txtTenChapter.setText(tenchuong);
            txtConTent.setText(noidung);
        }
//        requestQueue= Volley.newRequestQueue(this);
//        String url = "https://huf-android.000webhostapp.com/noiDung.php" ;
//        StringRequest request = new StringRequest(Request.Method.GET, url, // Truyền URL vào constructor
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONArray array = new JSONArray(response);
//                            if (array.length() > 0) {
//                                JSONObject o = array.getJSONObject(0);
//                                String chtName = o.getString("ChtName");
//                                String content = o.getString("Content");
//                                // Đặt dữ liệu đã lấy được vào các TextViews
//                                txtTenChapter.setText(chtName);
//                                txtConTent.setText(content);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Xử lý lỗi
//                    }
//                });
//        requestQueue.add(request);
////

        imgMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    private void setClick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        imgBack = findViewById(R.id.imgBack);
        imgMenu2 = findViewById(R.id.imgMenu2);
        txtTenChapter = findViewById(R.id.txtTenChapter);
        txtConTent = findViewById(R.id.txtConTent);
    }

}
