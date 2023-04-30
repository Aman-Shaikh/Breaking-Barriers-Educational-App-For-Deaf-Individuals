package com.example.first;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "https://cp431-project-backend.herokuapp.com";
    private Button SignUpBtn;
    private EditText SignUpName, SignUpEmail, SignUpPass, SignUpCPass;
    private SharedPreferences sp;
    private SharedPreferences.Editor speditor;
    private ProgressBar SignUpProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sp = getSharedPreferences("SignIn", MODE_PRIVATE);
        speditor = sp.edit();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //converts json to the java object
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        SignUpBtn = findViewById(R.id.SignUpBtn);
        SignUpEmail = findViewById(R.id.SignUpEmail);
        SignUpName = findViewById(R.id.SignUpName);
        SignUpPass = findViewById(R.id.SignUpPass);
        SignUpCPass = findViewById(R.id.SignUpCPass);
        SignUpProgressBar = findViewById(R.id.SignUpProgressBar);

        setListeners();
    }

    private void setListeners() {

        findViewById(R.id.textSignIn).setOnClickListener(v -> onBackPressed());

        SignUpBtn.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                signup();
            }
        });
    }

    private  void signup() {
        loading(true);

        HashMap<String, String> map = new HashMap<>();

        map.put("UserName", SignUpName.getText().toString());
        map.put("Email", SignUpEmail.getText().toString());
        map.put("Password", SignUpPass.getText().toString());

        Call<Void> call = retrofitInterface.executeSignup(map);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.code() == 200) {
                    speditor.putBoolean("KEY_IS_SIGNED_IN",true);
                    speditor.putString("KEY_USER_NAME",SignUpName.getText().toString());
                    speditor.putString("KEY_USER_EMAIL",SignUpEmail.getText().toString());
                    speditor.commit();

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    showToast("Sign up successfully");
                    finish();

                } else if (response.code() == 400) {
                    loading(false);
                    showToast("Already registered! Sign In Please");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private Boolean isValidSignUpDetails() {
        if (SignUpName.getText().toString().trim().isEmpty()) {
            showToast("Enter Name");
            return false;
        } else if (SignUpEmail.getText().toString().trim().isEmpty()) {
            showToast("Enter Email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(SignUpEmail.getText().toString()).matches()) {
            showToast("Enter Valid Email");
            return false;
        } else if (SignUpPass.getText().toString().trim().isEmpty()) {
            showToast("Enter Password");
            return false;
        } else if (SignUpCPass.getText().toString().trim().isEmpty()){
            showToast("Confirm your Password");
            return false;
        }else if (!SignUpPass.getText().toString().equals(SignUpCPass.getText().toString())) {
            showToast("Password & Confirm Password must be same");
            return false;
        }else
        {
            return true;
        }
    }

    private void loading(Boolean isLoading) {
        if (isLoading) {
            SignUpBtn.setVisibility(View.INVISIBLE);
            SignUpProgressBar.setVisibility(View.VISIBLE);
        } else {
            SignUpProgressBar.setVisibility(View.INVISIBLE);
            SignUpBtn.setVisibility(View.VISIBLE);
        }
    }




    private void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

}
