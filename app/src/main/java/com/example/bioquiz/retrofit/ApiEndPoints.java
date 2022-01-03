package com.example.bioquiz.retrofit;

import com.example.bioquiz.Model.Question;
import com.example.bioquiz.Model.RegisterResponse;
import com.example.bioquiz.Model.TokenResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoints {
    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login( @Field("name") String name,  @Field("city") String city, @Field("school") String school,  @Field("birthyear") String birthyear,  @Field("username") String username, @Field("email") String email, @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> register(@Field("name") String name,  @Field("city") String city, @Field("school") String school,
                                    @Field("birthyear") String birthyear,  @Field("username") String username, @Field("email") String email,
                                    @Field("password") String passsword,
                                    @Field("password_confirmation") String password_confirmation);

    @POST("logout")
    Call<JsonObject> logout();

    @GET("questions")
    Call<Question> getQuestions();
}
