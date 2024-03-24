package com.example.huflit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huflit.adapter.TheloaiAdapter;

import com.example.huflit.api.APIDanhMuc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class The_loai extends AppCompatActivity {
     RecyclerView recyclerView;
     TheloaiAdapter adapter;
     List<APIDanhMuc> categoryList;
    ImageView backButton;
     TextView titleTextView;
     String urlCategory ="https://huf-android.000webhostapp.com/layCategory.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);

        anhxa();
        setup();

        new LayCategory().execute(urlCategory);


        ;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        new LayCategory().execute(urlCategory);
    }

    //anhxa

    public  void anhxa()
    {
        recyclerView = findViewById(R.id.layoutCategory);
        backButton = findViewById(R.id.btnbackCategory);


    }
    public  void setup()
    {
        categoryList = new ArrayList<>();
        adapter = new TheloaiAdapter(this, categoryList);
        recyclerView.setAdapter(adapter);
    }

    //ham lay du lieu tren json

    private class LayCategory extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String kq= "";

            try {


                URL url = new URL(strings[0]);

                // Kiểm tra yeu cau code
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while((line =bufferedReader.readLine()) !=null)
                {
                    kq +=line;
                }

                //fix loi Data of
                Log.d("HTTP Response",kq);

             // Đóng các thread
                bufferedReader.close();
                inputStream.close();

                //dong ket noi
                httpURLConnection.disconnect();

            }
            // Đóng kết nối
            catch(MalformedURLException i)
            {
                i.printStackTrace();
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
            return kq;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("CateID");
                    String namecate = jsonObject.getString("Catename");

                    categoryList.add(new APIDanhMuc(id,namecate));
                }

                adapter.notifyDataSetChanged();
            }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(The_loai.this, "lỗi " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


}

