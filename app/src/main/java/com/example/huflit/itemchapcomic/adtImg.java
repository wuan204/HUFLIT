package com.example.huflit.itemchapcomic;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.huflit.R;
import com.example.huflit.itemfilter.Itemft;

import java.util.ArrayList;


public class adtImg extends BaseAdapter{ private Context mContext;
    private ArrayList<itemimg> mImageUri;
    static class ViewHolder {
        ImageView imageView;
        ImageView btnXoa;
    }
    public adtImg(Context context,ArrayList<itemimg> mImageUri) {
        mContext = context;
        this.mImageUri=mImageUri;
    }
    public void removeItem(int position) {
        mImageUri.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mImageUri.size();
    }

    @Override
    public Object getItem(int position) {
        return mImageUri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grvimgchap, parent, false);
            holder=new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgGrV);
            holder.btnXoa=(ImageView) convertView.findViewById(R.id.btDeleteimg) ;
            holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(600,600));
            holder.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            convertView.setTag(holder);
        } else {
            holder=(ViewHolder) convertView.getTag();
        }
        itemimg current =mImageUri.get(position);
        holder.imageView.setImageURI(current.getImg());
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
        return convertView;
    }
}

