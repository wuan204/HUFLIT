package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.item.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;

public class Update_user extends AppCompatActivity {

    ImageButton back;
    Button capnhat;
    EditText name, email, pass;
    TextView IDuser;
    int RoleID = 0;
    int id;

    Spinner spinner;

    String Url = "https://huf-android.000webhostapp.com/updateUser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        Intent intent =getIntent();
        User user =(User) intent.getSerializableExtra("dataUser");

        anhxa();
        hamxulihiendulieu();
        hamthemspiner();

        id = user.getUserid();
        name.setText(user.getName());
        pass.setText(user.getPass());
        email.setText(user.getEmail());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamxulinhapdulieu();
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);

                switch(item)
                {
                    case "writer":
                        RoleID = 2;
                        break;
                    case "viewer":
                        RoleID = 1;
                        break;
                    case "admin":
                        RoleID = 3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    // ham xu li
    public  void  hamthemspiner()
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("viewer");
        arrayList.add("writer");
        arrayList.add("admin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void hamxulihiendulieu() {
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("dataUser");

        if (user != null) {
            IDuser.setText("ID :" + String.valueOf(user.getUserid()));
        }
    }

    public void hamxulinhapdulieu() {

        UpdateUser();

    }
    //anh xa

    public void anhxa()
    {

        back = findViewById(R.id.updateback);
        IDuser = findViewById(R.id.IDupdate);
        name = findViewById(R.id.updatename);
        pass = findViewById(R.id.updatepass);
        email = findViewById(R.id.updateEmail);
        capnhat = findViewById(R.id.updatecapnhat);
        spinner = findViewById(R.id.SPNRole);
    }

    //ham update
    private void UpdateUser()
    {

        RequestQueue requestQueue = Volley.newRequestQueue(Update_user.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success")) {
                            Toast.makeText(Update_user.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Update_user.this, NguoiDungQly.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Update_user.this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Update_user.this, "Xảy ra lỗi: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("newUsername", name.getText().toString().trim());
                params.put("newPassword", pass.getText().toString().trim());
                params.put("newEmail", email.getText().toString().trim());
                params.put("UserID", String.valueOf(id));
                params.put("RoleID", String.valueOf(RoleID));

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

}