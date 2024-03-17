package com.example.huflit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Register extends AppCompatActivity {

    EditText edtName2, Password1, edtEmail, Password2;
    Button btnsignin, btnback;
    String Url = "https://huf-android.000webhostapp.com/dangky.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        anhxa();


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                xulidangki();
            }
        });
    }

    public  void  xulidangki()
    {
        String name = edtName2.getText().toString();
        String pass = Password1.getText().toString().trim();
        String pass2 = Password2.getText().toString().trim();
        String email = edtEmail.getText().toString();

        //cac rang buoc
        if (name.isEmpty() || pass.isEmpty() || pass2.isEmpty() || email.isEmpty()) {
            nhacnhonhap();
        }
        else {

            if(pass.equals(pass2))
            {
                if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {

                    addUser();
                }

                else
                {
                    nhacnhoemail();
                }
            }

            else
            {
                nhacnhopass();
            }

        }
    }


    //lenh xu li add user
    private void addUser() {
        RequestQueue requestQueue = Volley.newRequestQueue(Register.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            Toast.makeText(Register.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this,"đăng ký thất bại",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("tenuser", edtName2.getText().toString().trim());
                params.put("password", Password1.getText().toString().trim());
                params.put("email", edtEmail.getText().toString().trim());

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    //hamthong bao

    private void nhacnhonhap() {
        Toast.makeText(Register.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();
    }
    private  void  nhacnhopass()
    {
        Toast.makeText(Register.this,"mật khâur xác nhận không đúng",Toast.LENGTH_SHORT).show();
    }

    private void nhacnhoemail()
    {
        Toast.makeText(Register.this,"email không hợp lệ",Toast.LENGTH_SHORT).show();
    }


    //anhxa

    private void anhxa()
    {

        edtName2 = findViewById(R.id.edtName2);
        Password1 = findViewById(R.id.edtPassword2);
        edtEmail = findViewById(R.id.edtEmail);
        btnsignin = findViewById(R.id.btnSignin);

        Password2 = findViewById(R.id.comfirmPass);
    }
}