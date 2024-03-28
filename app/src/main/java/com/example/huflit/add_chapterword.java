package com.example.huflit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class add_chapterword extends AppCompatActivity {
    EditText title,content;
    String [] item;
    ImageView add;
    Spinner showspiner;
    private  int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chapterword);
        title = findViewById(R.id.edtTitleChapter);
        content = findViewById(R.id.contenttext);
        add = findViewById(R.id.btnfinal);
        showspiner=findViewById(R.id.spnShow);
        item = new String[]{"Mọi người", "Chỉ mình tôi"};
        ArrayAdapter<String> adt2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item);
        adt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        showspiner.setAdapter(adt2);
        Intent i=getIntent();
        if(i!=null){id=i.getIntExtra("id",0);}
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty() || content.getText().toString().isEmpty()) {
                    Toast.makeText(add_chapterword.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    addchap("https://huf-android.000webhostapp.com/add_chapword.php");
                }
            }
        });
    }
    private void addchap(String URL) {
        RequestQueue requestQueue = Volley.newRequestQueue(add_chapterword.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("zzzz", "onResponse: "+response);
                        if (response.trim().equals("success")) {

                            Toast.makeText(add_chapterword.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(add_chapterword.this, mycomic.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(add_chapterword.this,"đăng ký thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(add_chapterword.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("ChtName", title.getText().toString());
                params.put("Content", content.getText().toString());
                params.put("ChtShow",showspiner.getSelectedItem().toString());
                params.put("StrID",String.valueOf(id));
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }
}