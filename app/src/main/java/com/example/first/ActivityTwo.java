package com.example.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.M)

    private String selectedlevel = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        getSupportActionBar().hide();

        final LinearLayout level1 = findViewById(R.id.level1);
        final LinearLayout level2 = findViewById(R.id.level2);
        final LinearLayout level3 = findViewById(R.id.level3);
        final LinearLayout level4 = findViewById(R.id.level4);


        level1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                selectedlevel = "Level 1";
                level1.setBackgroundResource(R.drawable.round_back_black_stroke10);
                level2.setBackgroundResource(R.drawable.round_back_black10);
                level3.setBackgroundResource(R.drawable.round_back_black10);
                level4.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityTwo.this, QuizActivity.class);
                intent.putExtra("selectedlevel", selectedlevel);
                startActivity(intent);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                selectedlevel = "Level 2";
                level1.setBackgroundResource(R.drawable.round_back_black10);
                level2.setBackgroundResource(R.drawable.round_back_black_stroke10);
                level3.setBackgroundResource(R.drawable.round_back_black10);
                level4.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(ActivityTwo.this, QuizActivity1.class);
                intent.putExtra("selectedlevel", selectedlevel);
                startActivity(intent);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                selectedlevel = "Level 3";
                level1.setBackgroundResource(R.drawable.round_back_black10);
                level2.setBackgroundResource(R.drawable.round_back_black10);
                level4.setBackgroundResource(R.drawable.round_back_black10);
                level3.setBackgroundResource(R.drawable.round_back_black_stroke10);
                Intent intent = new Intent(ActivityTwo.this, QuizActivity2.class);
                intent.putExtra("selectedlevel", selectedlevel);
                startActivity(intent);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                selectedlevel = "Level 4";
                level1.setBackgroundResource(R.drawable.round_back_black10);
                level2.setBackgroundResource(R.drawable.round_back_black10);
                level3.setBackgroundResource(R.drawable.round_back_black10);
                level4.setBackgroundResource(R.drawable.round_back_black_stroke10);
                Intent intent = new Intent(ActivityTwo.this, QuizActivity3.class);
                intent.putExtra("selectedlevel", selectedlevel);
                startActivity(intent);
            }
        });



    }
}