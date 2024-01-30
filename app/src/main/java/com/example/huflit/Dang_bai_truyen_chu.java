package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dang_bai_truyen_chu extends AppCompatActivity {
    ImageView imgBack;
    TextView txtDangBai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_bai_truyen_chu);
        imgBack = findViewById(R.id.imgBack);
        txtDangBai = findViewById(R.id.txtDangBai);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }
    private void showCustomDialog() {
        // Tạo Dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_diolog_dang_ki_truyen);

        // Ánh xạ các thành phần trong Dialog
        TextView txtDialogTitle = dialog.findViewById(R.id.txtxxx);
        TextView txtDialogContent = dialog.findViewById(R.id.txtxxxx);
        Button btnNo = dialog.findViewById(R.id.btnYes);
        Button btnYes = dialog.findViewById(R.id.btnNo);

        // Set nội dung cho các TextView trong Dialog
        txtDialogTitle.setText("Đăng bài");
        txtDialogContent.setText("Bạn có chắc chắn muốn đăng truyện không?");

        // Xử lý sự kiện khi nhấn nút "Không"
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng Dialog khi người dùng nhấn "Không"
                dialog.dismiss();
            }
        });

        // Xử lý sự kiện khi nhấn nút "Có"
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện các thao tác khi người dùng nhấn "Có"
                // Ví dụ: Gửi dữ liệu, đăng truyện, v.v.
                // ...

                // Đóng Dialog
                dialog.dismiss();
            }
        });

        // Hiển thị Dialog
        dialog.show();
    }
}