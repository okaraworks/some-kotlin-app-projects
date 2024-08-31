package com.example.jantech.Users.Customers;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jantech.MainActivity;
import com.example.jantech.R;
import com.example.jantech.utils.SessionHandler;
import com.example.jantech.utils.UserModel;

public class ProfileFragment extends Fragment {

    private SessionHandler session;
    private UserModel user;
    private TextView txv_name, txv_phoneNo, txv_email,
            txv_username;
    private Button btn_logout, btn_fine;
    ;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.profile_fragment, container, false);

        txv_name = root.findViewById(R.id.txv_name);
        txv_username = root.findViewById(R.id.txv_username);
        txv_phoneNo = root.findViewById(R.id.txv_phoneNo);
        txv_email = root.findViewById(R.id.txv_email);
        btn_logout = root.findViewById(R.id.btn_logout);



        try {
            session = new SessionHandler(getActivity());
            user = session.getUserDetails();

            txv_email.setText(user.getEmail());
            txv_name.setText(user.getFirstname() + " " + user.getLastname());
            txv_phoneNo.setText("Phone No " + user.getPhoneNo());
            txv_username.setText(user.getUsername());
        } catch (Exception e) {
            Log.e("ERROR", e.toString());
        }


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
                Toast.makeText(getActivity(), "You have logged out successfully", Toast.LENGTH_LONG).show();
                Intent in = new Intent(getActivity(), MainActivity.class);
                startActivity(in);
            }
        });



        return root;
    }


}