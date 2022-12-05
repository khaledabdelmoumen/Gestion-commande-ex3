package com.esprit.exercice3.services;

import java.util.List;
import java.util.Set;

import com.esprit.exercice3.entities.Commande;

public interface CommandeService {
	
	
	//Afficher liste des commandes en cours ayant tous les textes livrés Q1
	public Set<Commande> AfficherListCommandesEncoursDelivres();
	//Afficher liste des commandes en cours ayant tous les textes validés Q2
	public Set<Commande> AfficherListCommandesValides();

	//Afficher La Liste des commandes en retards Q3
	public Set<Commande> AfficherListeCommanderEnRetards();
	
	//Calculer les couts pour charque commande affecter a un redacteur
	public void Caluculercoutparaffectation();
}
