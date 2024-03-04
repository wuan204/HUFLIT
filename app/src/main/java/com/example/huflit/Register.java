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



public class Register extends AppCompatActivity {

//khai bao cac bien o day

    EditText edtName2, edtPassword2, edtEmail;
    Button btnSignin, back;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        anhxa();

        //xu li giao dien nguoi dung


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void anhxa() {
        edtName2 = findViewById(R.id.edtName2);
        edtPassword2 = findViewById(R.id.edtPassword2);
        edtEmail = findViewById(R.id.edtEmail);
        btnSignin = findViewById(R.id.btnSignin);
        back = findViewById(R.id.back);
    }

}