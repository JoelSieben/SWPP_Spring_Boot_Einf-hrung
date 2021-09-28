package com.example.testuumgebung.Repositories;

import com.example.testuumgebung.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StundentRepo extends JpaRepository<Student, Integer> {
}
