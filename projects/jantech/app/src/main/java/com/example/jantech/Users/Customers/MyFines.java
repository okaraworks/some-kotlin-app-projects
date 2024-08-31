package com.example.jantech.Users.Customers;

import static com.example.jantech.utils.Urls.URL_GET_MY_FINES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jantech.R;
import com.example.jantech.Users.Customers.Adaptors.AdptMyFines;
import com.example.jantech.Users.Customers.Model.MyFinesModel;
import com.example.jantech.utils.SessionHandler;
import com.example.jantech.utils.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFines extends AppCompatActivity {
    private List<MyFinesModel> list;
    private AdptMyFines adptMyFines;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private SessionHandler session;
    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fines);


        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        getSupportActionBar().setSubtitle("Fines");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionHandler(getApplicationContext());
        user = session.getUserDetails();

        list = new ArrayList<>();


        getFines();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void getFines() {
        Toast.makeText(this,user.getUserID(), Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.DEPRECATED_GET_OR_POST,URL_GET_MY_FINES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Log.e("RESPONSE ", " " + response);
                            String status = jsonObject.getString("status");
                            String msg = jsonObject.getString("message");
                            if (status.equals("1")) {
                                JSONArray jsonArray = jsonObject.getJSONArray("details");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsn = jsonArray.getJSONObject(i);
                                    String bookingID = jsn.getString("bookingID");
                                    String penaltyID = jsn.getString("penaltyID");
                                    String fineStatus = jsn.getString("fineStatus");
                                    String remarks = jsn.getString("remarks");
                                    String amount = jsn.getString("amount");
                                    String mpesaCode = jsn.getString("mpesaCode");

                                    MyFinesModel finesModel = new MyFinesModel(bookingID, penaltyID, amount, mpesaCode,
                                            remarks, fineStatus);
                                    list.add(finesModel);

                                }
                                recyclerView.setAdapter(adptMyFines);
                                adptMyFines = new AdptMyFines(getApplicationContext(), list);


                                progressBar.setVisibility(View.GONE);
                            } else if (status.equals("0")) {
                                progressBar.setVisibility(View.GONE);

                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("ERROR e", e.toString());
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("ERROR error", error.toString());
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AbstractMethodError {
                Map<String, String> params = new HashMap<>();
                params.put("userID",user.getUserID());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }

    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}