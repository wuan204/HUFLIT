package com.example.huflit.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.huflit.Content;
import com.example.huflit.R;
import com.example.huflit.item.Chapter;

import java.util.ArrayList;

public class ShowListChapterAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Chapter> arrayList;
    private LayoutInflater inflater;
    private  int idlayout;
    private  static class Viewholder{TextView txtname;}

    public ShowListChapterAdapter(Context context, ArrayList<Chapter> arrayList, int idlayout) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = LayoutInflater.from(context);
        this.idlayout=idlayout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if(convertView==null){
            convertView =inflater.inflate(idlayout,parent,false);
            viewholder=new Viewholder();
            viewholder.txtname=convertView.findViewById(R.id.txtChapname);
            convertView.setTag(viewholder);
        }
        else {viewholder=(Viewholder) convertView.getTag();}
        Chapter item=arrayList.get(position);
        viewholder.txtname.setText(item.getName());
        return convertView;
    }
}
