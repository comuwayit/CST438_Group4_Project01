package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = BookTrackerDB.BOOK_TABLE)
public class Book {
    @PrimaryKey(autoGenerate = true)
    private Integer idNumber;

    private String title;
    private String genre;

    public Book(){
        title = "Hello World";
        idNumber = 69420;
        genre = "Comedy";
    }

    public Book(String title, Integer idNumber, String genre){
        this.title = title;
        this.idNumber = idNumber;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", idNumber=" + idNumber +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(idNumber, book.idNumber) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, idNumber, genre);
    }
}
