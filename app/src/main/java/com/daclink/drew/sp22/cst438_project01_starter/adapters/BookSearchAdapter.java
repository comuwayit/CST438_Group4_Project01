package com.daclink.drew.sp22.cst438_project01_starter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daclink.drew.sp22.cst438_project01_starter.R;
import com.daclink.drew.sp22.cst438_project01_starter.models.Volume;
import com.daclink.drew.sp22.cst438_project01_starter.Util.Util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class BookSearchAdapter extends RecyclerView.Adapter<BookSearchAdapter.BookSearchResultsHolder> {
    private List<Volume> results = new ArrayList<>();

    @NonNull
    @Override
    public BookSearchResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new BookSearchResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultsHolder holder, int position) {
        Volume volume = results.get(position);

        holder.titleTextView.setText(volume.getVolumeInfo().getTitle());
        holder.publishedDateTextView.setText(volume.getVolumeInfo().getPublishedDate());

        if (volume.getVolumeInfo().getImageLinks() != null) {
            String imageUrl = volume.getVolumeInfo().getImageLinks().getSmallThumbnail()
                    .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.smallThumbnailImageView);
        }

        if (volume.getVolumeInfo().getAuthors() != null) {
            Util u = new Util();
            String authors = u.StringJoin(volume.getVolumeInfo().getAuthors(), ", ");
            holder.authorsTextView.setText(authors);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Volume> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class BookSearchResultsHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;
        private TextView authorsTextView;
        private TextView publishedDateTextView;
        private ImageView smallThumbnailImageView;

        public BookSearchResultsHolder(@NonNull View itemView){
            super(itemView);

            titleTextView = itemView.findViewById(R.id.book_item_title);
            authorsTextView = itemView.findViewById(R.id.book_item_authors);
            publishedDateTextView = itemView.findViewById(R.id.book_item_publishedDate);
            smallThumbnailImageView = itemView.findViewById(R.id.book_item_smallThumbnail);
        }
    }
}
