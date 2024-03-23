package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.ContentImgAdapter;
import com.example.huflit.item.itemIMG;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContentIMG extends AppCompatActivity {
    ContentImgAdapter imgAdapter;
    ListView listView;
    RequestQueue requestQueue;
    List<itemIMG> urlList;
    LinearLayout title,button;
    int id;
    boolean isLayoutVisible = true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_img);
        listView=findViewById(R.id.listimg);
        title=findViewById(R.id.titlelayout);
        button=findViewById(R.id.buttonlayout);

         urlList = new ArrayList<>();
        imgAdapter=new ContentImgAdapter(this,urlList);
        listView.setAdapter(imgAdapter);
        Intent i=getIntent();
        if(i!=null)
        {
            id=i.getIntExtra("idchap",0);
            String url = "https://huf-android.000webhostapp.com/noiDungTranh.php?ChtID="+id ;
            getData(url);
        }
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Kiểm tra trạng thái hiện tại của layout
            if (isLayoutVisible) {
                // Ẩn layout nếu đang hiển thị
                title.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
            } else {
                // Hiển thị lại layout nếu đang ẩn
                title.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }

            // Đảo ngược trạng thái của biến
            isLayoutVisible = !isLayoutVisible;
        });
    }
    private  void getData(String url){
        requestQueue= Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for(int i=0;i<array.length();i++)
                            {  JSONObject o=array.getJSONObject(i);
                                String link=o.getString("Link");
                                itemIMG itemIMG=new itemIMG(link);
                                urlList.add(itemIMG);
                                imgAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      Toast.makeText(ContentIMG.this,"Loiiiiiiiiiii",Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(request);
    }
}