package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.huflit.item.User;

public class Administrator extends AppCompatActivity {
    ImageView back;

    Button user,Cate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
        anhxa();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Administrator.this,NguoiDungQly.class);
                startActivity(intent);


            }
        });

        Cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Administrator.this, QLyDanhMuc.class);
                startActivity(intent);

            }
        });


    }



    public void anhxa()
    {
        back=findViewById(R.id.backAdmin);

        user=findViewById(R.id.AdministratorUser);
        Cate=findViewById(R.id.AdminCate);

    }
}