package com.example.fireapp;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Users> {

    List<Users> mArrayListUser;
    Context mContext;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Users> objects) {
        super(context, resource, objects);
        mArrayListUser = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        Users user = getItem(position);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.userName = (TextView)convertView.findViewById(R.id.textViewUserName);
            viewHolder.address = (TextView)convertView.findViewById(R.id.textViewAddress);
            viewHolder.age = (TextView) convertView.findViewById(R.id.textViewAge);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.userName.setText(user.getName());
        viewHolder.address.setText(user.getAddres());
        viewHolder.age.setText(user.getAge());

        return convertView;
    }

    static class ViewHolder{
        TextView userName, address, age;
    }
}
