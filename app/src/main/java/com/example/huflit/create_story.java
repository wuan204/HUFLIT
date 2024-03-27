package com.example.huflit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class create_story extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ImageButton mbtnselect;
    ImageView mbtnCreateComic,mbtbackComic;
    Button mbtnSelectCate;

    TextView mtxtCategory;
    EditText medtnamestory,medtdescripts;
    RadioButton comic;
    RadioButton word;
    private Uri selectedImageUri;
    int authorid;
    String URL="https://huf-android.000webhostapp.com/themTruyen.php";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);
        // anh xa 11
        mbtnselect=(ImageButton) findViewById(R.id.btselectimg);
        mbtnCreateComic=(ImageView) findViewById(R.id.btnCreateComic);
        mbtbackComic=(ImageView) findViewById(R.id.btbackComic);
        medtdescripts=(EditText) findViewById(R.id.edtDescript) ;
        medtnamestory=(EditText) findViewById(R.id.txtnamestory);
        comic=findViewById(R.id.rdocomic);
        word=findViewById(R.id.rdoword);
        //
        SharedPreferences sharedPreferences = getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
        authorid  =sharedPreferences.getInt("authorid",0);
        //
        mbtnselect.setOnClickListener(v -> {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
        });

        mbtnCreateComic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medtnamestory.getText().toString().isEmpty() ||
                        medtdescripts.getText().toString().isEmpty() ||
                        selectedImageUri == null) {
                    Toast.makeText(create_story.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else
                {
                    addtruyen();
                }
            }
        });

    }
    private String type(){
        if (comic.isChecked()) return "Truyện tranh";
        else return "Truyện chữ";
    }
    private void addtruyen() {
        RequestQueue requestQueue = Volley.newRequestQueue(create_story.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.trim().equals("success")) {
                            Toast.makeText(create_story.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(create_story.this, Truyen_da_dang.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(create_story.this,"đăng ký thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(create_story.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("StrName", medtnamestory.getText().toString());
                params.put("StrImage", medtdescripts.getText().toString());
                params.put("Descrip", selectedImageUri.toString());
                // Lấy ngày hiện tại và định dạng thành chuỗi
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = dateFormat.format(new Date());
                params.put("CreateDate", currentDate);
                params.put("LastUpdatedDate",currentDate);
                params.put("AuthorID", String.valueOf(authorid));
                params.put("StrType",type());

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();

            mbtnselect.setImageURI(selectedImageUri);
        }
    }
}