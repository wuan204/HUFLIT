package com.example.huflit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.huflit.R;
import com.example.huflit.object.Noi_Dung;

import java.util.ArrayList;

public class NoiDungAdapter extends BaseAdapter {

    private Context context;
    private int layout;

    private ArrayList<Noi_Dung> noiDungArrayList;

    public NoiDungAdapter(Context context, ArrayList<Noi_Dung> noiDungList, int layout) {
        this.context = context;
        this.layout = layout;
        this.noiDungArrayList = noiDungList;
    }

    private static class ViewHolder {
        TextView txtTenChap, txtNoiDungChap;
    }

    @Override
    public int getCount() {
        return noiDungArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return noiDungArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder.txtTenChap = view.findViewById(R.id.txtTenChapter);
            viewHolder.txtNoiDungChap = view.findViewById(R.id.txtConTent);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Noi_Dung noi_dung = noiDungArrayList.get(i);

        viewHolder.txtTenChap.setText("Chap: " + noi_dung.getTenChap());
        viewHolder.txtNoiDungChap.setText(noi_dung.getNoiDung());

        return view;
    }
}
