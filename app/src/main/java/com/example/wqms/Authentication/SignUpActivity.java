package com.example.wqms.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wqms.R;

public class SignUpActivity extends AppCompatActivity {
    Button sign_up;
    TextView login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign_up = findViewById(R.id.sign_up);
        login_text = findViewById(R.id.login_text);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,
                        com.example.wqms.Authentication.LoginActivity.class);
                startActivity(intent);
            }
        });
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,
                        com.example.wqms.Authentication.LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}