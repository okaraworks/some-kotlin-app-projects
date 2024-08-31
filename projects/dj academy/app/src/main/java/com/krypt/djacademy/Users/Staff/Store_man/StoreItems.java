package com.krypt.djacademy.Users.Staff.Store_man;

import static com.krypt.djacademy.utils.Urls.GET_STOCK;

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
import com.krypt.djacademy.R;
import com.krypt.djacademy.Users.Staff.Store_man.Adaptor.AdapterStoreItems;
import com.krypt.djacademy.Users.Staff.Store_man.Model.StoreItemModal;
import com.krypt.djacademy.databinding.FragmentHomeBinding;
import com.krypt.djacademy.utils.SessionHandler;
import com.krypt.djacademy.utils.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StoreItems extends AppCompatActivity {
    private FragmentHomeBinding binding;
    private SessionHandler session;
    private UserModel user;
    private List<StoreItemModal> list;
    private AdapterStoreItems adapterProducts;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_items);

        getSupportActionBar().setSubtitle("Store");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        session = new SessionHandler(getApplicationContext());
        user = session.getUserDetails();
        list = new ArrayList<>();
        getProdcuts();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
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

                adapterProducts.getFilter().filter(newText);

                return true;
            }

        });
    }

    public void getProdcuts() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_STOCK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.e("Response", "" + response);
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");

                            if (status.equals("1")) {
                                JSONArray jsonArray = jsonObject.getJSONArray("products");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsn = jsonArray.getJSONObject(i);
                                    String productID = jsn.getString("productID");
                                    String productName = jsn.getString("productName");
                                    String price = jsn.getString("price");
                                    String stock = jsn.getString("stock");
                                    String image = jsn.getString("image");
                                    String desc = jsn.getString("desc");

                                    StoreItemModal productModal = new StoreItemModal(productID, productName, stock, price, image, desc);
                                    list.add(productModal);
                                }
                                progressBar.setVisibility(View.GONE);
                                adapterProducts = new AdapterStoreItems(getApplicationContext(), list);
                                recyclerView.setAdapter(adapterProducts);
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
}