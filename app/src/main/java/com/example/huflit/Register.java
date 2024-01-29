package com.example.huflit;

import static com.example.huflit.R.id.edtName;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;


public class Register extends AppCompatActivity {

//khai bao cac bien o day

    EditText edtName2, edtPassword2, edtConfirm, edtSDT;
    Button btnSignin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //khai bao dia chi id o day

        edtName2 = findViewById(R.id.edtName2);
        edtPassword2= findViewById(R.id.edtPassword2);
        edtConfirm= findViewById(R.id.edtConfirm);
        edtSDT= findViewById(R.id.edtSDT);
        btnSignin = findViewById(R.id.btnSignin);


        //xu li giao din nguoi dung
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName2.getText().toString();
                String password = edtPassword2.getText().toString();
                String confirm =edtConfirm.getText().toString();
                String sdt = edtSDT.getText().toString();

                if(name.isEmpty() || password.isEmpty()|| confirm.isEmpty()||sdt.isEmpty()){
                    PrintToast("Vui lòng điền đầy đủ thông tin vào các mục trên");
                }
                else if (!isnumber(sdt) || sdt.length()< 10 ){
                    PrintToast("Số điện thoại không hợp lệ yêu cầu nhập lại");
                }
                else if(!password.equals(confirm)){
                    PrintToast("Mật khẩu không khớp");
                }

                else{
                    PrintToast("Đăng kí thành công");
                }


            }
        });


    }
    public void PrintToast(String message) {
        // Inflate the custom layout
        View layout = getLayoutInflater().inflate(R.layout.toast, findViewById(R.id.custom_toast_container));

        // Set the text of the TextView in the custom layout
        TextView text = layout.findViewById(R.id.ThongBao);
        text.setText(message);

        // Create the Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        // Show the Toast in the center of the screen
        toast.setGravity(Gravity.CENTER, 0, 0);

        // Show the Toast
        toast.show();
    }

    private boolean     isnumber(String str){
        return TextUtils.isDigitsOnly(str);
    }
    private void saveUserData(String name, String password, String sdt){
        SharedPreferences preferences= getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("name", name);
        editor.putString("password", password);
        editor.putString("SDT", sdt);
        editor.apply();
    }
    private boolean isUserLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        // Kiểm tra xem có dữ liệu người dùng hay không
        return preferences.contains("name") && preferences.contains("password") && preferences.contains("sdt");
    }
    private String getUserName() {
        SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
        return preferences.getString("name", "");
    }
}