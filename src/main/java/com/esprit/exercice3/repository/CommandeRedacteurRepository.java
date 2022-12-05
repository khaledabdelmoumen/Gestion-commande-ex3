package com.esprit.exercice3.repository;

 import com.esprit.exercice3.entities.Commande;
import com.esprit.exercice3.entities.CommandeRedacteur;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CommandeRedacteurRepository extends JpaRepository<CommandeRedacteur,Integer>{

	Set<CommandeRedacteur> findByCommande(Commande commande);

}
