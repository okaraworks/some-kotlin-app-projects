package com.example.jantech.KAEWA_ADPTS;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jantech.KAEWAMODELS.FeedbackModel;
import com.example.jantech.R;
import com.example.jantech.utils.SessionHandler;
import com.example.jantech.utils.UserModel;

import java.util.List;

public class AdapterFeedback extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = "Events";
    ProgressDialog progressDialog;
    private List<FeedbackModel> items;
    private Context ctx;
    private SessionHandler session;
    private UserModel user;

    public AdapterFeedback(Context context, List<FeedbackModel> items) {
        this.items = items;
        ctx = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lv_feedback, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;

            final FeedbackModel p = items.get(position);
            view.txv_comment.setText(p.getComment());
            if (p.getReply().equals("0")) {
                view.txv_reply.setVisibility(View.GONE);
            } else {
                view.txv_reply.setText(p.getReply());
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        public TextView txv_comment, txv_reply;

        public OriginalViewHolder(View v) {
            super(v);

            txv_comment = v.findViewById(R.id.txv_comment);
            txv_reply = v.findViewById(R.id.txv_reply);

            session = new SessionHandler(ctx);
            user = session.getUserDetails();

        }
    }
}