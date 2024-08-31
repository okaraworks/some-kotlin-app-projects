package com.example.amaco.Users.Staff.Store_man.Adaptor;


import static com.example.amaco.utils.Urls.ROOT_URL_IMAGES;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.amaco.KAEWAMODELS.ProductModal;
import com.example.amaco.R;
import com.example.amaco.Users.Staff.Store_man.AddStock;
import com.example.amaco.Users.Staff.Store_man.Model.StoreItemModal;
import com.example.amaco.utils.SessionHandler;
import com.example.amaco.utils.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AdapterStoreItems extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = "Item_adapter";
    ProgressDialog progressDialog;
    private List<StoreItemModal> items;
    private List<StoreItemModal> searchView;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    //
    private OnMoreButtonClickListener onMoreButtonClickListener;
    private SessionHandler session;
    private UserModel user;
    private String clientId = "";
    private String itemID = "";
    private EditText quantity, days;

    public AdapterStoreItems(Context context, List<StoreItemModal> items) {
        this.items = items;
        this.searchView = items;
        ctx = context;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public void setOnMoreButtonClickListener(final OnMoreButtonClickListener onMoreButtonClickListener) {
        this.onMoreButtonClickListener = onMoreButtonClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_store_items, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;

            final StoreItemModal p = items.get(position);
            String url = ROOT_URL_IMAGES;
            Picasso.with(ctx)
                    .load(url + p.getImgUrl())
                    .fit()
                    .centerCrop()
                    .into(view.image);
            view.title.setText(p.getProductName());
            view.txv_capacity.setText("Capacity " + p.getDesc());
            view.txv_stock.setText("In stock " + p.getStock());
            view.price.setText("@ " + p.getPrice() + " KES par day");
            session = new SessionHandler(ctx);
            user = session.getUserDetails();
            try {
                clientId = user.getUserID();
            } catch (RuntimeException e) {

            }

            view.img_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(ctx, AddStock.class);
                    in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    in.putExtra("itemName", p.getProductName());
                    in.putExtra("stock", p.getStock());
                    in.putExtra("stockID", p.getProductID());

                    ctx.startActivity(in);
                }
            });
        }
    }

    public void progressShow() {
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setMessage(" Please wait...");
        progressDialog.setTitle("Adding to cart... ");
        progressDialog.show();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    items = searchView;
                } else {

                    ArrayList<StoreItemModal> filteredList = new ArrayList<>();

                    for (StoreItemModal androidVersion : items) {

                        if (androidVersion.getProductName().toLowerCase().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    items = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = items;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                items = (ArrayList<StoreItemModal>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface OnItemClickListener {
        void onItemClick(View view, ProductModal obj, int pos);
    }

    public interface OnMoreButtonClickListener {
        void onItemClick(View view, ProductModal obj, MenuItem item);
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image, img_edit;
        public TextView title, txv_stock, txv_capacity;
        public TextView price;


        public OriginalViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image_c);
            img_edit = v.findViewById(R.id.img_edit);
            title = v.findViewById(R.id.txv_title);
            txv_stock = v.findViewById(R.id.txv_stock);
            txv_capacity = v.findViewById(R.id.txv_capacity);
            price = v.findViewById(R.id.txv_price_c);

        }
    }


}