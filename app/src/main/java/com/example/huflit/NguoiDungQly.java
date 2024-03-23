package com.example.huflit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.ShowUserAdapter;
import com.example.huflit.item.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NguoiDungQly extends AppCompatActivity {
    ListView mylist;
    ArrayList<User> arrayList;

    ImageButton back;
    ShowUserAdapter myadapter;
    String urldeletedata = "https://huf-android.000webhostapp.com/deleteUser.php";
    String urlgetdata = "https://huf-android.000webhostapp.com/getUser.php?fbclid=IwAR297yRuX5S-sHxaH6iNwA5q7LAeoLlE0Qhu8AyDJhhEiTAewjamijUUwVA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_qly);

        anhxa();

        arrayList = new ArrayList<>();
        myadapter = new ShowUserAdapter(this, R.layout.item_user, arrayList);
        mylist.setAdapter(myadapter);

        if(savedInstanceState == null)
        {
            getUser(urlgetdata);

        }
        else {
            if (!arrayList.isEmpty()) {
                myadapter.notifyDataSetChanged();
            }
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void anhxa(){
        back=findViewById(R.id.quanliuerback);
        mylist = findViewById(R.id.listuser);
    }

    private void getUser(String url)
    {
        RequestQueue queue =Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET,urlgetdata, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                arrayList.clear();
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject object = jsonArray.getJSONObject(i);

                        int id = object.getInt("ID");
                        String name = object.getString("name");
                        String email = object.getString("email");
                        String pass = object.getString("pass");
                        int role = object.getInt("role");

                        arrayList.add(new User(id, role, name, email, pass));
                    }

                    myadapter.notifyDataSetChanged();
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Xử lý lỗi khi có lỗi xảy ra
                Toast.makeText(NguoiDungQly.this, "lỗi ", Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", "lỗi", error);
            }
        });
        queue.add(request);
    }

    public void deleteUser(int userID)
    {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST,urldeletedata, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(NguoiDungQly.this, "xóa thành công",Toast.LENGTH_SHORT).show();
                getUser(urlgetdata);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Xử lý lỗi khi xóa người dùng
                Toast.makeText(NguoiDungQly.this, "xóa thất bại", Toast.LENGTH_SHORT).show();
                Log.e("Nquanliuser", "lỗi trong lúc xóa", error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("UserID", String.valueOf(userID));
                return params;
            }
        };
        queue.add(request); // Thêm request vào hàng đợi
    }

}