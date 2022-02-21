package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " ORDER BY mUsername ASC")
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUsername = :username")
    User getUserbyUsername(String username);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUserId = :userid")
    User getUserbyUserId(int userid);

    //BOOK DAO OPERATIONS
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
