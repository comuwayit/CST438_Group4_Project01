package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.ArrayRes;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookLogActivity extends AppCompatActivity {
    public static final String EXTRA_USER_ID = "com.daclink.drew.sp22.cst438_project01_starter.EXTRA_USER_ID";

//    private User mUser;
//    private int mUserId;

    private ListView listView;
    private EditText titleText, authorText;
    private Button addToLogButton;

    private List<Book> books;
    private UserDAO bookDao;

    private int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_log);

        listView = findViewById(R.id.logListView);
        titleText = findViewById(R.id.lEditTextTitle);
        authorText = findViewById(R.id.lEditTextAuthor);
        addToLogButton = findViewById(R.id.addToLogButton);

        bookDao = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .getDao();

        books = bookDao.getAllBooks();


        Intent i = getIntent();
        userID = i.getIntExtra(MainActivity.EXTRA_USER_ID, -10);

        refreshListView();

        addToLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBookToWishlist();
//                refreshListView();
            }
        });
    }

    private void refreshListView() {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.getUserId() == userID && b.getGenre().equals("log")) {
                bookList.add(b);
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList);
        listView.setAdapter(arrayAdapter);
    }

    private void addBookToWishlist() {
        if (titleText.getText().toString().isEmpty() || authorText.getText().toString().isEmpty()) {
            Toast.makeText(BookLogActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        Book b = new Book(titleText.getText().toString(), authorText.getText().toString(), "log", userID);
        bookDao.insert(b);
        finish();
        startActivity(getIntent());
    }
}