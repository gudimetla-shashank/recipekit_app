package com.example.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class start_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(start_page.this, newuser.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}
