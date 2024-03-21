package com.example.huflit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.huflit.R;
import com.example.huflit.item.itemIMG;

import java.util.List;

public class ContentImgAdapter extends BaseAdapter {
    private Context context;
    private List<itemIMG> urllist;

    public ContentImgAdapter(Context context, List<itemIMG> list) {
        this.context = context;
        this.urllist = list;
    }

    @Override
    public int getCount() {
        return urllist.size();
    }

    @Override
    public Object getItem(int position) {
        return urllist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_img, parent, false);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.imgitem);
            convertView.setTag(holder);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        itemIMG imglink = urllist.get(position);
        Glide.with(context).load(imglink.getLink()).placeholder(R.drawable.update).into(holder.img);
        return convertView;
    }

    private static class ViewHolder {
        ImageView img;
    }
}
