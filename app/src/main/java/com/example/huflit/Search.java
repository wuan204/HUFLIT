package com.example.huflit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.SearchAdapter;
import com.example.huflit.adapter.TrangChuAdapter;
import com.example.huflit.item.itemTrangchu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    RecyclerView gridTruyenTranh;
    EditText edtTimKiem;
    ImageView imgBack;
    ArrayList<itemTrangchu> arrayList;
    TrangChuAdapter searchAdapter;
    RequestQueue queue;
    String urlgetitem="https://huf-android.000webhostapp.com/getItem.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        anhXa();
        setclick();
        arrayList=new ArrayList<>();
        searchAdapter = new TrangChuAdapter(this, arrayList);
        queue= Volley.newRequestQueue(this);
        gridTruyenTranh.setAdapter(searchAdapter);
        StringRequest request=new StringRequest(Request.Method.GET, urlgetitem,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array=new JSONArray(response);
                            for(int i=0;i<array.length();i++){
                                JSONObject o=array.getJSONObject(i);
                                String tenTruyen,linkAnh;
                                int id;
                                id=o.getInt("ID");
                                tenTruyen = o.getString("tenTruyen");
                                linkAnh = o.getString("linkAnh");
                                itemTrangchu item=new itemTrangchu(id,tenTruyen,linkAnh);
                                arrayList.add(item);
                            }
                            searchAdapter.notifyDataSetChanged(); // Cập nhật giao diện sau khi thêm dữ liệu
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(request);
    }


    private void setclick() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        gridTruyenTranh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Search.this, viewstory.class);
//                startActivity(intent);
//            }
//        });
    }

    private void anhXa() {
        edtTimKiem= findViewById(R.id.edtTimKiem);
        gridTruyenTranh = findViewById(R.id.gridTruyenTranh);
        imgBack = findViewById(R.id.imgBack);
    }
}
