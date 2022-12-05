package com.esprit.exercice3.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.exercice3.entities.CommandeRedacteur;
import com.esprit.exercice3.entities.Text;

@Repository
public interface TextRepository extends JpaRepository<Text,Integer>{

	Set<Text> findByCommanderedacteur(CommandeRedacteur commanderedacteur);
}
