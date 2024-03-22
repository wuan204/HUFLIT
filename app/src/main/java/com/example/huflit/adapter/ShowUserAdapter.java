package com.example.huflit.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.huflit.NguoiDungQly;
import com.example.huflit.R;
import com.example.huflit.Update_user;
import com.example.huflit.item.User;

import java.util.ArrayList;
import java.util.List;



public class ShowUserAdapter extends ArrayAdapter<User> {
    private NguoiDungQly context;


    private ArrayList<User> userList;

    public ShowUserAdapter(@NonNull NguoiDungQly context, int resource, @NonNull ArrayList<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.userList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
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
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

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


        viewHolder.btnDelete.setTag(user.getUserid());

        final int pos = position;
        viewHolder.btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Update_user.class);

                intent.putExtra("dataUser",user);
                context.startActivity(intent);



            }
        });

        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId = (int) v.getTag();

                Xacnhanxoa(userId);
            }
        });

        return convertView;
    }


    public  void Xacnhanxoa(int ID)
    {
        AlertDialog.Builder dialogxoa=new AlertDialog.Builder(context);
        dialogxoa.setMessage("Xác nhận xóa user Id:  "+ID+" không");
        dialogxoa.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                context.deleteUser(ID);

            }
        });
        dialogxoa.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogxoa.show();

    }

    private static class ViewHolder {
        TextView txtName, txtRole, txtEmail, txtPass;
        ImageView btnWrite, btnDelete;
    }

}
