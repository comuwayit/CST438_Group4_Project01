package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = AppDataBase.BOOK_TABLE)
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int idNumber;

    private String mAuthor;
    private String mTitle;
    private String mGenre;
    private int mUserId;

    public Book(){
        mTitle = "Hello World";
        mGenre = "Comedy";
        mAuthor = "Brandon Sanderson";
    }

    public Book(String mTitle, String mAuthor, int mUserId){
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mUserId = mUserId;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        this.mUserId = userId;
    }


    @Override
    public String toString() {
        return mTitle + " by " + mAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(mTitle, book.mTitle) && Objects.equals(idNumber, book.idNumber) && Objects.equals(mGenre, book.mGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTitle, idNumber, mGenre);
    }
}
