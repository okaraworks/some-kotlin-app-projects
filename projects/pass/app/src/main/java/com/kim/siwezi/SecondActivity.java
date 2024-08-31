package com.kim.siwezi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SecondActivity extends AppCompatActivity {

Button sbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Spinner samount=findViewById(R.id.samount);
        Spinner minutes=findViewById(R.id.spinnermin);
        Spinner amntrd=findViewById(R.id.amntid);

        sbutton=findViewById(R.id.idbtnstartbot);
        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
        String[] amount={"499","999","2499","4999"};
        String[] minutesstr={"10","20","35","45"};
        String[] amntrdstr={"50","100","200","300"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,amount);
        ArrayAdapter<String> arrayAdaptermin=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,minutesstr);
        ArrayAdapter<String> arrayAdapterrd=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,amntrdstr);

        samount.setAdapter(arrayAdapter);
        minutes.setAdapter(arrayAdaptermin);
        amntrd.setAdapter(arrayAdapterrd);

    }
}