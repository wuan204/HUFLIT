package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huflit.adapter.TrangChuAdapter;
import com.example.huflit.adapter.mystoryAdapter;
import com.example.huflit.item.itemTrangchu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Truyen_da_dang extends AppCompatActivity {
    ImageView imgBack, imgMenu2;
    RecyclerView recyclerView;
    ArrayList<itemTrangchu> arrayList;
    mystoryAdapter adapter;
    RequestQueue queue;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_da_dang);

        imgBack = findViewById(R.id.imgBack);
        imgMenu2 = findViewById(R.id.imgMenu2);
        recyclerView=findViewById(R.id.recylayout);
        arrayList = new ArrayList<>();
        adapter = new mystoryAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
        //
        SharedPreferences sharedPreferences = getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
      int  authorid  =sharedPreferences.getInt("authorid",0);
        String urlgetitem="https://huf-android.000webhostapp.com/getMyStory.php?AuthorID="+authorid;
        //

        //
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi người dùng click vào imgMenu2, hiển thị menu
                showPopupMenu(imgMenu2);
            }
        });
        queue= Volley.newRequestQueue(this);
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
                                adapter.notifyDataSetChanged();
                            }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dangbai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.item1) {
            // Xử lý khi người dùng click vào mục chính
            return true;
        } else if (itemId == R.id.imgMenu2) {
            // Xử lý khi người dùng click vào imgMenu2
            // Bạn có thể mở một PopupMenu ở đây để hiển thị các mục con
            showPopupMenu(imgMenu2);
            return true;
        } else if (itemId == R.id.item1) {
            // Xử lý khi người dùng click vào mục con t1
            showToast("Truyen1 đã được click");
            return true;
        } else if (itemId == R.id.item2) {
            // Xử lý khi người dùng click vào mục con t2
            showToast("Truyen2 đã được click");
            return true;
        } else if (itemId == R.id.item3) {
            // Xử lý khi người dùng click vào mục con t3
            showToast("Truyen3 đã được click");
            return true;
        } else if (itemId == R.id.item4) {
            // Xử lý khi người dùng click vào mục con t4
            showToast("Truyen4 đã được click");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_dangbai, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                onOptionsItemSelected(menuItem);
                return true;
            }
        });

        popupMenu.show();
    }

    private void showToast(String message) {
        // Inflate the custom layout
        View layout = getLayoutInflater().inflate(R.layout.toast, findViewById(R.id.custom_toast_container));

        // Set the text of the TextView in the custom layout
        TextView text = layout.findViewById(R.id.ThongBao);
        text.setText(message);

        // Apply the custom shape drawable as the background
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.toast_menu_item); // R.drawable.custom_toast_background should point to the XML shape drawable
        text.setBackground(gradientDrawable);

        // Create the Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        // Show the Toast in the center of the screen
        toast.setGravity(Gravity.CENTER, 0, 0);

        // Show the Toast
        toast.show();
    }

    public void PrintToast(String message) {
        // Inflate the custom layout
        View layout = getLayoutInflater().inflate(R.layout.toast, findViewById(R.id.custom_toast_container));

        // Set the text of the TextView in the custom layout
        TextView text = layout.findViewById(R.id.ThongBao);
        text.setText(message);

        // Create the Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        // Show the Toast in the center of the screen
        toast.setGravity(Gravity.CENTER, 0, 0);

        // Show the Toast
        toast.show();
    }
}
