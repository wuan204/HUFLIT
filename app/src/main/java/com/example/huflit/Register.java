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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText edtName2, Password1, edtEmail, Password2;
    Button btnsignin;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        anhxa();

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                firebaseDatabase = FirebaseDatabase.getInstance();
//                databaseReference = firebaseDatabase.getReference();
//                String username = edtName2.getText().toString();
//                String password = Password1.getText().toString().trim();
//                String confirmpassword = Password2.getText().toString().trim();
//                String email = edtEmail.getText().toString();
//
//                HelperClas helperClas = new HelperClas(username,email,confirmpassword,password);
//                databaseReference.child(username).setValue(helperClas);
//
//                Toast.makeText(Register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Register.this, Login.class);
//                startActivity(intent);

            }
        });
    }




    private void anhxa()
    {

        edtName2 = findViewById(R.id.edtName2);
        Password1 = findViewById(R.id.edtPassword2);
        edtEmail = findViewById(R.id.edtEmail);
        btnsignin = findViewById(R.id.btnSignin);
        Password2 = findViewById(R.id.comfirmPass);
    }
}