package com.example.jantech.Users.Staff.ProjectManager;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jantech.R;

public class Eventscreate extends AppCompatActivity {
    EditText title,desc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.create_events);
    }
}
