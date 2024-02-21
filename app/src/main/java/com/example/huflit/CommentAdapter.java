package com.example.huflit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mComments;

    public CommentAdapter(Context context, ArrayList<String> comments) {
        super(context, 0, comments);
        mContext = context;
        mComments = comments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_comment_adapter, parent, false);
        }

        String currentComment = mComments.get(position);

        TextView commentTextView = listItem.findViewById(R.id.commentTextView);
        commentTextView.setText(currentComment);

        return listItem;
    }
}

