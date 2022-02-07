package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.daclink.drew.sp22.cst438_project01_starter.User;

@Database(entities = {User.class}, version = 1); // idk what this error means :(
public abstract class UserDataBase extends RoomDatabase {
    public static final String DB_NAME = "USER_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";

    public abstract UserDAO getDao();


}
