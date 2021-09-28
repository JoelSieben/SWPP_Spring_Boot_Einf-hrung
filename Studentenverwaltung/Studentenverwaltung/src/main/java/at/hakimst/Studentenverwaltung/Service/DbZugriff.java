package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Student;

import java.util.List;

public interface DbZugriff {
    public Student studentSpeichern(Student student);
    public List<Student> gibMirAlleStudenten();
}
