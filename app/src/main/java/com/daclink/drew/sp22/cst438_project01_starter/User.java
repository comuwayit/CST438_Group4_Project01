package com.daclink.drew.sp22.cst438_project01_starter;

import  androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.*;
import java.util.*;
import com.daclink.drew.sp22.cst438_project01_starter.Book;

@Entity(tableName = AppDataBase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    private String mUsername;
    private String mPassword;


    private ArrayList<Book> mWishList;
    private ArrayList<Book> mBookLog;

    public User(String mUsername, String mPassword){
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public String getUsername() {
        return mUsername;
    }
    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getPassword() {
        return mPassword;
    }
    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getUserId() {
        return mUserId;
    }
    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public ArrayList<Book> getmWishList() {
        return mWishList;
    }

    public void setmWishList(ArrayList<Book> mWishList) {
        this.mWishList = mWishList;
    }

    public ArrayList<Book> getmBookLog() {
        return mBookLog;
    }

    public void setmBookLog(ArrayList<Book> mBookLog) {
        this.mBookLog = mBookLog;
    }

    @Override
    public String toString() {
        return mUsername;
    }


}
