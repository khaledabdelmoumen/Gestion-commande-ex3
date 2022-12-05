package com.esprit.exercice3.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.Set;

@Entity
public class CommandeRedacteur {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="commande_id")
	@JsonIgnore
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="redacteur_id")
	@JsonIgnore
	private Redacteur redacteur;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="commanderedacteur")
	@JsonIgnore
	private Set<Text> textsCommande;
	
	private double tarif;
	
	private Date deadline;
	
	private int nbr_text;
	
	private int nbr_mot_max;
	
	private int nbr_mot_min;
	
	private int nbr_mot_achete;
	
	@Column(name="Aureel")
	private boolean reel;
    
	
	
	//Constructors
	
	public CommandeRedacteur() {
		super();
	}

	public CommandeRedacteur(int id, Commande commande, Redacteur redacteur, Set<Text> textsCommande, double tarif,
			Date deadline, int nbr_text, int nbr_mot_max, int nbr_mot_min, int nbr_mot_achete, boolean reel) {
		super();
		this.id = id;
		this.commande = commande;
		this.redacteur = redacteur;
		this.textsCommande = textsCommande;
		this.tarif = tarif;
		this.deadline = deadline;
		this.nbr_text = nbr_text;
		this.nbr_mot_max = nbr_mot_max;
		this.nbr_mot_min = nbr_mot_min;
		this.nbr_mot_achete = nbr_mot_achete;
		this.reel = reel;
	}

	//Getters AND setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Redacteur getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(Redacteur redacteur) {
		this.redacteur = redacteur;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getNbr_text() {
		return nbr_text;
	}

	public void setNbr_text(int nbr_text) {
		this.nbr_text = nbr_text;
	}

	public int getNbr_mot_max() {
		return nbr_mot_max;
	}

	public void setNbr_mot_max(int nbr_mot_max) {
		this.nbr_mot_max = nbr_mot_max;
	}

	public int getNbr_mot_min() {
		return nbr_mot_min;
	}

	public void setNbr_mot_min(int nbr_mot_min) {
		this.nbr_mot_min = nbr_mot_min;
	}

	public int getNbr_mot_achete() {
		return nbr_mot_achete;
	}

	public void setNbr_mot_achete(int nbr_mot_achete) {
		this.nbr_mot_achete = nbr_mot_achete;
	}

	public boolean isReel() {
		return reel;
	}

	public void setReel(boolean reel) {
		this.reel = reel;
	}
	
	
}
