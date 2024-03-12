package com.example.huflit;

import android.annotation.SuppressLint;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.NoiDungAdapter;
import com.example.huflit.object.Noi_Dung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Content extends AppCompatActivity {
    ImageView imgBack, imgMenu2;
    TextView txtTenChapter, txtConTent;
    ArrayList<Noi_Dung> noiDungArrayList;
    NoiDungAdapter adapter;

    String urlGetData = "https://huf-android.000webhostapp.com/noiDung.php";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        anhXa();
        setClick();
        noiDungArrayList = new ArrayList<>();
        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    if (noiDungArrayList == null) {
                        noiDungArrayList = new ArrayList<>();
                    }

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject object = response.getJSONObject(i);
                            noiDungArrayList.add(new Noi_Dung(
                                    object.getString("TenChap"),
                                    object.getString("NoiDung")
                            ));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    // Tạo adapter nếu chưa có
                    if (adapter == null) {
                        adapter = new NoiDungAdapter(this, noiDungArrayList, R.layout.activity_content);
                    }



                },
                error -> Toast.makeText(Content.this, "Lỗi", Toast.LENGTH_SHORT).show()
        );

        requestQueue.add(jsonArrayRequest);
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
