package com.example.huflit.itemfilter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.huflit.R;

import java.util.List;

public class ADTFilterGrV extends BaseAdapter {
    static class ViewHolder {
        CheckBox checkBox;
        TextView textViewName;
    }
    private Context context;
    private List<Itemft> mItems;
    private LayoutInflater layoutInflater;

    public ADTFilterGrV(Context context, List<Itemft> mItems, LayoutInflater layoutInflater) {
        this.context = context;
        this.mItems = mItems;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView =layoutInflater.inflate(R.layout.grviewf_filteritem,null);
            viewHolder=new ViewHolder();
            viewHolder.checkBox= convertView.findViewById(R.id.ckbitem);
            viewHolder.textViewName= convertView.findViewById(R.id.txtNameckb);
            convertView.setTag(viewHolder);
        } else { viewHolder=(ViewHolder) convertView.getTag();}
        //
        Itemft item=this.mItems.get(position);
        viewHolder.checkBox.setChecked(item.isChecked());
        viewHolder.textViewName.setText(item.getNameitem());
        return convertView;

    }
}

