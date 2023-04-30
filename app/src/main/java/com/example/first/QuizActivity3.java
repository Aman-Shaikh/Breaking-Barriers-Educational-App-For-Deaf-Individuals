package com.example.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import android.widget.Toast;


public class QuizActivity3 extends AppCompatActivity {
    TextView[] dots;
    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;
    ViewPagerAdapter11 viewPagerAdapter;

    private TextView questions;

    private AppCompatButton option1,option2,option3,option4;
    private AppCompatButton next;



    private List<QuestionsList> questionsList;
    private int currentquestionpos=0;
    private String selectedoption= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        final TextView selectedlevel = findViewById(R.id.level);
        final String getselectedlevel =getIntent().getStringExtra("selectedlevel");

        questions =findViewById(R.id.questions);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        next = findViewById(R.id.next);

        questionsList = QuestionsBank.getQuestion(getselectedlevel);
        selectedlevel.setText(getselectedlevel);

        questions.setText((currentquestionpos+1)+"/"+questionsList.size());
        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty())
                {
                    selectedoption =option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);
                    revealanswer();
                    questionsList.get(currentquestionpos).setUserSelectedAnswer(selectedoption);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty())
                {
                    selectedoption =option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);
                    revealanswer();
                    questionsList.get(currentquestionpos).setUserSelectedAnswer(selectedoption);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty())
                {
                    selectedoption =option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);
                    revealanswer();
                    questionsList.get(currentquestionpos).setUserSelectedAnswer(selectedoption);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedoption.isEmpty())
                {
                    selectedoption =option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);
                    revealanswer();
                    questionsList.get(currentquestionpos).setUserSelectedAnswer(selectedoption);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedoption.isEmpty())
                {
                    Toast.makeText(QuizActivity3.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    changenextquestion();

                    if (getitem(0) < 26)
                        mSLideViewPager.setCurrentItem(getitem(1),true);
                    else {

                        Intent i = new Intent(QuizActivity3.this,MainScreen.class);
                        startActivity(i);
                        finish();

                    }
                }


            }
        });

        mSLideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);
        viewPagerAdapter = new ViewPagerAdapter11(this);

        mSLideViewPager.setAdapter(viewPagerAdapter);
    }


    private void changenextquestion()
    {
        currentquestionpos++;
        if((currentquestionpos+1)==questionsList.size())
        {
            next.setText("Submit Quiz");
        }

        if((currentquestionpos+1)<=questionsList.size())
        {
            selectedoption="";
            option1.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option1.setTextColor(Color.parseColor("#1F6888"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option2.setTextColor(Color.parseColor("#1F6888"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option3.setTextColor(Color.parseColor("#1F6888"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2_10);
            option4.setTextColor(Color.parseColor("#1F6888"));

            questions.setText((currentquestionpos+1)+"/"+questionsList.size());
            option1.setText(questionsList.get(currentquestionpos).getOption1());
            option2.setText(questionsList.get(currentquestionpos).getOption2());
            option3.setText(questionsList.get(currentquestionpos).getOption3());
            option4.setText(questionsList.get(currentquestionpos).getOption4());
        }
        else
        {
            Intent intent=new Intent(QuizActivity3.this,QuizResults.class);
            intent.putExtra("correct",getCorrectAnswer());
            intent.putExtra("Incorrect",getInCorrectAnswer());
            startActivity(intent);
            finish();
        }
    }
    private int getCorrectAnswer(){
        int correctAnswers=0;
        for(int i=0;i<questionsList.size();i++){
            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer))
            {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getInCorrectAnswer(){
        int IncorrectAnswers=0;
        for(int i=0;i<questionsList.size();i++){
            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsList.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer))
            {
                IncorrectAnswers++;
            }
        }
        return IncorrectAnswers;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpindicator(int position){

        dots = new TextView[26];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < 26 ; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(10);
            mDotLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }


    private int getitem(int i){

        return mSLideViewPager.getCurrentItem() + i;
    }

    private void revealanswer()
    {
        final String getanswer = questionsList.get(currentquestionpos).getAnswer();
        if(option1.getText().toString().equals(getanswer))
        {
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getanswer))
        {
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getanswer))
        {
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getanswer))
        {
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }

}