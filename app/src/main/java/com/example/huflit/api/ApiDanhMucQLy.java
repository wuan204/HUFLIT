package com.example.huflit.api;

import android.os.AsyncTask;

import com.example.huflit.interfaces.LayDanhMucVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiDanhMucQLy extends AsyncTask<Void,Void,Void> {
    String data;
    LayDanhMucVe layDanhMucVe;
    public ApiDanhMucQLy(LayDanhMucVe layDanhMucVe) {
        this.layDanhMucVe = layDanhMucVe;
        this.layDanhMucVe.batDau();

    }


    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://huf-android.000webhostapp.com/QLyDanhMuc.php")
                .build();
        data = null;
        try
        {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        }catch (IOException e){
            data = null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(data == null)
        {
            this.layDanhMucVe.biLoi();
        }
        else
        {
            this.layDanhMucVe.ketThuc(data);
        }
    }
}
