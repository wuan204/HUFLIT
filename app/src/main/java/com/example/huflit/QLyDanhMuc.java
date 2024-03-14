    package com.example.huflit;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.ListView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;

    import com.android.volley.AuthFailureError;
    import com.android.volley.Request;
    import com.android.volley.RequestQueue;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.StringRequest;
    import com.android.volley.toolbox.Volley;
    import com.example.huflit.adapter.DanhMucQLyAdapter;
    import com.example.huflit.api.ApiDanhMucQLy;
    import com.example.huflit.interfaces.LayDanhMucVe;
    import com.example.huflit.object.DanhMucQly;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;

    import android.view.Menu;
    import android.view.MenuItem;
    public class QLyDanhMuc extends AppCompatActivity implements LayDanhMucVe {
        DanhMucQly danhMucQly;
        ListView lsvDanhMucQly;
        EditText medtAddname;
        ImageView btnadd,btnmenu;
        ArrayList<DanhMucQly> arrDanhMuc;
        DanhMucQLyAdapter danhMucQLyAdapter;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_qly_danh_muc);
            init();
            anhXa();
            setUp();
            setClick();
            new ApiDanhMucQLy(this).execute();
            btnadd=findViewById(R.id.btnaddnewcate);
            btnmenu=findViewById(R.id.btnmenu);
            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent i=new Intent(QLyDanhMuc.this, ThemDmuc.class);
                   startActivity(i);

                }
            });
            btnmenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(QLyDanhMuc.this,NguoiDungQly.class);
                    startActivity(i);
                }
            });
        }
        private void  init(){
            arrDanhMuc = new ArrayList<>();

            danhMucQLyAdapter = new DanhMucQLyAdapter(this,0,arrDanhMuc);
        }
        private void  anhXa(){

            lsvDanhMucQly = findViewById(R.id.lsvDanhMucQly);
            medtAddname=findViewById(R.id.edtaddname);

        }
        private void  setUp(){
            lsvDanhMucQly.setAdapter(danhMucQLyAdapter);
        }
        private void  setClick(){



            lsvDanhMucQly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    DanhMucQly danhMucQly = arrDanhMuc.get(i);
                }
            });
        }

        @Override
        public void batDau() {
            Toast.makeText(this,"Dang Lay Ve",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void ketThuc(String data) {
            try {
                arrDanhMuc.clear(); // Xóa dữ liệu cũ
                JSONArray arr = new JSONArray(data);
                for(int i = 0;i<arr.length();i++)
                {
                    JSONObject o = arr.getJSONObject(i);
                    arrDanhMuc.add(new DanhMucQly(o));
                }
                //adapter.notifyDataSetChanged(); // Thông báo cho adapter biết dữ liệu đã thay đổi
                danhMucQLyAdapter = new DanhMucQLyAdapter(this,0,arrDanhMuc);
                lsvDanhMucQly.setAdapter(danhMucQLyAdapter);

            }catch (JSONException e){}
        }

        @Override
        public void biLoi() {
            Toast.makeText(this,"Loi Ket Noi",Toast.LENGTH_SHORT).show();
        }

        public void update(View view) {
            new ApiDanhMucQLy(this).execute();
        }

        @Override
        public void onPointerCaptureChanged(boolean hasCapture) {
            super.onPointerCaptureChanged(hasCapture);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.manager, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id=item.getItemId();
            if (id == R.id.Qlcate) {

                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
