package at.hakimst.Studentenverwaltung.Controler;

import at.hakimst.Studentenverwaltung.Service.StudentService;
import at.hakimst.Studentenverwaltung.Service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    StudentService studentService;

    public MyRestController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping("api/v1/")
    public ResponseEntity halloWelt()
    {
        return ResponseEntity.ok("Hallo Welt");
    }


    @PostMapping("api/v1/adddummystudenten/")
    public ResponseEntity dummyStudentEinfuegen()
    {
        this.studentService.studentHinzufuegenDummy();
        return ResponseEntity.ok("Studenten hinzugefügt");
    }

    @GetMapping("api/v1/gibanzahlstudenten/")
    public ResponseEntity gibAlleStudenten()
    {
        return ResponseEntity.ok("Anzahl Studenten: " + this.studentService.gibAlleStudenten().stream().count());
    }
}
