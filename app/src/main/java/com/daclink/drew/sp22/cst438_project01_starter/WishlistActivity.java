package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daclink.drew.sp22.cst438_project01_starter.AppDataBase;
import com.daclink.drew.sp22.cst438_project01_starter.User;
import com.daclink.drew.sp22.cst438_project01_starter.Book;
import com.daclink.drew.sp22.cst438_project01_starter.R;

import java.util.ArrayList;

public class WishlistActivity extends AppCompatActivity {
    public static final String USER_ID_KEY = "com.daclink.drew.sp22.cst438_project01_starter.USER_ID_KEY";

    private User mUser;
    private int mUserId;

    private ListView wlistView;

    private UserDAO bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        wlistView = findViewById(R.id.wishListListView);

        bookDao = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .getDao();

        mUserId = getIntent().getIntExtra(USER_ID_KEY, -1);
        mUser = bookDao.getUserbyUserId(mUserId);


        Intent i = getIntent();

        Boolean isAdmin = i.getBooleanExtra(MainActivity.USER_ID_KEY, false);

        ArrayList<Book> bookList = new ArrayList<>();

        Book testBook = new Book("1984", "Distopian", "George Orwell", 1);
        bookList.add(testBook);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList);
        wlistView.setAdapter(arrayAdapter);
    }
}