package com.example.appscanner.fypjandroid.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appscanner.fypjandroid.Model.PermissionExist;
import com.example.appscanner.fypjandroid.R;

import java.util.List;

public class PermissionExistAdapter extends ArrayAdapter<PermissionExist> {

    private Context mCtx;
    private List<PermissionExist> permList;

    public PermissionExistAdapter(List<PermissionExist> permList, Context mCtx){
        super(mCtx, R.layout.product_list,permList);
        this.permList = permList;
        this.mCtx = mCtx;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View listViewItem = inflater.inflate(R.layout.perm_exist_list, null, true);

        TextView textViewId = listViewItem.findViewById(R.id.textViewId);
        TextView textViewPermName = listViewItem.findViewById(R.id.textViewPermName);
        TextView textViewProtectLevel = listViewItem.findViewById(R.id.textViewProtectLevel);

        PermissionExist permExist = permList.get(position);

        textViewId.setText(permExist.getAppId());
        textViewPermName.setText(permExist.getPermName());
        textViewProtectLevel.setText(permExist.getProtectLevel());


        return listViewItem;

    }
}

