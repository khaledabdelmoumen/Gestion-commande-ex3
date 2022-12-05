package com.esprit.exercice3.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Date;
@Entity
public class Text implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Titre_text;
	private String contenu;
	private Date created_at;
	private Date Delivered_at;
	private Date Validated_at;
	private int total_number_of_text_added;
	
	@ManyToOne
	@JsonIgnore
	public Commande commande;
	
	@ManyToOne
	@JoinColumn(name="commande_redacteur_relation")
	@JsonIgnore
	public CommandeRedacteur commanderedacteur;
	
   
	//Constructors
	public Text() {
		
	}

    //Getters AND Setters

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitre_text() {
		return Titre_text;
	}



	public void setTitre_text(String titre_text) {
		Titre_text = titre_text;
	}



	public String getContenu() {
		return contenu;
	}



	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	public Date getCreated_at() {
		return created_at;
	}



	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	public Date getDelivered_at() {
		return Delivered_at;
	}



	public void setDelivered_at(Date delivered_at) {
		Delivered_at = delivered_at;
	}



	public Date getValidated_at() {
		return Validated_at;
	}



	public void setValidated_at(Date validated_at) {
		Validated_at = validated_at;
	}



	public int getTotal_number_of_text_added() {
		return total_number_of_text_added;
	}



	public void setTotal_number_of_text_added(int total_number_of_text_added) {
		this.total_number_of_text_added = total_number_of_text_added;
	}



	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	public CommandeRedacteur getCommanderedacteur() {
		return commanderedacteur;
	}



	public void setCommanderedacteur(CommandeRedacteur commanderedacteur) {
		this.commanderedacteur = commanderedacteur;
	}



	public Text(int id, String titre_text, String contenu, Date created_at, Date delivered_at, Date validated_at,
			int total_number_of_text_added, Commande commande, CommandeRedacteur commanderedacteur) {
		super();
		this.id = id;
		Titre_text = titre_text;
		this.contenu = contenu;
		this.created_at = created_at;
		Delivered_at = delivered_at;
		Validated_at = validated_at;
		this.total_number_of_text_added = total_number_of_text_added;
		this.commande = commande;
		this.commanderedacteur = commanderedacteur;
	}



	
}
