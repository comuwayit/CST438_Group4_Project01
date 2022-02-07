package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookTrackerDB extends RoomDatabase{
    public abstract bookDAO book();


}
