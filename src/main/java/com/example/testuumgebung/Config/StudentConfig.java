package com.example.testuumgebung.Config;

import com.example.testuumgebung.Entities.Student;
import com.example.testuumgebung.Repositories.StundentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Autowired
    private final StundentRepo stundentRepo;

    public StudentConfig(StundentRepo stundentRepo) {
        this.stundentRepo = stundentRepo;
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Student student1 = new Student(
                    "Joel",
                    "Sieben",
                    "joel.sieben@gmail.com",
                    12345678,
                    "123",
                    null

            );
            Student student2 = new Student(
                    "Christoph",
                    "Mark",
                    "ch.mark@gmail.com",
                    12345678,
                    "123",
                    null

            );
            stundentRepo.saveAll(
                    List.of(student1, student2)
            );
        };

    }
}
