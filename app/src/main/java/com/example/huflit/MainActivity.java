package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.net.URL;
import java.sql.CallableStatement;

public class MainActivity extends AppCompatActivity {
    //khai bao cac bien o day
    EditText edtName, edtPassword;
    Button btnLogin,btnGoogle;
    TextView txtForgot,txtRegister;
    CheckBox cbRemember;
    ImageView imgEye;
    SharedPreferences preferences;
    private String firstPassword = "";

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
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entername = edtName.getText().toString();
                String enterpassword = edtPassword.getText().toString();

                    startActivity(new Intent(MainActivity.this, Trang_Chu.class));
                    if(firstPassword.isEmpty()){
                        firstPassword = enterpassword;
                    }
                    else {
                        if(enterpassword.equals(firstPassword)){

                        }
                        else{
                            Toast.makeText(MainActivity.this,"Sai mật khẩu", Toast.LENGTH_SHORT).show();
                            edtPassword.getText().clear();
                            firstPassword= " ";
                        }
                    }
            }

        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openGoogleSignIn();
                Intent intent=new Intent(MainActivity.this,Trang_Chu.class);
                startActivity(intent);
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
            Toast.makeText(MainActivity.this, "khong tim thay  ung sung", Toast.LENGTH_LONG).show();
        }
    }
   /* private  boolean isLogin (String entername, String enterpassword){
        String saveName= preferences().getString("Name");
        String savePassword =preferences().getString("Password");

        return entername.equals(saveName) && enterpassword.equals(savePassword);
    }*/

}