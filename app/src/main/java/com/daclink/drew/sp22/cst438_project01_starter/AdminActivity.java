package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button logoutButton;
        Button editUsersButton;

        logoutButton = (Button) findViewById(R.id.logoutButton);
        editUsersButton = (Button) findViewById(R.id.editUsersBtn);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lets go
                finish();
            }
        });

        editUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditUserActivity.class);
                startActivity(intent);
            }
        });

//        if (getIntent().hasExtra("com.daclink.drew.sp22.cst438_project01_starter")) {
//            userName = getIntent().getExtras().getString("com.daclink.drew.sp22.cst438_project01_starter");
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
    }
}