package com.example.huflit.adapter;

import static com.example.huflit.R.layout.item_truyentranh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.huflit.R;

import com.example.huflit.object.Truyen;
import com.example.huflit.object.Truyen_tranh;
import com.example.huflit.viewstory;




public class TruyenTranhAdapter extends ArrayAdapter<Truyen_tranh> {

    private Context ct;
    private ArrayList<Truyen_tranh> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<Truyen_tranh> objects) {
        super(context, resource, objects);

        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }


    public void sortTruyen(String s){
 s = s.toUpperCase();
 int k = 0;
 for(int i =0;i< arr.size();i++){
     Truyen_tranh  t = arr.get(i);
     String ten  = t.getTenTruyen().toUpperCase();
     if (ten.indexOf(s)>=0){
         arr.set(i,arr.get(k));
         arr.set(k, t);
         k++;
     }
 }
 notifyDataSetChanged();
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_truyentranh, null);
        }

        if (arr.size() > 0) {
            Truyen_tranh truyenTranh = arr.get(position);
            TextView tenTenTruyen = convertView.findViewById(R.id.tentruyentrangchu);
            ImageView imgBia = convertView.findViewById(R.id.anhbiatrangchu);
            tenTenTruyen.setText(truyenTranh.getTenTruyen());
            Glide.with(this.ct).load(truyenTranh.getLinkAnh()).into(imgBia);
        }

        return convertView;
    }

}
