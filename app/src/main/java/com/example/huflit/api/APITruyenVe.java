package com.example.huflit.api;

import android.os.AsyncTask;

import com.example.huflit.interfaces.TruyenVe;
import com.example.huflit.viewstory;

import java.io.IOException;
import java.util.concurrent.Executor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APITruyenVe {
    public class TruyenAdapter extends AsyncTask<Void,Void,Void> {
        String data;
        TruyenVe truyenVe;
        String StrID;
        public TruyenAdapter(TruyenVe truyenVe) {
            this.truyenVe = truyenVe;
            this.truyenVe.batDau();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://huf-android.000webhostapp.com/deTail.php?StrID="+StrID)
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
                this.truyenVe.biLoi();
            }
            else
            {
                this.truyenVe.ketThuc(data);
            }
        }
    }

}
