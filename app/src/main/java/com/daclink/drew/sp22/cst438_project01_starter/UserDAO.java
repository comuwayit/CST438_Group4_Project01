package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.daclink.drew.sp22.cst438_project01_starter.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + UserDataBase.USER_TABLE + " ORDER BY mUsername ASC")
    List<User> getAllUsers();

    @Query("SELECT * FROM " + UserDataBase.USER_TABLE + " WHERE mUsername = :username")
    User getUserbyUsername(String username);

//    @Query("SELECT * FROM " + UserDataBase.USER_TABLE + " WHERE mUserId = userid");
//    User getUserbyUserId(int userid);

}
