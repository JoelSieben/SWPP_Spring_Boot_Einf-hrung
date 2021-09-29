package com.example.testuumgebung.Repositories;

import com.example.testuumgebung.Entities.Lerngruppe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LerngruppeRepo extends JpaRepository<Lerngruppe,Integer> {

    Lerngruppe findById(int id);
}
