package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {

    private ListView wlistView;
    private EditText titleText, authorText;
    private Button addToWishlistButton;

    private List<Book> books;
    private UserDAO bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        wlistView = findViewById(R.id.wishListListView);
        titleText = findViewById(R.id.editTextTitle);
        authorText = findViewById(R.id.editTextAuthor);
        addToWishlistButton = findViewById(R.id.addToWishlistButton);

        bookDao = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .getDao();

        books = bookDao.getAllBooks();

//        ArrayList<Book> bookList = new ArrayList<>();
//        Book testBook = new Book("1984", "George Orwell", 0);
//        bookList.add(testBook);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList);
//        wlistView.setAdapter(arrayAdapter);

        refreshListView();

        addToWishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBookToWishlist();
                refreshListView();
            }
        });
    }

    private void refreshListView() {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            bookList.add(b);
        }
//        Book testBook = new Book("The Test Book", "Tester", 0);
//        bookList.add(testBook);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList);
        wlistView.setAdapter(arrayAdapter);
    }

    private void addBookToWishlist() {
        Book b = new Book(titleText.getText().toString(), authorText.getText().toString(), 0);
        bookDao.insert(b);
    }
}