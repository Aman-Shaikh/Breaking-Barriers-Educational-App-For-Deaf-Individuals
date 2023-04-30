package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityOne extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        final LinearLayout button1 = findViewById(R.id.Activity4);
        final LinearLayout button2 = findViewById(R.id.Activity5);
        final LinearLayout button3 = findViewById(R.id.Activity6);
        final LinearLayout button4 = findViewById(R.id.Activity7);
        final LinearLayout button5 = findViewById(R.id.Activity8);
        final LinearLayout button6 = findViewById(R.id.Activity9);
        final LinearLayout button7 = findViewById(R.id.Activity10);
        final LinearLayout button8 = findViewById(R.id.Activity11);


        getSupportActionBar().hide();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivityFour.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivityFive.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivitySix.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivitySeven.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivityEight.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivityNine.class);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button8.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityOne.this, ActivityTen.class);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                button5.setBackgroundResource(R.drawable.round_back_black10);
                button6.setBackgroundResource(R.drawable.round_back_black10);
                button7.setBackgroundResource(R.drawable.round_back_black10);
                button8.setBackgroundResource(R.drawable.round_back_black_stroke10);
                Intent intent = new Intent(ActivityOne.this, ActivityEleven.class);
                startActivity(intent);
            }
        });

    }
}

