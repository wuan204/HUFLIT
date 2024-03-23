package com.example.huflit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.huflit.item.StoryFull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class viewstory extends AppCompatActivity {
    private ImageView mbtBack, mbtRp, mbtLove, mbtFl, mbtDown, mbtCmt,mimgStory;
   public int id;
RatingBar ratingBar;

    private Button mbtViewCmt, mbtRead, mbtViewChapter;
    TextView mtxtStrName,mtxtAlias,mtxtCate,mtxtType,txtDescipt,mtxtStt,mview,mtxtLoveNumber,txtchapnum,txtTimeUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstory);
        anhxa();
        setclick();

        //
        Intent intent=getIntent();
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
                                }//
                                mtxtStrName.setText(ten);
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

    private void anhxa() {
        // Initialize your UI components here
        mbtBack = findViewById(R.id.btBack);
        mbtRp = findViewById(R.id.btReport);
        mbtLove = findViewById(R.id.btLove);
        mbtFl = findViewById(R.id.btFl);
        mbtDown = findViewById(R.id.btDown);
        mbtViewCmt = findViewById(R.id.btViewCmt);
        mbtCmt = findViewById(R.id.btCmt);
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

        mbtRead.setOnClickListener(v -> {
            // Handle Read button click
            Intent i = new Intent(viewstory.this, Content.class);
            startActivity(i);
        });

        mbtViewChapter.setOnClickListener(v -> {
      Intent i=new Intent(viewstory.this, viewChapter.class);
            i.putExtra("id",id);
            i.putExtra("type",mtxtType.getText().toString());
            startActivity(i);
        });

        mbtViewCmt.setOnClickListener(v -> {

        });
    }

}
