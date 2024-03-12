package com.example.huflit;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Y_kien extends AppCompatActivity {

    private EditText editText;
    private Button buttonSave;
    private Button buttonClear;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_kien);

        //back
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Y_kien.this,Menu.class);
                startActivity(intent);
            }
        });

        editText = findViewById(R.id.loiykien);
        buttonSave = findViewById(R.id.btnXacnhanykien);
        buttonClear=findViewById(R.id.btnxoadanhgia);

        //nhap y kien

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = editText.getText().toString();
                // Kiểm tra
                if (!data.isEmpty()) {
                    //hien thi khi co du lieu
                    Toast.makeText(Y_kien.this, "" + data, Toast.LENGTH_SHORT).show();
                } else {
                    // Hiển thị thông báo khi không có dữ lieu
                    Toast.makeText(Y_kien.this,"Chưa có ý kiến", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //xoa y kien
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa dữ liệu trong EditText
                editText.setText("");
                Toast.makeText(Y_kien.this, "Ý kiến đã được xóa ", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
