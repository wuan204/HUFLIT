package com.example.huflit.api;

import android.os.AsyncTask;

import java.io.IOException;

import com.example.huflit.interfaces.LayTruyenVe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APILayTruyenVe extends AsyncTask<Void, Void, String> {
    String data;
    LayTruyenVe LayTruyenVe;

    public APILayTruyenVe(LayTruyenVe layTruyenVe) {
        this.LayTruyenVe = layTruyenVe;
        this.LayTruyenVe.batDau();
    }


    @Override
    protected String doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //.url("https://api.jsonserve.com/JdMKAx")
                .url("https://huf-android.000webhostapp.com/layTruyen.php")
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        } catch (IOException e) {
            data = null;
        }
        return data;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result == null) {
            this.LayTruyenVe.biLoi();
        } else {
            this.LayTruyenVe.ketThuc(result);
        }
    }
}
