//package com.example.huflit.api;
//
//import android.os.AsyncTask;
//
//import java.io.IOException;
//
//import com.example.huflit.Trang_Chu;
//import com.example.huflit.interfaces.LayTruyenVe;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.ResponseBody;
//
//public class APILayTruyenVe extends AsyncTask<Void, Void, Void> {
//    String data;
//    LayTruyenVe layTruyenVe;
//    public APILayTruyenVe(LayTruyenVe layTruyenVe){
//        this.layTruyenVe = layTruyenVe;
//        this.layTruyenVe.batDau();
//    }
//
//    @Override
//    protected Void doInBackground(Void... voids) {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("https://huf-android.000webhostapp.com/Search.php")
//                .build();
//        data = null;
//        try {
//            Response response = client.newCall(request).execute();
//            ResponseBody body = response.body();
//            data= body.string();
//
//        }catch (IOException e) {
//            data = null;
//        }
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        if(data == null){
//            this.layTruyenVe.biLoi();
//        }
//    else {
//        this.layTruyenVe.ketThuc(data);
//        }
//    }
//}
