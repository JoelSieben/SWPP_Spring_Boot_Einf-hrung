package com.example.testuumgebung.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lerngruppe {

    @Id
    @SequenceGenerator(name= "lernSequence", sequenceName = "lernSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lernSequence")

    private int id;

    private String name;
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    @ManyToMany
    @JoinTable(
    name = "Grppenmitglieder",
    joinColumns = @JoinColumn(name = "GruppenId"),
    inverseJoinColumns = @JoinColumn(name = "studentenId")
    )

    private Set<Student> gruppenmitglied = new HashSet<>();

    public Lerngruppe() {
    }

    public Lerngruppe(int id, String name, String beschreibung) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public Lerngruppe(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void erzeuger(Student student){

        this.student = student;
    }

    public void studentenHinzufugen(Student student){

        gruppenmitglied.add(student);
    }
}
