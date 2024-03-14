package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.R;
import com.example.huflit.adapter.ShowUserAdapter;
import com.example.huflit.item.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NguoiDungQly extends AppCompatActivity {
    ListView mylist;
    ArrayList<User> arrayList;
    ShowUserAdapter myadapter;
    String urlgetdata="https://huf-android.000webhostapp.com/getUser.php?fbclid=IwAR297yRuX5S-sHxaH6iNwA5q7LAeoLlE0Qhu8AyDJhhEiTAewjamijUUwVA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_qly);
    mylist=findViewById(R.id.listuser);
    arrayList=new ArrayList<User>();
    myadapter=new ShowUserAdapter(this,R.layout.item_user,arrayList);
    mylist.setAdapter(myadapter);
    getUser(urlgetdata);
    }
    private void getUser(String url){
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject object= response.getJSONObject(i);
                            int id= object.getInt("ID");
                            String name=object.getString("name");
                            String email=object.getString("email");
                            String pass=object.getString("pass");
                            int role=object.getInt("role");
                            arrayList.add(new User(id,role,name,email,pass));
                            Log.d("die", "onResponse: "+response);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    myadapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}