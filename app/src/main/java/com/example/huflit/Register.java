package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.huflit.database.Database;
import com.example.huflit.model.TaiKhoan;


public class Register extends AppCompatActivity {

//khai bao cac bien o day

    EditText edtName2, edtPassword2,edtEmail;
    Button btnSignin,back;

    Database database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = new Database(this);

        anhxa();

        //xu li giao dien nguoi dung
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName2.getText().toString();
                String password = edtPassword2.getText().toString();
                String email = edtEmail.getText().toString();

                TaiKhoan taiKhoan1 = CreateTaiKhoan();
                if(name.equals("") || password.equals("") || email.equals("")){
                    Log.e("Thông báo: " ,"Chưa nhập đủ thông tin");

                }
                else {
                    database.AddTaiKhoan(taiKhoan1);
                    Toast.makeText(Register.this,"Đăng kí thành công",Toast.LENGTH_LONG).show();
                }
                
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void anhxa() {
        edtName2 = findViewById(R.id.edtName2);
        edtPassword2= findViewById(R.id.edtPassword2);
        edtEmail= findViewById(R.id.edtEmail);
        btnSignin = findViewById(R.id.btnSignin);
        back = findViewById(R.id.back);
    }


    //phương thức tạo tài khoan
    private TaiKhoan CreateTaiKhoan(){
        String taikhoan = edtName2.getText().toString();
        String matkhau = edtPassword2.getText().toString();

        String email = edtEmail.getText().toString();
        int phanquyen = 1;
        TaiKhoan tk =  new TaiKhoan(taikhoan,matkhau,phanquyen,email);
        return tk;
    }
}