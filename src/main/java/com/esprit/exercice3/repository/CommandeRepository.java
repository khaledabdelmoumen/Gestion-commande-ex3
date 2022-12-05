package com.esprit.exercice3.repository;

 import com.esprit.exercice3.entities.Commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommandeRepository extends JpaRepository<Commande,Integer> {

}
