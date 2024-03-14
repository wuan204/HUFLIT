package com.example.huflit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ThemDmuc extends AppCompatActivity {
    EditText edtname;
    ImageView btnadd;
    String url="https://huf-android.000webhostapp.com/Category.php";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_dmuc);
        edtname=findViewById(R.id.edtaddname);
        btnadd=findViewById(R.id.btnaddnewcate);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addcate(url);
            edtname.setText("");
            }
        });
    }
    private void addcate(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            Toast.makeText(ThemDmuc.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ThemDmuc.this, QLyDanhMuc.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(ThemDmuc.this,"đăng ký thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThemDmuc.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                 params.put("namecate",edtname.getText().toString().trim());
                Log.d("nhan ", "getParams: "+params);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}