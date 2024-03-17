package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
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
    Button Login, btnGoogle;
    TextView txtForgot, txtRegister;
    ImageView imgEye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

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
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleSignIn();

            }
        });

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

        if (username.isEmpty() || password.isEmpty())
        {
            nhacnhonhapdu();
        }
        else
        {
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

                if (loginSuccess)
                {
                    dangnhapthanhcong();

                    Intent i = new Intent(Login.this, Menu.class);
                    startActivity(i);
                    Password.setText("");
                }
                else
                {
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

    //anh xa

    public void anhxa() {
        Name = findViewById(R.id.edtName);
        Password = findViewById(R.id.edtPassword);
        Login = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.btnGoogle);
        txtForgot = findViewById(R.id.txtForgot);
        txtRegister = findViewById(R.id.txtRegister);
        imgEye = findViewById(R.id.imgEye);
    }
}