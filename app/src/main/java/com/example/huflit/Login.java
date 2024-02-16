package com.example.huflit;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class Login extends AppCompatActivity {
    private EditText PW, name, enterPW , phone;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        PW = findViewById(R.id.LGpassword);
        name = findViewById(R.id.LGusername);
        enterPW=findViewById(R.id.LGenterpw);
        phone=findViewById(R.id.Lgnumberp);
        button=findViewById(R.id.btnLogin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lưu thông tin hoặc hiển thị thông báo tùy thuộc vào EditText có rỗng không
                saveDataOrShowMessage();
            }
        });

        // Load dữ liệu đã lưu vào EditText khi Activity khởi động
        loadSavedData();

    }

    //set điều kiện
    private void saveDataOrShowMessage() {

        // neu chua dien thong tin
        if (TextUtils.isEmpty(name.getText().toString())) {
            Toast.makeText(this, "Vui lòng nhập name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(PW.getText().toString())) {
            Toast.makeText(this, "Vui lòng nhập thông tin Password", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(enterPW.getText().toString())) {
            Toast.makeText(this, "Vui lòng nhập thông tin enter Password", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone.getText().toString())) {
            Toast.makeText(this, "Vui lòng nhập thông tin SDT", Toast.LENGTH_SHORT).show();
        }

        //neu dien thong tin
        else {
            // Chuyển sang Activity khác nếu EditText có dữ liệu
            startActivity(new Intent(Login.this, Trang_Chu.class));
            // Lưu dữ liệu từ EditText khi chuyển Activity
            saveData();
        }
    }

    private void saveData() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saved_data_key), name.getText().toString());
        editor.apply();
    }

    private void loadSavedData() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String savedData = sharedPref.getString(getString(R.string.saved_data_key), "");
        name.setText(savedData);
    }


}
