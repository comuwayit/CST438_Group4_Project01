package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Book.class}, version = 2) // idk what this error means :(

public abstract class AppDataBase extends RoomDatabase {
    public static final String DB_NAME = "USER_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";

//    public static final String BOOK_DB_NAME = "BOOK_DATABASE";
    public static final String BOOK_TABLE = "BOOK_TABLE";// read table
    public static final String WISH_TABLE = "WISH_TABLE";//wish list table

    public abstract BookDAO book();
    public abstract UserDAO getDao();


}
