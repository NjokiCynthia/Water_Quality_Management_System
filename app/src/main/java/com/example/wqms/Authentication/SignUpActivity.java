package com.example.wqms.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wqms.R;
import com.example.wqms.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    Button sign_up;
    TextView login_text;
    EditText email, phone, password, username;
    User user;
    FirebaseAuth mAuth;
    String userName, emailAddress, phoneNumber, Password;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign_up = findViewById(R.id.sign_up);
        login_text = findViewById(R.id.login_text);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("WQMS");
        sharedPreferences = getSharedPreferences(getResources()
                        .getString(R.string.global_preference_file_name),
                Context.MODE_PRIVATE);

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,
                        com.example.wqms.Authentication.LoginActivity.class);
                startActivity(intent);
            }
        });
        sign_up.setOnClickListener(view -> createFirebaseUser());

    }

    private void createFirebaseUser() {
        //displayProgressDialog("signing up...");
        userName = username.getText().toString();
        emailAddress = email.getText().toString();
        phoneNumber = phone.getText().toString();
        Password = password.getText().toString();

        if (userName.isEmpty()) {
            username.setError("The username is required");
            username.requestFocus();
            return;
        }
        if (emailAddress.isEmpty()) {
            email.setError("The email address is required");
            email.requestFocus();
            return;
        }
        if (phoneNumber.isEmpty()) {
            phone.setError("The phone number is required");
            phone.requestFocus();
            return;
        }
        if (Password.isEmpty()) {
            password.setError("The password is required");
            password.requestFocus();
            return;
        }
        if (Password.length() < 6) {
            password.setError("The password should be longer than six characters");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailAddress, Password)
                .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                User user = new User(emailAddress, phoneNumber, userName);

                                firebaseDatabase.getInstance().getReference("WQLM/user/getter")
                                        .child(Objects.requireNonNull(FirebaseAuth.getInstance()
                                                .getCurrentUser()).getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(SignUpActivity.this,
                                                    com.example.wqms.Authentication.LoginActivity.class);
                                            intent.putExtra("user", new Gson().toJson(user));
                                            startActivity(intent);
                                            Toast.makeText(getApplicationContext(),
                                                    "Registration Successful",
                                                    Toast.LENGTH_LONG).show();

                                        } else {
                                            Toast.makeText(getApplicationContext(),
                                                    "Registration Failed. Try again.",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        }
                );
    }
}