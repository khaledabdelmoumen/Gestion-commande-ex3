package com.esprit.exercice3.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

@Entity
public class Redacteur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom_prenom;
	private String mail ;
	private String nom_societe;
	
	
	@OneToMany(mappedBy="redacteur",cascade = CascadeType.ALL,orphanRemoval= true)
	@JsonIgnore
	private Set<CommandeRedacteur> Commanderedacteur;


	
	
	//Constructors
	public Redacteur(String nom_prenom, String mail, String nom_societe) {
	
		this.nom_prenom = nom_prenom;
		this.mail = mail;
		this.nom_societe = nom_societe;
	}


	public Redacteur() {
		
	}

	//Getters AND Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom_prenom() {
		return nom_prenom;
	}


	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getNom_societe() {
		return nom_societe;
	}


	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}


	public Set<CommandeRedacteur> getCommanderedacteur() {
		return Commanderedacteur;
	}


	public void setCommanderedacteur(Set<CommandeRedacteur> commanderedacteur) {
		this.Commanderedacteur = commanderedacteur;
	}

	
	
}
