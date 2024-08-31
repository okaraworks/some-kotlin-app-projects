package com.krypt.djacademy.Users.Staff.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.krypt.djacademy.R;

public class UploadActivity extends AppCompatActivity {
    EditText nm,storage;
    Button uploadmix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        nm=findViewById(R.id.mixnmid);
        storage=findViewById(R.id.getmixid);
        uploadmix=findViewById(R.id.btn_uploadmix);
    }
}