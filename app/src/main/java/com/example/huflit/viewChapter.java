package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.ShowListChapterAdapter;
import com.example.huflit.item.Chapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class viewChapter extends AppCompatActivity {
    ListView listView;
    ShowListChapterAdapter adapter;
    ArrayList<Chapter> mylist;

    String urlgetchap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadapter);
        listView=findViewById(R.id.listchapter);
        mylist=new ArrayList<Chapter>();

        adapter=new ShowListChapterAdapter(this,mylist,R.layout.item_chapter);
        listView.setAdapter(adapter);

        //
        Intent i=getIntent();
        if(i!=null){

          int  id=i.getIntExtra("id",0);
            urlgetchap="https://huf-android.000webhostapp.com/getChapter.php?StrID="+id;
            getchap(urlgetchap);
        }
        else {
            Toast.makeText(this,"Không lấy được id truyện @@",Toast.LENGTH_LONG).show();
        }
        //

    }

    private void getchap(String url) {
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array=new JSONArray(response);
                            for(int i=0;i<array.length();i++)
                            {  JSONObject o=array.getJSONObject(i);
                                int id=o.getInt("ID");
                                int strid=o.getInt("strid");
                                String name=o.getString("name");
                                String content=o.getString("content");
                            Chapter chapter=new Chapter(id,strid,name,content);
                            mylist.add(chapter);
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(viewChapter.this, "Lỗi khi nhận dữ liệu từ server", Toast.LENGTH_SHORT).show();

            }
        });
        queue.add(request);
    }

}