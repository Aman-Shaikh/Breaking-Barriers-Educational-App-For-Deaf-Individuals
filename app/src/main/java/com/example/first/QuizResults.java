package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        getSupportActionBar().hide();

        final AppCompatButton startnew = findViewById(R.id.newquiz);
        final TextView correctans = findViewById(R.id.correctanswer);
        final TextView Incorrectans = findViewById(R.id.incorrectanswer);

        final int getCorrectAnswer = getIntent().getIntExtra("correct",0);
        final int getInCorrectAnswer = getIntent().getIntExtra("Incorrect",0);
        correctans.setText("Correct Answer"+":"+String.valueOf(getCorrectAnswer));
        Incorrectans.setText("Wrong Answer"+":" +String.valueOf(getInCorrectAnswer));

        startnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this,QuizActivity.class));
                finish();
            }
        });

    }
}