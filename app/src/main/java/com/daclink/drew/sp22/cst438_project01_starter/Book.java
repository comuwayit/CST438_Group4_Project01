package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = BookTrackerDB.BOOK_TABLE)
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int idNumber;

    private String mAuthor;
    private String mTitle;
    private String mGenre;

    public Book(){
        mTitle = "Hello World";
        idNumber = 69420;
        mGenre = "Comedy";
    }

    public Book(String mTitle, int idNumber, String mGenre){
        this.mTitle = mTitle;
        this.idNumber = idNumber;
        this.mGenre = mGenre;
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

    @Override
    public String toString() {
        return "Book{" +
                "mTitle='" + mTitle + '\'' +
                ", idNumber=" + idNumber +
                ", mGenre='" + mGenre + '\'' +
                '}';
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
