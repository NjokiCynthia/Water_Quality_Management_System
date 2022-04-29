package com.example.wqms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    CardView card;
    Button access;
    TextView f_text, copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        access = findViewById(R.id.access);
        f_text = findViewById(R.id.f_text);
        copyright = findViewById(R.id.copyright);

        access.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,
                    com.example.wqms.Authentication.LoginActivity.class);
            startActivity(intent);
        });

    }
}