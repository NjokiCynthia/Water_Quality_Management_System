package com.example.wqms.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wqms.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView sign_up_text, forgot;
    ProgressBar progressbar;
    EditText l_email, l_password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        sign_up_text = findViewById(R.id.sign_up_text);
        forgot = findViewById(R.id.forgot);
        progressbar = findViewById(R.id.progressbar);
        l_email = findViewById(R.id.l_email);
        l_password = findViewById(R.id.l_password);

        mAuth = FirebaseAuth.getInstance();

        sign_up_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loginUser();
                Intent intent = new Intent(LoginActivity.this,
                        com.example.wqms.Authentication.SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,
                        com.example.wqms.Authentication.ForgotPassword.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(view ->
            loginUser());

    }

    private void loginUser() {
        String emailAddress = l_email.getText().toString().trim();
        String password = l_password.getText().toString().trim();

        if (emailAddress.isEmpty()){
            l_email.setError("Email required");
            l_email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()){
            l_email.setError("Provide valid email");
            return;
        }
        if (password.isEmpty()){
            l_password.setError("Enter password");
            l_password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()) {
                        Intent intent = new Intent(LoginActivity.this,
                                com.example.wqms.ui.Home.class);
                        startActivity(intent);

                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this,
                                "Check your email to verify your account",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this,
                            "Failed to Login, please check your credentials.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}