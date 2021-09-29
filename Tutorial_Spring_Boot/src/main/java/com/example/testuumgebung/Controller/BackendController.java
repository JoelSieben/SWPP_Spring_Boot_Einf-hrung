package com.example.testuumgebung.Controller;

import com.example.testuumgebung.Request.LerngruppeRequest;
import com.example.testuumgebung.Request.LoginRequest;
import com.example.testuumgebung.Request.StudentRequest;
import com.example.testuumgebung.Service.LerngruppeService;
import com.example.testuumgebung.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test/v1")
public class BackendController {

    @Autowired
    private final StudentService studentService;
    private final LerngruppeService lerngruppeService;

    public BackendController(StudentService studentService, LerngruppeService lerngruppeService) {
        this.studentService = studentService;
        this.lerngruppeService = lerngruppeService;
    }

    @PostMapping(path = "/registrieren")
    public String registrieren(@RequestBody StudentRequest studentRequest){
        return studentService.registrieren(studentRequest);
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody LoginRequest loginRequest){
        boolean existiertStudent = studentService.login(loginRequest.getEmail(), loginRequest.getPasswort()).isPresent();
        if(existiertStudent){
            return "Anmeldung Erfolgreich";
        }
        throw new IllegalStateException("Nutzer konnte nicht gefunden werden");
    }

    @PostMapping(path = "/erzeugerGruppe/{id}")
    public String erzeugerGruppe(@RequestBody LerngruppeRequest lerngruppeRequest, @PathVariable int id){
        return lerngruppeService.erzeugeLerngruppe(lerngruppeRequest, id);

    }

    @PostMapping(path = "/hinzufugen/{gruppenId}/{studentenId}")
    public String studentHinzufugen(@PathVariable int gruppenId, @PathVariable int studentenId){
        return lerngruppeService.studentHinzufugen(gruppenId,studentenId);
    }

}
