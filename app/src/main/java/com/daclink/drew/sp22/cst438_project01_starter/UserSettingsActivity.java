package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserSettingsActivity extends AppCompatActivity {

    private Button goBackButton, logoutButton, deleteAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        goBackButton = findViewById(R.id.settingsGoBackButton);
        logoutButton = findViewById(R.id.settingsLogoutButton);
        deleteAccountButton = findViewById(R.id.settingsDeleteAccountButton);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeleteAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}