package com.krypt.promokings;

import static com.krypt.promokings.utils.Urls.URL_FEEDBACK;
import static com.krypt.promokings.utils.Urls.URL_SEND_FEEDBACK;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.krypt.promokings.PROMOKINGSMODELS.FeedbackModel;
import com.krypt.promokings.PROMOKINGS_ADPTS.AdapterFeedback;
import com.krypt.promokings.utils.SessionHandler;
import com.krypt.promokings.utils.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackServiceManager extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<FeedbackModel> list;
    private AdapterFeedback adapterFeedback;
    private SessionHandler session;
    private UserModel user;
    private EditText edt_feedback;
    private Button btn_feedback;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_service);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Service manager");
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        btn_feedback = findViewById(R.id.btn_feedback);
        edt_feedback = findViewById(R.id.edt_feedback);
//        progressBar=findViewById(R.id.progressBar);
//        progressBar.setVisibility(View.GONE);
        session = new SessionHandler(getApplicationContext());
        user = session.getUserDetails();
        list = new ArrayList<FeedbackModel>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

//
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        getFeedback();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //finish();
            startActivity(new Intent(FeedbackServiceManager.this,MainActivity.class));
            finish();
        }else if(item.getItemId() == R.id.fin){
            Toast.makeText(this, " Feed back to Finance", Toast.LENGTH_LONG).show();
            startActivity(new Intent(FeedbackServiceManager.this, FeedbackActivity.class));


        }
        else if(item.getItemId() == R.id.serv_man){
            Toast.makeText(this, "already in chat with service manager", Toast.LENGTH_LONG).show();


        }
        return super.onOptionsItemSelected(item);
    }

    public void getFeedback() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_FEEDBACK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("RESPONSE", response);
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String msg = jsonObject.getString("message");
                            if (status.equals("1")) {
                                list.clear();
                                JSONArray jsonArray = jsonObject.getJSONArray("details");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsn = jsonArray.getJSONObject(i);
                                    String comment = jsn.getString("comment");
                                    String reply = jsn.getString("reply");

                                    FeedbackModel feedbackModel = new FeedbackModel(comment, reply);
                                    list.add(feedbackModel);
                                }
                                adapterFeedback = new AdapterFeedback(getApplicationContext(), list);
                                recyclerView.setAdapter(adapterFeedback);
                                progressBar.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(FeedbackServiceManager.this, msg, Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(FeedbackServiceManager.this, e.toString(), Toast.LENGTH_SHORT).show();
                            Log.e("ERROR 1", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(FeedbackServiceManager.this, error.toString(), Toast.LENGTH_SHORT).show();
                Log.e("ERROR 2", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("userID", user.getUserID());
                Log.e("PARAMS", "" + params);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }

    @Override
    public void onRestart() {
        super.onRestart();
        fileList();
        startActivity(getIntent());
    }

    public void send() {
        progressBar.setVisibility(View.VISIBLE);
        btn_feedback.setVisibility(View.GONE);
        final String feedback = edt_feedback.getText().toString().trim();

        if (TextUtils.isEmpty(feedback)) {
            Toast.makeText(getApplicationContext(), "Enter a comment to continue", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            btn_feedback.setVisibility(View.VISIBLE);
            return;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SEND_FEEDBACK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("RESPONSE", response);
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String msg = jsonObject.getString("message");
                            if (status.equals("1")) {
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                                edt_feedback.setText("");
                                progressBar.setVisibility(View.GONE);
                                btn_feedback.setVisibility(View.VISIBLE);
                                getFeedback();
                            } else {
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                                progressBar.setVisibility(View.GONE);
                                btn_feedback.setVisibility(View.VISIBLE);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            btn_feedback.setVisibility(View.VISIBLE);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                btn_feedback.setVisibility(View.VISIBLE);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("feedback", feedback);
                params.put("userID", user.getUserID());
                Log.e("PARAMS", "" + params);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feedback_dropdown,menu);
        return  true;
    }

}
