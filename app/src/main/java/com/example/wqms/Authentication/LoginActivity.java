package com.example.wqms.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wqms.R;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView sign_up_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        sign_up_text = findViewById(R.id.sign_up_text);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,
                        com.example.wqms.ui.Home.class);
                startActivity(intent);
            }
        });
        sign_up_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,
                        com.example.wqms.Authentication.SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}