package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huflit.database.Database;

import java.net.URL;
import java.sql.CallableStatement;

public class Login extends AppCompatActivity {
    //khai bao cac bien o day
    EditText edtName, edtPassword;
    Button btnLogin,btnGoogle;
    TextView txtForgot,txtRegister;
    CheckBox cbRemember;
    ImageView imgEye;
    SharedPreferences preferences;
    private String firstPassword = "";
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //khai bao anh xa o day
        edtName= findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.btnGoogle);
        txtForgot= findViewById(R.id.txtForgot);
        txtRegister= findViewById(R.id.txtRegister);
        cbRemember= findViewById(R.id.cbRemember);
        imgEye= findViewById(R.id.imgEye);
        preferences = getSharedPreferences("user_data", MODE_PRIVATE);

        database = new Database(this);

        // xu li giao dien nguoi dung

        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        imgEye.setImageResource(R.drawable.eye);
        imgEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }

            private void togglePasswordVisibility() {
                if(edtPassword.getTransformationMethod()== PasswordTransformationMethod.getInstance()){
                    edtPassword.setTransformationMethod(null);
                    imgEye.setImageResource(R.drawable.eye);
                }else{
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imgEye.setImageResource(R.drawable.eye);}
            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String password = edtPassword.getText().toString();
                Cursor cursor = database.getdata();


                while(cursor.moveToNext()){
                    String dataTenTaiKhoan = cursor.getString(1);
                    String dataMatKhau = cursor.getString(2);
                    if(dataTenTaiKhoan.equals(name)  && dataMatKhau.equals(password)){
                        int idd = cursor.getInt(0);
                        int phanq = cursor.getInt(4);
                        String email = cursor.getString(3);
                        String tentk = cursor.getString(1);

                        Intent i = new Intent(Login.this, Trang_Chu.class);
                        i.putExtra("idd",idd);
                        i.putExtra("email",email);
                        i.putExtra("tentk",tentk);
                        i.putExtra("phanq",phanq);

                        startActivity(i);


                    }
                }

            }

        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleSignIn();

            }
        });

    }
    private void PrintToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
    public void openGoogleSignIn(){
        String googleSignIn = "http://accounts.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSignIn));
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
        else {
            Toast.makeText(Login.this, "Không tìm thấy ứng dụng", Toast.LENGTH_LONG).show();
        }
    }

}