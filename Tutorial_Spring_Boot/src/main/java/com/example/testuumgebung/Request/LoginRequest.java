package com.example.testuumgebung.Request;

public class LoginRequest {

    private String email;
    private String passwort;

    public LoginRequest(String email, String passwort) {
        this.email = email;
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }
}
