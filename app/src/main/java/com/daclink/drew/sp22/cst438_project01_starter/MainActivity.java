package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView userTextView;

    Button returnBtn;

    String userName = null;
    Button logoutButton;
    Button viewBooksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutButton = (Button) findViewById(R.id.logoutButton);
        viewBooksButton = (Button) findViewById(R.id.viewBooksButton);

//        if (getIntent().hasExtra("com.example.mystoreapp.USER")) {
//            userName = getIntent().getExtras().getString("com.example.mystoreapp.USER");
//            logoutButton.setText(userName + " Logout");
//            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
//            dataBaseHelper.addLoginUser(userName);
//        }

        Button userMenuBtn = (Button) findViewById(R.id.userMenuBtn);
        if (userName.equals("admin2")) {
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

//        bookViewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //lets go to the store
//                Intent startIntent = new Intent(getApplicationContext(), StoreActivity.class);
//
//                // Pass info to MainActivity
//                startIntent.putExtra("com.example.mystoreapp.USER", userName);
//
//
//                // show how to pass information
//                startActivity(startIntent);
//            }
//        });

    }
}