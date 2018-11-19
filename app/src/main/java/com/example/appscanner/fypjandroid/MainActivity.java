package com.example.appscanner.fypjandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.appscanner.fypjandroid.Adapter.AppAdapter;
import com.example.appscanner.fypjandroid.Adapter.PermissionExistAdapter;
import com.example.appscanner.fypjandroid.Constant.Constant;
import com.example.appscanner.fypjandroid.Model.App;
import com.example.appscanner.fypjandroid.Model.PermissionExist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //a list to store all the products
    List<App> productList;
    List<PermissionExist> permExistList;
    //the recyclerview
    ListView listView;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        listView1 = (ListView) findViewById(R.id.secondList);

        productList = new ArrayList<>();
        permExistList = new ArrayList<>();

        Bundle bn = getIntent().getExtras();
        String id = bn.getString("appid");

        //this method will fetch and parse json
        //to display it in recyclerview
        Log.e("ID", id);
        loadProducts(id);
        loadPermExist(id);
    }

    private void loadPermExist(String id){

        String link = Constant.URL_READ_EXIST_PERM +id;

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);

                        try{

                            JSONObject obj = new JSONObject(response);
                            JSONArray detailArray = obj.getJSONArray("details");

                            for(int i =0; i<detailArray.length();i++){

                                JSONObject detailObject = detailArray.getJSONObject(i);

                                PermissionExist permExist = new PermissionExist(detailObject.getString("app_id"),
                                        detailObject.getString("permName"),
                                        detailObject.getString("protectLevel"));

                                permExistList.add(permExist);

                            }

                            PermissionExistAdapter adapter = new PermissionExistAdapter(permExistList, getApplicationContext());

                            listView1.setAdapter(adapter);
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }

    private void loadProducts(String id) {

        String link = Constant.URL_READ_APP+id;

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, link,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray heroArray = obj.getJSONArray("details");

                            for (int i = 0; i < heroArray.length(); i++) {

                                JSONObject heroObject = heroArray.getJSONObject(i);

                                App app = new App(heroObject.getString("app_id"),
                                        heroObject.getString("title"),
                                        heroObject.getString("url"),
                                        heroObject.getString("developerID"),
                                        heroObject.getString("date_scraped"));

                                productList.add(app);
                            }

                            AppAdapter adapter = new AppAdapter(productList, getApplicationContext());

                            listView.setAdapter(adapter);
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
}
