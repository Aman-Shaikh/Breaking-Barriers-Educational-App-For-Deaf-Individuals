package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.HashMap;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class SignInActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "https://cp431-project-backend.herokuapp.com";
    private Button SignInBtn;
    private EditText SignInEmail,SignInPass;
    private ProgressBar progressBar;
    private SharedPreferences sp;
    private SharedPreferences.Editor speditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sp = getSharedPreferences("SignIn",MODE_PRIVATE);
        speditor = sp.edit();


        if(sp.getBoolean("KEY_IS_SIGNED_IN",false)){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }

        SignInBtn =  findViewById(R.id.SignInBtn);
        SignInEmail =  findViewById(R.id.SignInEmail);
        SignInPass =  findViewById(R.id.SignInPass);
        progressBar = findViewById(R.id.SignInProgressBar);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //converts json to the java object
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        setListeners();

    }

    private void setListeners() {
        findViewById(R.id.textCreateNewAccount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidSignInDetails()){
                    signIn();
                }
            }
        });
    }

    private Boolean isValidSignInDetails() {
        if(SignInEmail.getText().toString().trim().isEmpty()){
            showToast("Enter Email");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(SignInEmail.getText().toString()).matches()) {
            showToast("Enter Valid Email");
            return false;
        }else if (SignInPass.getText().toString().trim().isEmpty()){
            showToast("Enter Password");
            return false;
        }else{
            return true;
        }
    }

    private void signIn() {
        loading(true);

        HashMap<String, String> map = new HashMap<>();

        map.put("Email", SignInEmail.getText().toString());
        map.put("Password", SignInPass.getText().toString());

        Call<LoginResult> call = retrofitInterface.executeLogin(map);// Call is used to invoke http request
        //retrofit interface's executeLogin method returns json object which is converted to java object
        // with the help of addConverterFactory(GsonConverterFactory.create()) that we specified earlier

        //Now this calling is asynchronous process because it takes time to go to the server and come back
        //Hence it needs one call back function
        //callback is function which executes after completion of some event.

        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                if (response.code() == 200)
                {
                    LoginResult result = response.body();
                    speditor.putBoolean("KEY_IS_SIGNED_IN",true);
                    speditor.putString("KEY_USER_NAME",result.getName());
                    speditor.putString("KEY_USER_EMAIL",result.getEmail());
                    speditor.commit();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    showToast("Sign in successfully");
                    finish();
                } else if (response.code() == 404) {
                    loading(false);
                    showToast("Unable to Sign in Wron Credidential");
                }

            }
            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private void loading (Boolean isLoading){
        if(isLoading){
            SignInBtn.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.INVISIBLE);
            SignInBtn.setVisibility(View.VISIBLE);
        }
    }


    private void showToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}