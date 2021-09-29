package com.example.testuumgebung.Request;

public class LerngruppeRequest {

    private String name;
    private String beschreibung;

    public LerngruppeRequest(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
