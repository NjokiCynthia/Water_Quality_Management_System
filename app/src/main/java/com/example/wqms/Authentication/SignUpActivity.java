package com.example.wqms.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    ImageView logo_1;
    Button sign_up;
    TextView login_text;
    EditText email, phone, password, username;
    User user;
    FirebaseAuth mAuth;
    String userName, emailAddress, phoneNumber, Password, uuid;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private SharedPreferences sharedPreferences;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;

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
        logo_1 = findViewById(R.id.logo_1);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("WQMS");
        sharedPreferences = getSharedPreferences(getResources()
                        .getString(R.string.global_preference_file_name),
                Context.MODE_PRIVATE);

        if (checkAndRequestPermissions(SignUpActivity.this)) {
            logo_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chooseImage(SignUpActivity.this);
                }
            });
        }
    }

    // function to let the user choose image from camera or gallery
    private void chooseImage(Context context) {
        final CharSequence[] optionsMenu = {"Take Photo", "Choose from Gallery", "Exit"}; // create a menuOption Array
        // create a dialog for showing the optionsMenu
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // set the items in builder
        builder.setItems(optionsMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (optionsMenu[i].equals("Take Photo")) {
                    // Open the camera and get the photo
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);
                } else if (optionsMenu[i].equals("Choose from Gallery")) {
                    // choose from  external storage
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);
                } else if (optionsMenu[i].equals("Exit")) {
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }

    // function to check permission
    public static boolean checkAndRequestPermissions(final Activity context) {
        int WExtstorePermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int cameraPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (WExtstorePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded
                    .add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(context, listPermissionsNeeded
                            .toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    // Handled permission Result
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_ID_MULTIPLE_PERMISSIONS:
                if (ContextCompat.checkSelfPermission(SignUpActivity.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(),
                            "FlagUp Requires Access to Camera.", Toast.LENGTH_SHORT)
                            .show();
                } else if (ContextCompat.checkSelfPermission(SignUpActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(),
                            "FlagUp Requires Access to Your Storage.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    chooseImage(SignUpActivity.this);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        //logo_1.setImageBitmap(selectedImage);
                        logo_1.setImageBitmap(selectedImage);
                    }
                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                logo_1.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                cursor.close();
                            }
                        }
                    }
                    break;
            }
        }
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

        private void createFirebaseUser () {
            //displayProgressDialog("signing up...");
            userName = username.getText().toString();
            emailAddress = email.getText().toString();
            phoneNumber = phone.getText().toString();
            Password = password.getText().toString();
            //String newPass =  sha256(password);

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
            } else {
                user = new User();
                user.setEmailAddress(emailAddress);
                user.setPassword(Password);
                user.setPhoneNumber(phoneNumber);
                user.setUuid(uuid);

                mAuth.createUserWithEmailAndPassword(emailAddress, Password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                //User user = new User(emailAddress, phoneNumber, userName);

                                firebaseDatabase.getInstance().getReference("user")
                                        .child(Objects.requireNonNull(FirebaseAuth.getInstance()
                                                .getCurrentUser()).getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();
                                            sharedPrefsEditor.putBoolean(getResources().getString(R.string.user_auth_pref_key), true);
                                            sharedPrefsEditor.apply();
                                            Log.e("TAG", "onComplete: auth user created : " + mAuth.getCurrentUser().getUid());
                                            String uuid = mAuth.getCurrentUser().getUid();
                                            user.setUuid(mAuth.getCurrentUser().getUid());

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
                                }).addOnFailureListener(e -> resetFields());
                            }
                        });
//        private void saveInfo(User user, String id) {
//            //progressDialog.dismiss();
//            user.setPassword("");
//            databaseReference.child(uuid).setValue(user).addOnSuccessListener(task -> {
//                Toast.makeText(getApplicationContext(), "Registration Successful ", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(this, LoginActivity.class));
//
//            });
//        }
            }
        }

        private void resetFields () {
            username.setEnabled(true);
            password.setEnabled(true);
            email.setEnabled(true);
            phone.setEnabled(true);
        }
    }
