package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private DbZugriff dbZugriff;

    public StudentServiceImpl(DbZugriff dbZugriff) {
        this.dbZugriff = dbZugriff;
    }

    public void studentHinzufuegenDummy()
    {
        for(long i = 1;i<10;i++) {
            this.dbZugriff.studentSpeichern(new Student("Hallo Student"));
        }
    }

    public List<Student> gibAlleStudenten()
    {

        return this.dbZugriff.gibMirAlleStudenten();
    }
}
