package com.example.huflit;

import androidx.annotation.NonNull;
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


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() | !validatePassword()){

                }
                else{
                    CheckUser();
                }
                Intent i = new Intent(Login.this, Menu.class);
                startActivity(i);
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleSignIn();

            }
        });

    }
    public Boolean validateUsername(){
        String val = edtName.getText().toString();
        if(val.isEmpty()){
            edtName.setError("UserName cannot be empty");
            return false;

        }else {
            edtName.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = edtPassword.getText().toString();
        if(val.isEmpty()){
            edtPassword.setError("Password cannot be empty");
            return false;

        }else {
            edtPassword.setError(null);
            return true;
        }
    }

        public void CheckUser() {
            String userUserName = edtName.getText().toString().trim();
            String userPassword = edtPassword.getText().toString().trim();

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
            Query checkUserDatabase = reference.orderByChild("username").equalTo(userUserName);
            checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        edtName.setError(null);

                        // Loop through the dataSnapshot to find the correct user
                        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                            String passwordFromDB = childSnapshot.child("password").getValue(String.class);

                            // Compare passwordFromDB with userPassword
                            if (passwordFromDB != null && passwordFromDB.equals(userPassword)) {
                                // Passwords match, proceed to next activity
                                Intent intent = new Intent(Login.this, Trang_Chu.class);
                                startActivity(intent);
                                return;
                            }
                        }
                        // Password doesn't match
                        edtPassword.setError("Invalid Credentials");
                        edtPassword.requestFocus();
                    } else {
                        // User does not exist
                        edtName.setError("User does not exist");
                        edtName.requestFocus();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle cancellation
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