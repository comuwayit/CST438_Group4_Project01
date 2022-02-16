package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert
    void insert(Book... Books);

    @Update
    void update(Book... Books);

    @Delete
    void delete(Book Book);

    @Query("SELECT * FROM " + AppDataBase.BOOK_TABLE + " ORDER BY mTitle ASC")
    List<Book> getAllBooks();

    @Query("SELECT * FROM " + AppDataBase.BOOK_TABLE + " WHERE mAuthor = :Author")
    Book getBookByAuthor(String Author);

    @Query("SELECT * FROM " + AppDataBase.BOOK_TABLE + " WHERE idNumber = :idNum")
    Book getBookbyBookId(int idNum);
}
