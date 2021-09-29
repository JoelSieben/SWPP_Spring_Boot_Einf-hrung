package com.example.testuumgebung.Repositories;

import com.example.testuumgebung.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StundentRepo extends JpaRepository<Student, Integer> {

   Optional <Student> findByEmail(String email);

   Optional <Student> findByMatrikelnummer(int matrikelnummer);

   Optional <Student> findByEmailAndPasswort(String email, String passwort);

   Student findById(int id);
}
