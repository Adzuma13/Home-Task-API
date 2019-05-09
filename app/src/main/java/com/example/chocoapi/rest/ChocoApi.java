package com.example.chocoapi.rest;

import com.example.chocoapi.rest.entities.MainDeal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChocoApi {
    @GET(Config.PATH_FOR_DATA + "deals")
    Call<MainDeal> getDealList(
        @Query("town_id") int town_id,
        @Query("category_id") int category_id,
        @Query("page") int page
    );
}
