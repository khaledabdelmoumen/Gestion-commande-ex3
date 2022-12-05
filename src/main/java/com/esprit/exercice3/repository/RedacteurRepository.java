package com.esprit.exercice3.repository;

import com.esprit.exercice3.entities.Redacteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RedacteurRepository extends JpaRepository<Redacteur,Integer>{

}
