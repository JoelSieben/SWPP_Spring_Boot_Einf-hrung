package com.example.testuumgebung.Entities;

import javax.persistence.*;

@Entity
@Table (name="Stundent")
public class Student {

    @Id
    @SequenceGenerator(name="StudentSequence", sequenceName = "studentSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentSequence")

    private int id;

    private String vorname;
    private String nachname;
    private String email;
    private int matrikelnummer;
    private String passwort;
    @Lob
    private byte[] profilbild;

    public Student() {
    }

    public Student(String vorname, String nachname, String email, int matrikelnummer, String passwort, byte[] profilbild) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.matrikelnummer = matrikelnummer;
        this.passwort = passwort;
        this.profilbild = profilbild;
    }

    public Student(int id, String vorname, String nachname, String email, int matrikelnummer, String passwort, byte[] profilbild) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.matrikelnummer = matrikelnummer;
        this.passwort = passwort;
        this.profilbild = profilbild;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public byte[] getProfilbild() {
        return profilbild;
    }

    public void setProfilbild(byte[] profilbild) {
        this.profilbild = profilbild;
    }
}
