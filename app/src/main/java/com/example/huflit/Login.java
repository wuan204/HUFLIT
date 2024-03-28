package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {

    EditText Name, Password;
    Button Login;
    TextView txtForgot, txtRegister;
    ImageView imgEye;
    CheckBox cb_remember;
    private boolean isLoggedIn = false;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        anhxa();
      // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
        // Kiểm tra nếu đã đăng nhập từ trước
        if (checkIfLoggedIn()) {
            String username = sharedPreferences.getString("username", "");
            startMenuActivity();
        }

        Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        imgEye.setImageResource(R.drawable.eye);

        Login.setOnClickListener(v -> dieukienlogin());

        imgEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }

            private void togglePasswordVisibility() {
                if(Password.getTransformationMethod()== PasswordTransformationMethod.getInstance()){
                    Password.setTransformationMethod(null);
                    imgEye.setImageResource(R.drawable.eye);
                }else{
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
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
    }

    private boolean checkIfLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    private void togglePasswordVisibility() {
        if (Password.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
            Password.setTransformationMethod(null);
            imgEye.setImageResource(R.drawable.eye);
        }
        else
        {
            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            imgEye.setImageResource(R.drawable.eye);
        }
    }

    public void dieukienlogin() {
        String username = Name.getText().toString().trim();
        String password = Password.getText().toString().trim();
        if (username.isEmpty() || password.isEmpty()) {
            nhacnhonhapdu();
        } else {
            new JsonTask().execute("https://huf-android.000webhostapp.com/dangnhap.php?username=" + username + "&password=" + password);
        }


    }

    private class JsonTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            HttpURLConnection urlConnection = null;

            try
            {
                URL url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    result += line;
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (urlConnection != null)
                {
                    urlConnection.disconnect();
                }
            }
            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);
                boolean loginSuccess = jsonObject.getBoolean("loginSuccess");
                if (loginSuccess) {
                    dangnhapthanhcong();
                    JSONObject userData = jsonObject.getJSONObject("userData");
                    String username = Name.getText().toString().trim(); // Lấy tên người dùng từ EditText
                    isLoggedIn = true; // Đặt biến isLoggedIn thành true khi đăng nhập thành công
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putBoolean("isLoggedIn", isLoggedIn);
                    int userid=userData.getInt("UserID");
                    int roleid=userData.getInt("RoleID");
                    editor.putInt("userid",userid);
                    editor.putInt("roleid",roleid);
                    editor.apply();

                    startMenuActivity();

                } else {
                    dangnhapthatbai();
                    Password.setText("");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    private void PrintToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }



    //loi bao
    public void nhacnhonhapdu() {
        Toast.makeText(Login.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_LONG).show();
    }

    public  void  dangnhapthanhcong()
    {
        Toast.makeText(Login.this,"đăng nhập thành công",Toast.LENGTH_LONG).show();
    }

    public  void  dangnhapthatbai()
    {
        Toast.makeText(Login.this,"tài khoản hoặc mật khẩu không chính xác",Toast.LENGTH_LONG).show();
    }
    private void startMenuActivity() {
        Intent intent = new Intent(Login.this, Menu.class);
        startActivity(intent);
        Password.setText("");

    }
    private void startManager() {
        Intent intent = new Intent(Login.this, NguoiDungQly.class);
        startActivity(intent);

    }
    //anh xa
    public void anhxa() {
        Name = findViewById(R.id.edtName);
        Password = findViewById(R.id.edtPassword);
        Login = findViewById(R.id.btnRegist);
       // btnGoogle = findViewById(R.id.btnGoogle);
        txtRegister = findViewById(R.id.txtRegister);
        imgEye = findViewById(R.id.imgEye);
        cb_remember = findViewById(R.id.cb_remember);


//        //lưu thông tin
//        SharedPreferences sharedPreferences1 = getSharedPreferences(remember,MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences1.edit();
//        //lưu dạng phân rã
//        editor.putString("Username",Name.getText().toString());
//        editor.putString("password",Password.getText().toString());
//        editor.putBoolean("Save",cb_remember.isChecked());
//        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Hiển thị thông tin đã được lưu
        String username = sharedPreferences.getString("username","");
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            Name.setText(username);
        }
    }
}