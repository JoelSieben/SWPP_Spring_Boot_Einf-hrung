package com.example.testuumgebung.Service;

import com.example.testuumgebung.Entities.Lerngruppe;
import com.example.testuumgebung.Entities.Student;
import com.example.testuumgebung.Repositories.LerngruppeRepo;
import com.example.testuumgebung.Repositories.StundentRepo;
import com.example.testuumgebung.Request.LerngruppeRequest;
import org.springframework.stereotype.Service;

@Service
public class LerngruppeService {

    private final LerngruppeRepo lerngruppeRepo;
    private final StundentRepo stundentRepo;

    public LerngruppeService(LerngruppeRepo lerngruppeRepo, StundentRepo stundentRepo) {
        this.lerngruppeRepo = lerngruppeRepo;
        this.stundentRepo = stundentRepo;
    }

    public String erzeugeLerngruppe(LerngruppeRequest lerngruppeRequest, int id){

        Student student = stundentRepo.findById(id);
        Lerngruppe lerngruppe = new Lerngruppe(lerngruppeRequest.getName(), lerngruppeRequest.getBeschreibung());
        lerngruppe.erzeuger(student);
        lerngruppeRepo.save(lerngruppe);

        return "Lerngruppe erfolgreich angelegt";
    }

    public String studentHinzufugen(int gruppenId, int studentenId){

        Lerngruppe lerngruppe = lerngruppeRepo.findById(gruppenId);
        Student student = stundentRepo.findById(studentenId);
        lerngruppe.studentenHinzufugen(student);
        lerngruppeRepo.save(lerngruppe);

        return "Der Student wurder der Lerngruppe Hinzugefügt";
    }
}
