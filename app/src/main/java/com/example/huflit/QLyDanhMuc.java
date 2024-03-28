    package com.example.huflit;

    import android.annotation.SuppressLint;
    import android.app.Dialog;
    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.Gravity;
    import android.view.View;
    import android.view.WindowManager;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageButton;
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
    import com.example.huflit.adapter.IOnclickItem;
    import com.example.huflit.api.ApiDanhMucQLy;
    import com.example.huflit.interfaces.LayDanhMucVe;
    import com.example.huflit.object.DanhMucQly;
    import com.google.android.gms.tasks.OnFailureListener;
    import com.google.android.gms.tasks.OnSuccessListener;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;

    import android.view.Menu;
    import android.view.MenuItem;
    public class QLyDanhMuc extends AppCompatActivity implements LayDanhMucVe, IOnclickItem {
        DanhMucQly danhMucQly;
        ListView lsvDanhMucQly;
        EditText medtAddname;
        ImageView btnadd,btnmenu;
        ImageButton back;
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

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        private void  init(){
            arrDanhMuc = new ArrayList<>();

            danhMucQLyAdapter = new DanhMucQLyAdapter(this,0,arrDanhMuc,this);
        }
        private void  anhXa(){

            lsvDanhMucQly = findViewById(R.id.lsvDanhMucQly);
            medtAddname=findViewById(R.id.edtaddname);
            back=findViewById(R.id.backdanhmuc1);

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
                danhMucQLyAdapter = new DanhMucQLyAdapter(this,0,arrDanhMuc,this);
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

        @Override
        public void update(DanhMucQly danhMucQly) {
            final Dialog dialog = new Dialog(QLyDanhMuc.this);
            //We have added a title in the custom layout. So let's disable the default title.

            //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
            dialog.setCancelable(true);
            //Mention the name of the layout of your custom dialog.
            dialog.setContentView(R.layout.dialog_update_danhmuc);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.gravity = Gravity.CENTER;

            dialog.getWindow().setAttributes(lp);

            //Initializing the views of the dialog.
            final EditText etname = dialog.findViewById(R.id.etName);
            etname.setText(danhMucQly.getTenDanhMuc());
            Button submitButton = dialog.findViewById(R.id.submit_button);
            Button cancleButton = dialog.findViewById(R.id.cancle_button);




            submitButton.setOnClickListener(v -> {
                String nameCategory = etname.getText().toString();
                if(nameCategory.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Vui lòng không được bỏ trống thông tin.",Toast.LENGTH_SHORT).show();
                    return;
                }


                RequestQueue requestQueue = Volley.newRequestQueue(this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        "https://huf-android.000webhostapp.com/UpdateQLDM.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.trim().equals("success")) {
                                    Toast.makeText(QLyDanhMuc.this, "Cập nhật thành công",Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    new ApiDanhMucQLy(QLyDanhMuc.this).execute();
                                } else {
                                    Toast.makeText(QLyDanhMuc.this,"Cập nhật thất bại",Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(QLyDanhMuc.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("CateID",danhMucQly.getId());
                        params.put("newCateName",nameCategory);
                        Log.d("nhan ", "getParams: "+nameCategory);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);



            });


            cancleButton.setOnClickListener(v -> dialog.dismiss());

            dialog.show();
        }

        @Override
        public void delete(DanhMucQly danhMucQly) {
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    "https://huf-android.000webhostapp.com/DeleteQLDM.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(QLyDanhMuc.this, response,Toast.LENGTH_SHORT).show();
                            new ApiDanhMucQLy(QLyDanhMuc.this).execute();
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(QLyDanhMuc.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                        }
                    }
            ) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("CategoryID",danhMucQly.getId());
                    Log.d("nhan ", "getParams: "+danhMucQly.getId());
                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    }
