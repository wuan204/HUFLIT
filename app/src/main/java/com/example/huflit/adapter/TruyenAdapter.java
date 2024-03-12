package com.example.huflit.adapter;

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


import com.bumptech.glide.Glide;
import com.example.huflit.R;
import com.example.huflit.object.Truyen;

import java.util.ArrayList;
import java.util.List;

public class TruyenAdapter extends ArrayAdapter<Truyen> {
    private Context ct;
    private ArrayList<Truyen> arr;
    public TruyenAdapter( Context context, int resource, List<Truyen> objects) {
        super(context, resource, objects);
        this.ct =context;
        this.arr = new ArrayList<>(objects);

    }
    @SuppressLint("WrongViewCast")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_viewstory,null);

        }
        if(arr.size()>0){
            Truyen truyen = this.arr.get(position);

             TextView StrName = convertView.findViewById(R.id.txtStrName);
            TextView Alias = convertView.findViewById(R.id.txtAlias);
            TextView StrStatus = convertView.findViewById(R.id.txtStt);
            TextView StrView = convertView.findViewById(R.id.txtViewNumber);
            TextView StrLove = convertView.findViewById(R.id.txtLoveNumber);
            TextView Descrip = convertView.findViewById(R.id.txtDescipt);
            ImageView StrImage = convertView.findViewById(R.id.imgStory);


            StrName.setText(truyen.getTenTruyen());
            Alias.setText(truyen.getAuthor());
            StrStatus.setText(truyen.getTrangThai());
            StrLove.setText(truyen.getLove());
            StrView.setText(truyen.getViewer());
            Descrip.setText(truyen.getTomTat());
            Glide.with(this.ct).load(truyen.getLinkAnh()).into(StrImage);

        }
        return convertView;
    }
}
