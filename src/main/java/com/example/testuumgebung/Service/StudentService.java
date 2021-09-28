package com.example.testuumgebung.Service;

import com.example.testuumgebung.Entities.Student;
import com.example.testuumgebung.Repositories.StundentRepo;
import com.example.testuumgebung.Request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentService {

    @Autowired
    private final StundentRepo stundentRepo;

    public StudentService(StundentRepo stundentRepo) {
        this.stundentRepo = stundentRepo;
    }

    public String nutzerRegistieren(Student student){

        boolean studentExistiert = stundentRepo.findByEmail(student.getEmail()).isPresent();

        if(studentExistiert){
            throw new IllegalStateException("Email bereits vergeben");
        }

        Random martrikelnummerRandom = new Random();
        int num = martrikelnummerRandom.nextInt(999999)+ 1000000;
        student.setMatrikelnummer(num);

        boolean matrikerExistiert = stundentRepo.findByMatrikelnummer(student.getMatrikelnummer()).isPresent();

        while (matrikerExistiert){
            Random matrikelnuummerRandom2 = new Random();
            int num2 = matrikelnuummerRandom2.nextInt(999999)+ 1000000;
            student.setMatrikelnummer(num2);
            matrikerExistiert = stundentRepo.findByMatrikelnummer(student.getMatrikelnummer()).isPresent();
        }

        stundentRepo.save(student);
        return "Student wurde gespeichert";
    }

    public String registrieren(StudentRequest studentRequest){
        return nutzerRegistieren(new Student(

                studentRequest.getVorname(),
                studentRequest.getNachname(),
                studentRequest.getEmail(),
                studentRequest.getPasswort(),
                studentRequest.getProfilbild()
        )
        );
    }
}
