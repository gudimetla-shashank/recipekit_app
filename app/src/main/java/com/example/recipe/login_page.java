package com.example.recipe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login_page extends AppCompatActivity {
    EditText Email,Password;
    Button Login;
    TextView AlreadyaUser;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Email = findViewById(R.id.editTextTextEmailAddress);
        Password = findViewById(R.id.editTextTextPassword);
        Login = findViewById(R.id.imageButton3);
        AlreadyaUser = findViewById(R.id.textView5);
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        Login.setOnClickListener(v -> {
            String savedEmail = sharedPreferences.getString("email", "");
            String savedPassword = sharedPreferences.getString("password", "");

            String enteredEmail = Email.getText().toString().trim();
            String enteredPassword = Password.getText().toString().trim();

            Log.d("LOGIN_DEBUG", "Entered Email: " + enteredEmail);
            Log.d("LOGIN_DEBUG", "Entered Password: " + enteredPassword);
            Log.d("LOGIN_DEBUG", "Saved Email: " + savedEmail);
            Log.d("LOGIN_DEBUG", "Saved Password: " + savedPassword);

            if (enteredEmail.equals(savedEmail) && enteredPassword.equals(savedPassword)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login_page.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
        });

        AlreadyaUser.setOnClickListener(v -> {
            Intent intent = new Intent(login_page.this, newuser.class);
            startActivity(intent);
            finish();
        });
    }
}
