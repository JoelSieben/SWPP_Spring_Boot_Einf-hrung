package at.hakimst.Studentenverwaltung.Repos;

import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Service.DbZugriff;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBZugriffJPAH2 implements DbZugriff {

    StudentRepo studentRepo;

    public DBZugriffJPAH2(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        this.studentRepo.save(student);
        return null;
    }

    @Override
    public List<Student> gibMirAlleStudenten() {
        return this.studentRepo.findAll();
    }
}
