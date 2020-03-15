package com.example.android.fastshipv1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;



interface APIFunctions {

    @POST("register.php?")
    public Call<RegisterResponseModel> register(@Query("email") String email,@Query("name") String name,
                                   @Query("username") String username,
                                   @Query("password") String pass
                                   ) ;

    @POST("login?")
    public Call<userdata> login(@Query("email") String email,
                                   @Query("passwword") String pass
    ) ;
}
