package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EditUserActivity extends AppCompatActivity {

    private Button confirmButton;
    private EditText textUserName;

    private UserDAO userDAO;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        confirmButton = findViewById(R.id.confirmDeletionBtn);
        textUserName = findViewById(R.id.userNameText);

        userDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDao();

        users = userDAO.getAllUsers();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAccount();
                Toast.makeText(EditUserActivity.this, "Feature not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void deleteAccount() {
        String adminUsername = "admin";
        for (User u : users) {
            if (textUserName.getText().toString().isEmpty()) {
                Toast.makeText(EditUserActivity.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                return;
            } else if (textUserName.getText().toString().equals(adminUsername)) {
                Toast.makeText(EditUserActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (textUserName.getText().toString().equals(u.getUsername())) {
                userDAO.delete(u);
                Toast.makeText(EditUserActivity.this, "Account: " + u.getUsername() + " Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                return;
            }
        }
        Toast.makeText(EditUserActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }
}