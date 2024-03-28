package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;import android.provider.MediaStore;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class mycomic extends AppCompatActivity {
    ImageView mbtnAddchapter;
    EditText medtname,medtdescripts;
    ImageView mimgdetail,mbtnSelectCate,imgitemdetail,btnDeleteStory;
    ImageButton mbtnimg;
    Spinner sttspiner,showspiner;
    TextView mtxttype,txtChapterNumber,txtViewNumber,txtLoveNumber,txtTimeUpdate,txtCate;
    RatingBar ratingView;
    String[] itemstt,itemshow;
    String urldele;
    public int id;

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri ImageUri;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycomic);
        medtname = (EditText) findViewById(R.id.edtTitledetail);
        medtdescripts = (EditText) findViewById(R.id.edtDescriptdetail);
        mimgdetail = findViewById(R.id.imgitemdetail);
        mbtnimg = (ImageButton) findViewById(R.id.btselectimgdetail);
        mbtnSelectCate=findViewById(R.id.selectcate);
        sttspiner=findViewById(R.id.spnSttt);
        showspiner=findViewById(R.id.spnShow);
        mtxttype=findViewById(R.id.txtType);
        txtChapterNumber=findViewById(R.id.txtChapterNumber);
        txtViewNumber=findViewById(R.id.txtViewNumber);
        txtLoveNumber=findViewById(R.id.txtLoveNumber);
        txtTimeUpdate=findViewById(R.id.txtTimeUpdate);
        ratingView=findViewById(R.id.ratingView);
        btnDeleteStory=findViewById(R.id.btnDeleteStory);
        imgitemdetail=findViewById(R.id.imgitemdetail);
        txtCate=findViewById(R.id.txtCate);
        //
         itemstt = new String[]{"Đang cập nhật", "Hoàn thành", "Ngưng bút"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemstt);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sttspiner.setAdapter(adapter);
        itemshow = new String[]{"Mọi người", "Chỉ mình tôi"};
        ArrayAdapter<String> adt2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemshow);
        adt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        showspiner.setAdapter(adt2);
        //
        mbtnSelectCate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mycomic.this, showcate.class);
                startActivity(i);
            }
        });
        Intent intent = getIntent();
        if(intent!=null){

            id=intent.getIntExtra("id",0);
            getData("https://huf-android.000webhostapp.com/layTruyen.php?StrID="+id);
            urldele = "https://huf-android.000webhostapp.com/deleteStory.php?StrID="+id;
            btnDeleteStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Xacnhanxoa();
                }
            });

        }
            mbtnimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
                }
            });


            mbtnAddchapter = (ImageView) findViewById(R.id.btnAddchapLayout);
            mbtnAddchapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent;

                    if(mtxttype.getText().toString().equals("Truyện tranh"))
                    { intent = new Intent(mycomic.this, add_chaptercomic.class);}
                    else intent=new Intent(mycomic.this, add_chapterword.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });
        }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            ImageUri = data.getData();

            mimgdetail.setImageURI(ImageUri);
        }
    }
    private void getData(String url) {
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array=new JSONArray(response);
                            for(int i=0;i<array.length();i++)
                            {
                                JSONObject o= array.getJSONObject(i);
                                int id = o.has("ID") ? o.getInt("ID") : 0;
                                String ten= (String) o.get("tenTruyen");
                                String anh=(String) o.getString("linkAnh");
                                String tomat=(String) o.getString("tomTat");
                                String alias=(String) o.getString("alias");
                                String danhmuc=(String) o.getString("danhMuc");
                                String stt=(String) o.getString("status");

                                String show=(String) o.getString("show");
                                int love = 0;
                                if (!o.isNull("love")) {
                                    love = o.getInt("love");
                                }

                                int view = 0;
                                if (!o.isNull("love")) {
                                    view = o.getInt("love");
                                }
                                double rating=0.0;
                                if (!o.isNull("rating")) {
                                    rating = o.getDouble("rating");
                                }
                                float rate=(float) rating;
                                String update=(String) o.getString("lastUpdate");
                                String type=(String)  o.getString("type");
                                int num=0;
                                if (!o.isNull("num")) {
                                    num = o.getInt("num");
                                }
//
                                Date currentDate = new Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                try {
                                    // Chuyển đổi ngày cập nhật từ chuỗi thành đối tượng Date
                                    Date updateDate = sdf.parse(update);

                                    // Tính toán khoảng cách thời gian giữa hai ngày
                                    long diffInMillis = currentDate.getTime() - updateDate.getTime();
                                    long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
                                    String diffInDaysString = String.valueOf(diffInDays);
                                    txtTimeUpdate.setText(diffInDaysString+" ngày trước");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                medtname.setText(ten);
                                if(danhmuc=="null"){danhmuc="Khác";}
                                txtCate.setText(danhmuc);
                                mtxttype.setText(type);
                                Glide.with(mycomic.this).load(anh).into(mbtnimg);
                                medtdescripts.setText(tomat);

                                if (Arrays.asList(itemstt).contains(stt)) {
                                    int position = Arrays.asList(itemstt).indexOf(stt);
                                    sttspiner.setSelection(position);
                                }
                                if (Arrays.asList(itemshow).contains(show)) {
                                    int position = Arrays.asList(itemshow).indexOf(show);
                                    showspiner.setSelection(position);
                                }
                                txtLoveNumber.setText(love+" lượt thích");
                                txtViewNumber.setText(view+" lượt xem");
                                ratingView.setRating(rate);
                                txtChapterNumber.setText(num+" chương");
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mycomic.this,"khong lay link duoc",Toast.LENGTH_LONG).show();
                    }
                });
        queue.add(request);
    }
    public void deleteStr()
    {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST,urldele, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG mycomic", "@@: "+response);
                if (response.trim().equals("success")) {
                    Toast.makeText(mycomic.this, "xóa thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mycomic.this, Truyen_da_dang.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(mycomic.this,"xoá không thành công",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Xử lý lỗi khi xóa người dùng
                Toast.makeText(mycomic.this, "xóa thất bại", Toast.LENGTH_SHORT).show();
                Log.e("Nquanliuser", "lỗi trong lúc xóa", error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("StrID", String.valueOf(id));
                Log.d("G", "getParams: "+id);
                return params;
            }
        };
        queue.add(request); // Thêm request vào hàng đợi
    }
    public  void Xacnhanxoa()
    {
        AlertDialog.Builder dialogxoa=new AlertDialog.Builder(mycomic.this);
        dialogxoa.setMessage("Xác nhận xóa truyện không");
        dialogxoa.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                deleteStr();
            }
        });
        dialogxoa.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialogxoa.show();
}}
