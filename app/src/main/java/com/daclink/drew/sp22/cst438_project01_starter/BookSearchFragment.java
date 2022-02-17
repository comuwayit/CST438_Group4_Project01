package com.daclink.drew.sp22.cst438_project01_starter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.daclink.drew.sp22.cst438_project01_starter.R;
import com.daclink.drew.sp22.cst438_project01_starter.adapters.BookSearchAdapter;
import com.daclink.drew.sp22.cst438_project01_starter.models.VolumeResponse;
import com.daclink.drew.sp22.cst438_project01_starter.viewmodels.BookSearchViewModel;
import com.daclink.drew.sp22.cst438_project01_starter.Book;
import com.daclink.drew.sp22.cst438_project01_starter.User;

public class BookSearchFragment extends Fragment{

    private BookSearchViewModel viewModel;
    private BookSearchAdapter adapter;

    private TextInputEditText keywordEditText, authorEditText;

    private Button searchButton;
    private Button readButton;
    private Button wishButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        adapter = new BookSearchAdapter();

        viewModel = ViewModelProviders.of(this).get(BookSearchViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, new Observer<VolumeResponse>() {
            @Override
            public void onChanged(VolumeResponse volumeResponse) {
                if(volumeResponse != null){
                    adapter.setResults(volumeResponse.getItems());
                }
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_booksearch, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        keywordEditText = view.findViewById(R.id.fragment_booksearch_keyword);
        authorEditText = view.findViewById(R.id.fragment_booksearch_author);
        searchButton = view.findViewById(R.id.fragment_booksearch_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });

        return view;
    }

    public void performSearch(){
        String keyword = keywordEditText.getEditableText().toString();
        String author = authorEditText.getEditableText().toString();

        viewModel.searchVolumes(keyword, author);
    }

    //add toReadlist button
    //add toWishList button



}
