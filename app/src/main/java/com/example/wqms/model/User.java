package com.example.wqms.model;

public class User {
    private String emailAddress;
    private String Password;
    private String phoneNumber;
    private String userName;
    private String uid;

    public User(String emailAddress, String phoneNumber, String userName) {
    }

    public User (String emailAddress, String Password, String phoneNumber, String userName){
        this.emailAddress = emailAddress;
        this.Password = Password;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.uid = uid;

    }
}

