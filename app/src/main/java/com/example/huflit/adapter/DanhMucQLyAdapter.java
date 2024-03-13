package com.example.huflit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.huflit.R;
import com.example.huflit.object.DanhMucQly;

import java.util.ArrayList;
import java.util.List;

public class DanhMucQLyAdapter extends ArrayAdapter<DanhMucQly> {
    private Context ct;
    private ArrayList<DanhMucQly> arr;
    public DanhMucQLyAdapter( Context context, int resource, List<DanhMucQly> objects) {
        super(context, resource, objects);
        this.ct =context;
        this.arr = new ArrayList<>(objects);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.items_danhmucqly,null);

        }
        if(arr.size()>0){
            TextView IdDanhMuc,CateName;
            IdDanhMuc =convertView.findViewById(R.id.IdDanhMuc);
            CateName =convertView.findViewById(R.id.CateName);

            DanhMucQly chuongSach = arr.get(position);
            IdDanhMuc.setText(chuongSach.getId());
            CateName.setText(chuongSach.getTenDanhMuc());

        }
        return convertView;
    }
}
