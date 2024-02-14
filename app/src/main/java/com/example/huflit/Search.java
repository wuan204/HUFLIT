package com.example.huflit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.huflit.adapter.TruyenTranhAdapter;
import com.example.huflit.api.APILayTruyenVe;
import com.example.huflit.truyen_tranh.Truyen_tranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.JarException;

import com.example.huflit.interfaces.LayTruyenVe;

public class Search extends AppCompatActivity  implements LayTruyenVe {
    GridView gridTruyenTranh;
    TruyenTranhAdapter adapter;
    ArrayList<Truyen_tranh> truyenTranhArrayList;
    EditText edtTimKiem;
    ImageView imgBack,imgSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        anhXa();
        setUp();
        setClick();
        new APILayTruyenVe(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();


        adapter = new TruyenTranhAdapter(this,0, truyenTranhArrayList);
    }
    private void anhXa(){
        gridTruyenTranh = findViewById(R.id.gridTruyenTranh);
        edtTimKiem = findViewById(R.id.edtTimKiem);
        imgBack = findViewById(R.id.imgBack);
        imgSearch = findViewById(R.id.imgSearch);
    }
    private void setUp(){
        gridTruyenTranh.setAdapter(adapter);

    }
    private void setClick(){
edtTimKiem.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
       String s = edtTimKiem.getText().toString();
       adapter.sortTruyen(s);
    }
    });
imgBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});

    }

    @Override
    public void batDau() {
        Toast.makeText(this, "Dang lay ve", Toast.LENGTH_LONG).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            truyenTranhArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for(int i=0;i<arr.length();i++){
                JSONObject o= arr.getJSONObject(i);
                truyenTranhArrayList.add(new Truyen_tranh(o));
            }
            adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
            gridTruyenTranh.setAdapter(adapter);
        }catch (JSONException | JarException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Loi ket noi", Toast.LENGTH_LONG).show();
    }
}