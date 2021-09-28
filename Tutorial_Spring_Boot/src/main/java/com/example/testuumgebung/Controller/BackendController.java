package com.example.testuumgebung.Controller;

import com.example.testuumgebung.Request.LoginRequest;
import com.example.testuumgebung.Request.StudentRequest;
import com.example.testuumgebung.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test/v1")
public class BackendController {

    @Autowired
    private final StudentService studentService;

    public BackendController(StudentService studentService) {
        this.studentService = studentService;
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
}
