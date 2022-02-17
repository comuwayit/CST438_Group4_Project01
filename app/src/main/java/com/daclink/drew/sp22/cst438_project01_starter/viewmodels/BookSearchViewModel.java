package com.daclink.drew.sp22.cst438_project01_starter.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.daclink.drew.sp22.cst438_project01_starter.api.JavaAPIKey;

import com.daclink.drew.sp22.cst438_project01_starter.models.VolumeResponse;
import com.daclink.drew.sp22.cst438_project01_starter.repository.BookRepository;

public class BookSearchViewModel extends AndroidViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumeResponse> volumesResponseLiveData;
    private JavaAPIKey APIKey;

    public BookSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword, String author) {
        // Dotenv dotenv = Dotenv.configure().directory("/assets").filename("env").load();
        bookRepository.searchVolumes(keyword, author, APIKey.getAPIKey());
    }

    public LiveData<VolumeResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
