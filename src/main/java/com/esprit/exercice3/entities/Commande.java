package com.esprit.exercice3.entities;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;



@Entity

public class Commande implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String id_devis;
	private String titre;
	private int nbr_txt;
	@Column(name="created_at")
	private Date Date_creation;
	private String language;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="commande")
	@JsonIgnore
	private Set<Text> texts;
	
	@OneToMany(mappedBy="commande",cascade = CascadeType.ALL,orphanRemoval= true)
	@JsonIgnore
	private Set<CommandeRedacteur> Commanderedacteur;
	
	//Constructors
	
	public Commande(String id_devis, String titre, int nbr_txt, Date date_creation, String language, Set<Text> texts) {
		this.id_devis = id_devis;
		this.titre = titre;
		this.nbr_txt = nbr_txt;
		this.Date_creation = date_creation;
		this.language = language;
		this.texts = texts;
		Commanderedacteur = new HashSet<>();
	}
	
	public Commande() {
		
	}

	//Getters and Setters 
	

	public int getId() {
		return id;
	}


	


	public void setId(int id) {
		this.id = id;
	}


	public String getId_devis() {
		return id_devis;
	}


	public void setId_devis(String id_devis) {
		this.id_devis = id_devis;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getNbr_txt() {
		return nbr_txt;
	}


	public void setNbr_txt(int nbr_txt) {
		this.nbr_txt = nbr_txt;
	}


	public Date getDate_creation() {
		return Date_creation;
	}


	public void setDate_creation(Date date_creation) {
		Date_creation = date_creation;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public Set<Text> getTexts() {
		return texts;
	}


	public void setTexts(Set<Text> texts) {
		this.texts = texts;
	}


	public Set<CommandeRedacteur> getCommanderedacteur() {
		return Commanderedacteur;
	}


	public void setCommanderedacteur(Set<CommandeRedacteur> commanderedacteur) {
		this.Commanderedacteur = commanderedacteur;
	}
	
	
	
	


	
	
	
}
