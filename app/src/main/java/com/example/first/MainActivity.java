package com.example.first;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor speditor;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("SignIn", MODE_PRIVATE);
        speditor = sp.edit();
        name=findViewById(R.id.textName);
        name.setText(sp.getString("KEY_USER_NAME","USER"));
        setListeners();


        final LinearLayout button1 = findViewById(R.id.ActivityOne);
        final LinearLayout button2 = findViewById(R.id.ActivityTwo);
        final LinearLayout button3 = findViewById(R.id.ActivityThree);
        final LinearLayout button4 = findViewById(R.id.TextToImage);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setBackgroundResource(R.drawable.round_back_black_stroke10);
                button2.setBackgroundResource(R.drawable.round_back_black10);
                button3.setBackgroundResource(R.drawable.round_back_black10);
                button4.setBackgroundResource(R.drawable.round_back_black10);
                Intent intent = new Intent(MainActivity.this, ActivityOne.class);
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
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
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
                Intent intent = new Intent(MainActivity.this, TextToImage.class);
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
                Intent intent = new Intent(MainActivity.this, TextTosign.class);
                startActivity(intent);
            }
        });

    }


    private void setListeners() {

//        findViewById(R.id.imageSignOut).setOnClickListener(v -> signOut());

    }

    private void signOut() {
        showToast("Signing Out...");
        speditor.putBoolean("KEY_IS_SIGNED_IN",false);
        speditor.putString("KEY_USER_NAME","");
        speditor.putString("KEY_USER_EMAIL","");
        speditor.commit();
        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
        finish();
    }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

