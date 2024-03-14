package com.example.huflit.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huflit.item.StoryFull;
import com.example.huflit.object.NoiDung;

import java.util.ArrayList;

public class NoiDungAdapter extends RecyclerView.Adapter<NoiDungAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<NoiDung> mDataSet;

    public NoiDungAdapter(Context mContext, ArrayList<NoiDung> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public NoiDungAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NoiDungAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
