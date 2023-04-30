package com.example.first;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("/api/v1/SignIn")
    Call<LoginResult> executeLogin(@Body HashMap<String,String> map);

    @POST("/api/v1/SignUp")
    Call<Void> executeSignup(@Body HashMap<String,String> map);
}
