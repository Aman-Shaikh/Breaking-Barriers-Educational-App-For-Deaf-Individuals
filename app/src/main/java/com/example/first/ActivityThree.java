package com.example.first;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class ActivityThree extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        getSupportActionBar().hide();
    }
}