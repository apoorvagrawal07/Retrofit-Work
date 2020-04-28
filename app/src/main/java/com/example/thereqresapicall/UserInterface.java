package com.example.thereqresapicall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserInterface {

    @GET("users")
    Call<DataClass>getData(@Query("page") int page);

}
