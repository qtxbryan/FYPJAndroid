package com.example.appscanner.fypjandroid.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appscanner.fypjandroid.Model.App;
import com.example.appscanner.fypjandroid.R;

import org.w3c.dom.Text;

import java.util.List;

public class AppAdapter extends ArrayAdapter<App> {

    private Context mCtx;
    private List<App> appList;

    public AppAdapter(List<App> appList,Context mCtx){
        super(mCtx, R.layout.product_list,appList);

        this.mCtx = mCtx;
        this.appList = appList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View listViewItem = inflater.inflate(R.layout.product_list, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textAppName);
        TextView textViewUrl = listViewItem.findViewById(R.id.textAppUrl);
        TextView textViewId = listViewItem.findViewById(R.id.textAppId);
        TextView textViewDev = listViewItem.findViewById(R.id.textAppDevId);

        App app = appList.get(position);

        textViewName.setText(app.getTitle());
        textViewId.setText(app.getApp_id());
        textViewDev.setText(app.getDeveloperID());
        textViewUrl.setText(app.getUrl());

        return listViewItem;

    }




}

