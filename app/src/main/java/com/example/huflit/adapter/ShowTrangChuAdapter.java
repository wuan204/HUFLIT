package com.example.huflit.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.huflit.R;
import com.example.huflit.item.StoryFull;
import com.example.huflit.object.Truyen_tranh;
import com.example.huflit.viewstory;

import java.util.ArrayList;

public class ShowTrangChuAdapter extends RecyclerView.Adapter<TrangChuAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<StoryFull> mDataSet;

    public ShowTrangChuAdapter(Context context, ArrayList<StoryFull> dataSet) {
        this.mContext = context;
        this.mDataSet = dataSet;
    }

    @NonNull
    @Override
    public TrangChuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TrangChuAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}