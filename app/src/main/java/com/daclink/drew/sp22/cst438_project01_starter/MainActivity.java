package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView userTextView;


    String userName = null;
    Button logoutButton;
    Button viewBooksButton;
    Button userMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutButton = (Button) findViewById(R.id.logoutButton);
        viewBooksButton = (Button) findViewById(R.id.viewBooksButton);
      
        Intent i = getIntent();
        Boolean isAdmin = i.getBooleanExtra(LoginActivity.EXTRA_IS_ADMIN, false);

//         userMenuBtn = (Button) findViewById(R.id.editUsersBtn);
//        if (getIntent().hasExtra("com.daclink.drew.sp22.cst438_project01_starter")) {
//            userName = getIntent().getExtras().getString("com.daclink.drew.sp22.cst438_project01_starter");

//        if (getIntent().hasExtra("com.example.mystoreapp.USER")) {
//            userName = getIntent().getExtras().getString("com.example.mystoreapp.USER");
//            logoutButton.setText(userName + " Logout");
//            BookTrackerDB dataBaseHelper = new BookTrackerDB() {
//                @Override
//                public BookDAO book() {
//                    return null;
//                }
//
//                @NonNull
//                @Override
//                protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
//                    return null;
//                }
//
//                @NonNull
//                @Override
//                protected InvalidationTracker createInvalidationTracker() {
//                    return null;
//                }
//
//                @Override
//                public void clearAllTables() {
//
//                }
//            };
//            dataBaseHelper.addLoginUser(userName);
//        }

        Button userMenuBtn = (Button) findViewById(R.id.userMenuBtn);
        if (isAdmin) {
            userMenuBtn.setVisibility(View.VISIBLE);
        } else {
            userMenuBtn.setVisibility(View.INVISIBLE);
        }

        // Attempt to launch another activity
//        userMenuBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), AdminActivity.class);
//
//                // show how to pass information
//                startActivity(startIntent);
//            }
//        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lets go
                finish();
            }
        });

//        viewBooksButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //lets go to the store
//                Intent startIntent = new Intent(getApplicationContext(), FirstFragment.class);
//
//                // Pass info to MainActivity
////                startIntent.putExtra("com.daclink.drew.sp22.cst438_project01_starter", userName);
//
//
//                // show how to pass information
//                startActivity(startIntent);
//            }
//        });

        viewBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewBooksActivity.class);
                startActivity(intent);
            }
        });

        userMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                startActivity(intent);
            }
        });

    }
}