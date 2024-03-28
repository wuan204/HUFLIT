package com.example.huflit;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Content extends AppCompatActivity {
    ImageView imgBack, imgMenu2;
    TextView txtTenChapter, txtConTent;

    RequestQueue requestQueue;
    String StrID;
    Button btnPrevous,btnNext;
    int id;
    LinearLayout titleLayout,parentlayout;

    int currentChapterId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        anhXa();
        setClick();
      

        Intent i = getIntent();
        if (i != null) {
            currentChapterId = i.getIntExtra("idchap", 0);
            getData(); // Load data for the initial chapter
        }
        // Set click listeners for chapter navigation buttons
        btnPrevous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to the previous chapter if not the first chapter
                if (currentChapterId > 1) {
                    currentChapterId--;
                    getData(); // Load data for the new chapter
                } else {
                    // Notify user that it's the first chapter
                    Toast.makeText(Content.this, "Đây là chương đầu tiên", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to the next chapter
                currentChapterId++;
                getData(); // Load data for the new chapter
            }
        });


        parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (titleLayout.getVisibility() == View.VISIBLE) {
                    titleLayout.setVisibility(View.GONE);
                } else {
                    titleLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        txtConTent.setOnClickListener(new View.OnClickListener() {
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
        btnNext = findViewById(R.id.btnNext);
        btnPrevous = findViewById(R.id.btnPrevous);
        titleLayout = findViewById(R.id.titlelayout);
        parentlayout=findViewById(R.id.layoutparent);
    }
    private  void getData(){

        requestQueue= Volley.newRequestQueue(this);
        String url = "https://huf-android.000webhostapp.com/noiDung.php?ChtID="+currentChapterId ;
        StringRequest request = new StringRequest(Request.Method.GET, url,
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
