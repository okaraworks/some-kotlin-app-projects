package com.example.panafrica.Users.Customers.Adaptors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.panafrica.R;
import com.example.panafrica.Users.Customers.BookingItems;
import com.example.panafrica.Users.Customers.Model.ModalBook;
import com.example.panafrica.utils.SessionHandler;
import com.example.panafrica.utils.UserModel;

import java.util.List;

public class AdapterBookings extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = "Orders adapter";
    ProgressDialog progressDialog;
    private List<ModalBook> items;
//    private OnItemClickListener mOnItemClickListener;
//    private OnMoreButtonClickListener onMoreButtonClickListener;

    //
    private Context ctx;
    private SessionHandler session;
    private UserModel user;
    private String clientId = "";
    private String orderID = "";


    public AdapterBookings(Context context, List<ModalBook> items) {
        this.items = items;
        ctx = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_bookings, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;

            final ModalBook o = items.get(position);

            view.txv_bookingID.setText("Payment No " + o.getBookingID());
            view.txv_cash.setText("Cash " + o.getBookingCost() + " KES");
            view.txv_mpesaCode.setText("Mpesa code " + o.getMpesaCode());
            view.txv_bookingDate.setText("Date " + o.getBookingDate());
            view.txv_bookingStatus.setText("Status " + o.getBookingStatus());
            view.txv_dateToDeliver.setText("Delivery date " + o.getDateToDeliver());

            view.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent in = new Intent(ctx, BookingItems.class);
                    in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    in.putExtra("bookingID", o.getBookingID());
                    in.putExtra("bookingCost", o.getBookingCost());
                    in.putExtra("mpesaCode", o.getMpesaCode());
                    in.putExtra("bookingDate", o.getBookingDate());
                    in.putExtra("bookingStatus", o.getBookingStatus());
                    in.putExtra("dateToDeliver", o.getDateToDeliver());
                    in.putExtra("deliveryCost", o.getDeliveryCost());

                    ctx.startActivity(in);


                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        public TextView txv_bookingID, txv_cash, txv_bookingDate;
        public TextView txv_mpesaCode, txv_bookingStatus, txv_dateToDeliver;


        public OriginalViewHolder(View v) {
            super(v);

            txv_mpesaCode = v.findViewById(R.id.txv_mpesaCode);
            txv_bookingDate = v.findViewById(R.id.txv_bookingDate);
            txv_bookingID = v.findViewById(R.id.txv_bookingID);
            txv_bookingStatus = v.findViewById(R.id.txv_bookingStatus);
            txv_cash = v.findViewById(R.id.txv_cash);
            txv_dateToDeliver = v.findViewById(R.id.txv_dateToDeliver);

        }
    }

//    public interface OnItemClickListener {
//        void onItemClick(View view, ProductModal obj, int pos);
//    }
//
//    public interface OnMoreButtonClickListener {
//        void onItemClick(View view, ProductModal obj, MenuItem item);
//    }


}