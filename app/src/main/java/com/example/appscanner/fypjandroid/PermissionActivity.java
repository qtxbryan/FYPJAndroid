package com.example.appscanner.fypjandroid;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appscanner.fypjandroid.Adapter.PermissionAdapter;
import com.example.appscanner.fypjandroid.Constant.Constant;
import com.example.appscanner.fypjandroid.Model.Permission;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    List<Permission> permList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        listView = (ListView) findViewById(R.id.listViewPermission);

        permList = new ArrayList<>();


        loadPermission();

    }

    private void loadPermission(){

        String link = Constant.URL_READ_PERM;

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);

                        try {

                            JSONObject obj = new JSONObject(response);
                            JSONArray detailArray = obj.getJSONArray("details");

                            for (int i = 0; i < detailArray.length(); i++) {

                                JSONObject detailObject = detailArray.getJSONObject(i);

                                Permission permExist = new Permission(detailObject.getString("perm_id"),
                                        detailObject.getString("name"),
                                        detailObject.getString("protect_id"));

                                permList.add(permExist);
                            }

                            PermissionAdapter adapter = new PermissionAdapter(permList, getApplicationContext());

                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
}

