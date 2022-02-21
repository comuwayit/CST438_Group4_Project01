package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Database;

import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 2, exportSchema = false)
public abstract class BookTrackerDB extends RoomDatabase{
    public abstract BookDAO book();
    public static final String BOOK_TABLE = "BOOK_TABLE";

}
