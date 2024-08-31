package com.krypt.MALO.Users.Staff.Finance;

import static com.krypt.MALO.utils.Urls.URL_PENDING_BOOKINGS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.krypt.MALO.R;
import com.krypt.MALO.Users.Staff.Adaptor.AdptBookings;
import com.krypt.MALO.Users.Staff.Modal.BookingModal;
import com.krypt.MALO.utils.SessionHandler;
import com.krypt.MALO.utils.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewBookings extends AppCompatActivity {
    private SessionHandler session;
    private UserModel user;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private List<BookingModal> list;
    private AdptBookings adptBookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bookings);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);

        bookings();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    private void bookings() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PENDING_BOOKINGS,
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
                                    String name = jsn.getString("name");
                                    String bookingCost = jsn.getString("bookingCost");
                                    String mpesaCode = jsn.getString("mpesaCode");
                                    String bookingDate = jsn.getString("bookingDate");
                                    String dateToDeliver = jsn.getString("dateToDeliver");
                                    String bookingStatus = jsn.getString("bookingStatus");
                                    String deliveryCost = jsn.getString("deliveryCost");
                                    String county = jsn.getString("county");
                                    String town = jsn.getString("town");
                                    String bookingRemarks = jsn.getString("bookingRemarks");

                                    BookingModal b = new BookingModal(bookingID, name, bookingCost,
                                            mpesaCode, bookingDate, bookingStatus, deliveryCost, dateToDeliver,
                                            county, town, bookingRemarks);
                                    list.add(b);
                                }
                                adptBookings = new AdptBookings(getApplicationContext(), list);
                                recyclerView.setAdapter(adptBookings);
                                progressBar.setVisibility(View.GONE);
                            } else if (status.equals("0")) {
                                progressBar.setVisibility(View.GONE);

                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_bar, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adptBookings.getFilter().filter(newText);

                return true;
            }

        });
    }
}