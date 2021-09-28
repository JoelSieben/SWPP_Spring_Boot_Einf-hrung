package com.example.testuumgebung.Request;

public class StudentRequest {

    private String vorname;
    private String nachname;
    private String email;
    private String passwort;
    private byte[] profilbild;

    public StudentRequest(String vorname, String nachname, String email, String passwort, byte[] profilbild) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.passwort = passwort;
        this.profilbild = profilbild;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public byte[] getProfilbild() {
        return profilbild;
    }
}
