package com.example.huflit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huflit.R;
import com.example.huflit.object.DanhMucQly;

import java.util.ArrayList;
import java.util.List;

public class DanhMucQLyAdapter extends ArrayAdapter<DanhMucQly> {
    private Context ct;
    private ArrayList<DanhMucQly> arr;
    private class Viewholder{
        TextView IdDanhMuc,CateName;
        ImageView write,delete;
    }
    public DanhMucQLyAdapter( Context context, int resource, List<DanhMucQly> objects) {
        super(context, resource, objects);
        this.ct =context;
        this.arr = new ArrayList<>(objects);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(ct);
            convertView = inflater.inflate(R.layout.items_danhmucqly, parent, false);
            viewholder = new Viewholder();
            viewholder.CateName = convertView.findViewById(R.id.CateName);
            viewholder.write = convertView.findViewById(R.id.btnwrite);
            viewholder.delete = convertView.findViewById(R.id.btndelete);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        if (arr.size() > 0) {
            DanhMucQly chuongSach = arr.get(position);
            viewholder.CateName.setText(chuongSach.getTenDanhMuc());
            viewholder.write.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            viewholder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        return convertView;
    }
}
