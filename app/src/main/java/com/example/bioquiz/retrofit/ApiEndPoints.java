package com.example.bioquiz.retrofit;

import com.example.bioquiz.Model.Bab;
import com.example.bioquiz.Model.Material;
import com.example.bioquiz.Model.Question;
import com.example.bioquiz.Model.RegisterResponse;
import com.example.bioquiz.Model.Stage;
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
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> register(@Field("name") String name,  @Field("city") String city, @Field("school") String school,
                                    @Field("birthyear") String birthyear,  @Field("username") String username, @Field("email") String email,
                                    @Field("password") String passsword);

    @POST("logout")
    Call<JsonObject> logout();

    @GET("questions")
    Call<Question> getQuestions();

    @GET("stage")
    Call<Stage> getStage();

    @GET("bab")
    Call<Bab> getBab();

    @GET("materi")
    Call<Material> getMateri();
}
