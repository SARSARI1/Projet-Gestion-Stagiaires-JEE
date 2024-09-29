package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="encadrant")
public class Encadrant implements Serializable{

	@OneToMany(mappedBy="encadrant", orphanRemoval = true) 
	private List<Stagiaire> stagiaires;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_encadrant;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	

	private enum etat{affecté, non_affecté}


	public Encadrant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Encadrant(List<Stagiaire> stagiaires, int id_encadrant, String nom, String prenom) {
		super();
		this.stagiaires = stagiaires;
		this.id_encadrant = id_encadrant;
		this.nom = nom;
		this.prenom = prenom;
	}


	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}


	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}


	public int getId_encadrant() {
		return id_encadrant;
	}


	public void setId_encadrant(int id_encadrant) {
		this.id_encadrant = id_encadrant;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	};
	
	
}
