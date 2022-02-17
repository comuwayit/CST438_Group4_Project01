package com.daclink.drew.sp22.cst438_project01_starter.api;

import com.daclink.drew.sp22.cst438_project01_starter.models.VolumeResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface BookSearchService {
    @GET("/books/v1/volumes")
    Call<VolumeResponse> searchVolumes(
            @Query("q") String query,
            @Query("inauthor") String author,
            @Query("key") String apiKey
    );
}
