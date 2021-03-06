package com.example.appscanner.fypjandroid.Adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appscanner.fypjandroid.MethodActivity;
import com.example.appscanner.fypjandroid.Model.Permission;
import com.example.appscanner.fypjandroid.R;

import java.lang.reflect.Array;
import java.util.List;

public class PermissionAdapter extends ArrayAdapter<Permission> {

    private Context mCtx;
    private List<Permission> permList;

    public PermissionAdapter(List<Permission> permList, Context mCtx){

        super(mCtx, R.layout.permission_list, permList);
        this.permList = permList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View listViewItem = inflater.inflate(R.layout.permission_list, null, true);

        TextView textViewPermName = listViewItem.findViewById(R.id.textViewPermName);
        TextView textViewId = listViewItem.findViewById(R.id.textViewPermId);
        TextView textViewProtectLevel = listViewItem.findViewById(R.id.textViewProtectLevel);



        final Permission perm = permList.get(position);
        final String permId = perm.getPerm_id();

        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCtx, MethodActivity.class);
                intent.putExtra("perm_id", permId);
                Log.i("PERM ID IS ", permId);
                mCtx.startActivity(intent);

            }
        });

        textViewPermName.setText(perm.getName());
        textViewId.setText(perm.getPerm_id());

        String protectId = perm.getProtect_id();
        String protectLevel = "";

        if(protectId == "1"){

            protectLevel = "Dangerous";
            listViewItem.setBackgroundColor(Color.YELLOW);
        }else if (protectId == "2"){

            protectLevel = "Normal";
            listViewItem.setBackgroundColor(Color.GREEN);
        }else if (protectId == "3"){

            protectLevel = "Signature";
            listViewItem.setBackgroundColor(Color.RED);
        }
        textViewProtectLevel.setText(protectLevel);




        return listViewItem;

    }


}

