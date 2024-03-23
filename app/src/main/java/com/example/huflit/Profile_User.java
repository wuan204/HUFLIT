package com.example.huflit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile_User extends AppCompatActivity {

    TextView tx_Name,tx_Email,tx_Pass;
    String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_user);
        anhxa();

        // Khởi tạo RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://huf-android.000webhostapp.com/Profile.php";


        // Tạo yêu cầu JSON Object từ URL
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Lấy thông tin người dùng từ phản hồi JSON
                            String userName = response.getString("UserName");
                            String userEmail = response.getString("Email");
                            String userPassword = response.getString("UserPassword");

                            // Hiển thị thông tin người dùng trên giao diện
                            tx_Name.setText(userName);
                            tx_Email.setText(userEmail);
                            tx_Pass.setText(userPassword);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // Thêm yêu cầu vào hàng đợi
        queue.add(jsonObjectRequest);
    }
    private void anhxa() {
        tx_Name = findViewById(R.id.tx_Name);
        tx_Email= findViewById(R.id.tx_Email);
        tx_Pass = findViewById(R.id.tx_Pass);
    }
}
