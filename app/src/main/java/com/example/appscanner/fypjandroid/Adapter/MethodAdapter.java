package com.example.appscanner.fypjandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appscanner.fypjandroid.Model.Method;
import com.example.appscanner.fypjandroid.R;

import org.w3c.dom.Text;

import java.util.List;

public class MethodAdapter extends ArrayAdapter<Method> {

    private Context mCtx;
    private List<Method> methodList;

    public MethodAdapter(List<Method> methodList, Context mCtx){

        super(mCtx, R.layout.method_list, methodList);
        this.methodList = methodList;
        this.mCtx = mCtx;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View listViewItem = inflater.inflate(R.layout.method_list, null, true);

        TextView methodName = (TextView) listViewItem.findViewById(R.id.textViewMethodName);

        Method method= methodList.get(position);

        methodName.setText(method.getName());

        return listViewItem;
    }
}
