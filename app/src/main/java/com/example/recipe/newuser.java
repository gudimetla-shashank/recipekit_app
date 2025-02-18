package com.example.recipe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class newuser extends AppCompatActivity {
    EditText  Username, Email,Password;
    Button Register;
    TextView AlreadyUser;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);


        Username = findViewById(R.id.editTextText);
        Email = findViewById(R.id.editTextTextEmailAddress2);
        Password = findViewById(R.id.editTextTextPassword2);
        Register = findViewById(R.id.imageButton3);
        AlreadyUser = findViewById(R.id.textView6);
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        Register.setOnClickListener(v -> {
            String username = Username.getText().toString().trim();
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();

            Log.d("REGISTER_DEBUG", "Entered Username: " + username);
            Log.d("REGISTER_DEBUG", "Entered Email: " + email);
            Log.d("REGISTER_DEBUG", "Entered Password: " + password);

            if (!username.isEmpty() != email.isEmpty() && !password.isEmpty()) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.apply();

                Log.d("REGISTER_DEBUG", "Saved Username: " + sharedPreferences.getString("username", "Not Found"));
                Log.d("REGISTER_DEBUG", "Saved Email: " + sharedPreferences.getString("email", "Not Found"));
                Log.d("REGISTER_DEBUG", "Saved Password: " + sharedPreferences.getString("password", "Not Found"));


                Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(newuser.this, login_page.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Enter all fields!", Toast.LENGTH_SHORT).show();
            }
        });


        AlreadyUser.setOnClickListener(v -> {
            Intent intent = new Intent(newuser.this, login_page.class);
            startActivity(intent);
            finish();
        });
    }
}