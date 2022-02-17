package com.daclink.drew.sp22.cst438_project01_starter.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.daclink.drew.sp22.cst438_project01_starter.api.BookSearchService;
import com.daclink.drew.sp22.cst438_project01_starter.models.VolumeResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;




public class BookRepository {
    private static final String BOOK_SEARCH_SERVICE_BASE_URL = "https://www.googleapis.com/";

    private BookSearchService bookSearchService;
    private MutableLiveData<VolumeResponse> volumesResponseLiveData;

    public BookRepository() {
        volumesResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        bookSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookSearchService.class);

    }

    public void searchVolumes(String keyword, String author, String apiKey) {
        bookSearchService.searchVolumes(keyword, author, apiKey)
                .enqueue(new Callback<VolumeResponse>() {
                    @Override
                    public void onResponse(Call<VolumeResponse> call, Response<VolumeResponse> response) {
                        if (response.body() != null) {
                            volumesResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<VolumeResponse> call, Throwable t) {
                        volumesResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<VolumeResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }




}
