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

public class DeleteAccountActivity extends AppCompatActivity {

    private Button confirmButton;
    private EditText textUserName, textPassword;

    private UserDAO userDAO;
    private List<User> users;
    private User toBeDeletedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        confirmButton = findViewById(R.id.buttonConfirmDeletion);
        textUserName = findViewById(R.id.editTextConfirmUsername);
        textPassword = findViewById(R.id.editTextConfirmPassword);

        userDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDao();

        users = userDAO.getAllUsers();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAccount();
//                Toast.makeText(DeleteAccountActivity.this, "Feature not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void deleteAccount() {
        String adminUsername = "admin";
        String adminPassword = "admin";
        if (textUserName.getText().toString().isEmpty() || textPassword.getText().toString().isEmpty()) {
            Toast.makeText(DeleteAccountActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        for (User u : users) {
            if (textUserName.getText().toString().equals(adminUsername) && textPassword.getText().toString().equals(adminPassword)) {
                Toast.makeText(DeleteAccountActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (textUserName.getText().toString().equals(u.getUsername()) && textPassword.getText().toString().equals(u.getPassword())) {
                toBeDeletedUser = u;
                userDAO.delete(toBeDeletedUser);
                Toast.makeText(DeleteAccountActivity.this, "Account: " + u.getUsername() + " Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                return;
            }
        }
        Toast.makeText(DeleteAccountActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }
}