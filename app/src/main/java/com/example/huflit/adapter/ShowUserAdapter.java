package com.example.huflit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huflit.R;
import com.example.huflit.item.User;

import java.util.ArrayList;
import java.util.List;

public class ShowUserAdapter extends ArrayAdapter<User> {
    private Context context;
    private ArrayList<User> userList;

    private class ViewHolder {
        TextView txtName, txtRole, txtEmail, txtPass;
        ImageView btnWrite, btnDelete;
    }

    public ShowUserAdapter(Context context, int resource, List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.userList = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtName = convertView.findViewById(R.id.txtnameuser);
            viewHolder.txtRole = convertView.findViewById(R.id.txtrole);
            viewHolder.txtEmail = convertView.findViewById(R.id.txtemail);
            viewHolder.txtPass = convertView.findViewById(R.id.txtpass);
            viewHolder.btnWrite = convertView.findViewById(R.id.btnwriteuser);
            viewHolder.btnDelete = convertView.findViewById(R.id.btndeleteuser);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (userList != null && userList.size() > position) {
            User user = userList.get(position);
            viewHolder.txtName.setText(user.getName());
            viewHolder.txtEmail.setText(user.getEmail());
            viewHolder.txtPass.setText(user.getPass());
            if (user.getRole() == 1) {
                viewHolder.txtRole.setText("Viewer");
            } else if (user.getRole() == 2) {
                viewHolder.txtRole.setText("Author");
            } else if (user.getRole() == 3) {
                viewHolder.txtRole.setText("Admin");
            }
        }
        viewHolder.btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút write được click
                Log.d("ShowUserAdapter", "Write button clicked at position: " + position);
            }
        });

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút delete được click
                Log.d("ShowUserAdapter", "Delete button clicked at position: " + position);
            }
        });

        return convertView;
    }}
