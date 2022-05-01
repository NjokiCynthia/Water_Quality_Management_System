package com.example.wqms.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wqms.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    TextView r_login;
    EditText f_email;
    Button reset_p;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        r_login = findViewById(R.id.r_login);
        f_email = findViewById(R.id.f_email);
        reset_p = findViewById(R.id.reset_p);

        auth = FirebaseAuth.getInstance();

        r_login.setOnClickListener(view -> {
            Intent intent = new Intent(ForgotPassword.this,
                    LoginActivity.class);
            startActivity(intent);
        });

        reset_p.setOnClickListener(view -> resetPassword());
    }
    private void resetPassword() {
        String email = f_email.getText().toString().trim();
        if (email.isEmpty()){
            f_email.setError("Please enter an email address.");
            f_email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            f_email.setError("Please provide a valid email");
            f_email.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this,
                            "Check your email to reset your password", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ForgotPassword.this,
                            "Try Again, there is an error.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}