package com.example.huflit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.huflit.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.example.huflit.item.category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class categorymanager extends AppCompatActivity {
    EditText medtName;
    ImageView mbtnAdd;
    ListView mylist;
    ArrayList<category> listcate;
    CategoryAdapter adapter;
    String urlGetData="https://huf-android.000webhostapp.com/getcate.php";
    String urlInsertData="";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorymanager);
        medtName=findViewById(R.id.namecategory);
        mbtnAdd=findViewById(R.id.btnaddcate);
        mylist=findViewById(R.id.listcate);
        //
        listcate=new ArrayList<category>();
        adapter=new CategoryAdapter(this,listcate,R.layout.list_itemcategory);
        mylist.setAdapter(adapter);
        //
        getData(urlGetData);
        //
        mbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namecate= medtName.getText().toString().trim();
                if(namecate.isEmpty())
                {
                    Toast.makeText(categorymanager.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //
//    private void insertData(String url){
//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(categorymanager.this,"Lỗi thêm!",Toast.LENGTH_LONG).show();
//
//                    }
//                }){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map=new HashMap<>();
//                map.put("namecate",medtName.getText().toString());
//
//                return super.getParams();
//            }
//        };
//        queue.add(stringRequest);
//    }
    private void getData(String url){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                       listcate.add(new category(object.getInt("CateID"),
                               object.getString("Catename")));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                } adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(jsonArrayRequest);
    }
}