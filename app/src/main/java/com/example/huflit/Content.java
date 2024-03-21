package com.example.huflit;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.ContentImgAdapter;
import com.example.huflit.adapter.NoiDungAdapter;
import com.example.huflit.item.StoryFull;
import com.example.huflit.item.itemIMG;
import com.example.huflit.object.NoiDung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Content extends AppCompatActivity {
    ImageView imgBack, imgMenu2;
    TextView txtTenChapter, txtConTent;

    RequestQueue requestQueue;
    String StrID;
    int id;
    LinearLayout titleLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        anhXa();
        setClick();
        titleLayout = findViewById(R.id.titlelayout);
        findViewById(R.id.layoutparent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (titleLayout.getVisibility() == View.VISIBLE) {
                    titleLayout.setVisibility(View.GONE);
                } else {
                    titleLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        //
        Intent i=getIntent();
        if(i!=null)
        {id=i.getIntExtra("idchap",0);}
        getData();
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
    private  void getData(){

        requestQueue= Volley.newRequestQueue(this);
        String url = "https://huf-android.000webhostapp.com/noiDung.php?ChtID="+id ;
        StringRequest request = new StringRequest(Request.Method.GET, url, // Truyền URL vào constructor
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            if (array.length() > 0) {
                                JSONObject o = array.getJSONObject(0);
                                String chtName = o.getString("ChtName");
                                String content = o.getString("Content");
                                txtTenChapter.setText(chtName);
                                txtConTent.setText(content);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Xử lý lỗi
                    }
                });
        requestQueue.add(request);
    }
}
