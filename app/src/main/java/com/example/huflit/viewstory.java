package com.example.huflit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.huflit.item.Chapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class viewstory extends AppCompatActivity {
    private ImageView mbtBack, mbtRp, mbtLove, mbtFl, mbtDown, mbtCmt,mimgStory;
    public int id;
    RatingBar ratingBar;

    private Button mbtViewCmt, mbtRead, mbtViewChapter;
    TextView mtxtStrName,mtxtAlias,mtxtCate,mtxtType,txtDescipt,mtxtStt,mview,mtxtLoveNumber,txtchapnum,txtTimeUpdate;
    private String StrID;

    private int storyId,SoSaoLAmTron;
    private  double Star;

    EditText ViewBinhLuan;

    ImageView btnBinhluanok;
    private ArrayList<Chapter> mylist;
    private String type;
    private static final int REQUEST_CODE_VIEW_CHAPTER = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);


        anhxa();
        setclick();
        // Khởi tạo mylist
        mylist = new ArrayList<>();

        // Nhận StrID từ Intent
        Intent intent = getIntent();

        if(intent!=null){

            id=intent.getIntExtra("id",0);
            getData("https://huf-android.000webhostapp.com/layTruyen.php?StrID="+id);

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

                                storyId=id;

                                String ten= (String) o.get("tenTruyen");
                                String anh=(String) o.getString("linkAnh");
                                String tomat=(String) o.getString("tomTat");
                                String alias=(String) o.getString("alias");
                                String danhmuc=(String) o.getString("danhMuc");
                                String stt=(String) o.getString("status");
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
                                    Star=rating;
                                    SoSaoLAmTron=(int) Star;;
                                }
                                float rate=(float) rating;
                                String update=(String) o.getString("lastUpdate");
                                String type=(String)  o.getString("type");
                                int num=0;
                                if (!o.isNull("num"))
                                {
                                    num = o.getInt("num");
                                }

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
                                mtxtStrName.setText(ten);
                                if(danhmuc=="null"){danhmuc="Khác";}
                                mtxtCate.setText(danhmuc);
                                mtxtType.setText(type);
                                mtxtAlias.setText(alias);
                                Glide.with(viewstory.this).load(anh).into(mimgStory);
                                txtDescipt.setText(tomat);
                                mtxtStt.setText(stt);
                                mtxtLoveNumber.setText(love+" lượt thích");
                                mview.setText(view+" lượt xem");
                                ratingBar.setRating(rate);
                                txtchapnum.setText(num+" chương");
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(viewstory.this,"khong lay link duoc",Toast.LENGTH_LONG).show();
                    }
                });
        queue.add(request);
    }

    //ham them comment
    public  void addcomment()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("tk_mk_login", Context.MODE_PRIVATE);
        int userid = sharedPreferences.getInt("userid",-1);

        String Comment =ViewBinhLuan.getText().toString().trim();

        int idTruyen =storyId;

        // Kiểm tra xem nội dung bình luận có rỗng không
        if(!Comment.isEmpty())
        {
            try{
                // chuyen comment thanh endcode va sp Tieng Viet
                Comment =URLEncoder.encode(Comment,"UTF-8");
            }
            catch(UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }


            RequestQueue queue =Volley.newRequestQueue(this);


            String url ="https://huf-android.000webhostapp.com/themBinhluan.php";

            String finalComment =Comment;
            StringRequest request=new StringRequest(Request.Method.POST,url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response)
                        {

                            Toast.makeText(viewstory.this,"Bình luận thành công",Toast.LENGTH_SHORT).show();
                            ViewBinhLuan.setText(""); // Xóa nội dung trong EditText sau khi gửi
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Xử lý lỗi khi gửi bình luận
                            Toast.makeText(viewstory.this,"Xảy ra lỗi khi gửi bình luận",Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    // Thêm nội dung bình luận vào các tham số
                    Map<String, String> params =new HashMap<>();

                    params.put("userID",String.valueOf(userid));
                    params.put("StrID",String.valueOf(storyId));
                    params.put("Content",finalComment);
                    params.put("Star",String.valueOf(SoSaoLAmTron));
                    return params;
                }
            };


            queue.add(request);
        }
        else
        {
            nhacthemBinhluan();


        }

    }
    private void getChapters(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Xử lý dữ liệu trả về để lưu vào mylist
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                // Lấy thông tin chương và thêm vào mylist
                                // ...

                                // Sau khi thêm danh sách chương, hiển thị nút mbtRead
                                mbtRead.setVisibility(View.VISIBLE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(viewstory.this, "Không thể lấy danh sách chương", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(request);
    }

    private void anhxa() {
        // Initialize your UI components here
        mbtBack = findViewById(R.id.btBack);
        mbtRp = findViewById(R.id.btReport);
        mbtLove = findViewById(R.id.btLove);
        mbtFl = findViewById(R.id.btFl);
        mbtDown = findViewById(R.id.btDown);
        mbtViewCmt = findViewById(R.id.btViewCmt);
        mbtCmt = findViewById(R.id.btnBinhluanok);
        mbtRead = findViewById(R.id.btRead);
        mbtViewChapter = findViewById(R.id.btViewChapter);
        mtxtStrName=findViewById(R.id.txtStrName);
        mimgStory=findViewById(R.id.imgStory);
        mtxtAlias=findViewById(R.id.txtAlias);
        mtxtCate=findViewById(R.id.txtCate);
        mtxtType=findViewById(R.id.txtType);
        txtDescipt=findViewById(R.id.txtDescipt);
        mtxtStt=findViewById(R.id.txtStt);
        mview = findViewById(R.id.txtViewNumber);
        mtxtLoveNumber=findViewById(R.id.txtLoveNumber);
        ratingBar=findViewById(R.id.ratingView);
        txtchapnum=findViewById(R.id.txtChapterNumber);
        txtTimeUpdate=findViewById(R.id.txtTimeUpdate);

        ViewBinhLuan=findViewById(R.id.viewstoryBinhluan);
        btnBinhluanok=findViewById(R.id.btnBinhluanok);
    }

    private void setclick() {
        mbtBack.setOnClickListener(v -> finish());

        mbtRp.setOnClickListener(v -> {
            // Handle Report button click
            // ShowDialogRp();
        });

//        mbtLove.setOnClickListener(v -> {
//            // Handle Love button click
//            // Toggle the love state and update UI
//            boolean isLoved = // Determine the state based on your data
//            if (isLoved) {
//                mbtLove.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
//            } else {
//                mbtLove.clearColorFilter();
//            }
//        });

        // Trong phương thức setclick() của Activity viewstory
        final boolean[] fromMbtRead = {false};

        mbtRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewstory.this, viewChapter.class);
                intent.putExtra("id", id);
                intent.putExtra("type", mtxtType.getText().toString());
                startActivityForResult(intent, REQUEST_CODE_VIEW_CHAPTER);
            }
        });



        mbtViewChapter.setOnClickListener(v -> {
            Intent i=new Intent(viewstory.this, viewChapter.class);
            i.putExtra("id",id);
            i.putExtra("type",mtxtType.getText().toString());
            startActivity(i);
        });

        mbtViewCmt.setOnClickListener(v -> {

        });
        btnBinhluanok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("tk_mk_login",Context.MODE_PRIVATE);
                int user =sharedPreferences.getInt("userid",-1);

                if (user == -1)
                {
                    // Người dùng chưa đăng nhập, hiển thị thông báo yêu cầu đăng nhập hoặc đăng ký
                    Toast.makeText(viewstory.this, "Vui lòng đăng nhập hoặc đăng ký để đăng bình luận", Toast.LENGTH_SHORT).show();
                }
                else if(user>-1)
                {
                    addcomment();

                }

                else
                {
                    Toast.makeText(viewstory.this, "Erros", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_VIEW_CHAPTER && resultCode == RESULT_OK) {
            // Kiểm tra kết quả trả về từ viewChapter là RESULT_OK
            // Khi đó, không cần làm gì cả vì đã tự động chuyển đến chương đầu tiên
        }
    }
    // nhac nho
    public  void nhacthemBinhluan(){

        Toast.makeText(viewstory.this,"Vui long nhập  chi tiết bình luận", Toast.LENGTH_SHORT).show();
    }

}
