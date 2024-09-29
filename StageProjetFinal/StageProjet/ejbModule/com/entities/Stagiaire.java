package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stagiaire")
public class Stagiaire implements Serializable{

	@ManyToOne
	@JoinColumn(name="id_stage") 
	private Stage stage;
	
	@OneToMany(mappedBy="stagiaire", orphanRemoval = true) 
	private List<Absence> absences;
	
	@ManyToOne
	@JoinColumn(name="id_encadrant") 
	private Encadrant encadrant;
	
	@ManyToOne
	@JoinColumn(name="id_departement")
	private Departement departement;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_stagiaire;
	
	@Column
	private String prenom;
	
	@Column
	private String nom;
	
	@Column(unique=true)
	private String cin;
	
	@Column
	private String etablissment;
	
	@Column
	private String filiere;
	
	@Column
	private String adresse;
	
	@Column
	private String email;
	
	@Column
	private String telephone;
	
	@Temporal(TemporalType.DATE) 
	private Date dateN;
	
	
	
	private enum etat{nouveaux, en_cours, en_archive}



	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Stagiaire(Stage stage, List<Absence> absences, Encadrant encadrant, Departement departement,
			int id_stagiaire, String prenom, String nom, String cin, String etablissment, String filiere,
			String adresse, String email, String telephone, Date dateN) {
		super();
		this.stage = stage;
		this.absences = absences;
		this.encadrant = encadrant;
		this.departement = departement;
		this.id_stagiaire = id_stagiaire;
		this.prenom = prenom;
		this.nom = nom;
		this.cin = cin;
		this.etablissment = etablissment;
		this.filiere = filiere;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.dateN = dateN;
	}



	public Stage getStage() {
		return stage;
	}



	public void setStage(Stage stage) {
		this.stage = stage;
	}



	public List<Absence> getAbsences() {
		return absences;
	}



	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}



	public Encadrant getEncadrant() {
		return encadrant;
	}



	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}



	public Departement getDepartement() {
		return departement;
	}



	public void setDepartement(Departement departement) {
		this.departement = departement;
	}



	public int getId_stagiaire() {
		return id_stagiaire;
	}



	public void setId_stagiaire(int id_stagiaire) {
		this.id_stagiaire = id_stagiaire;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	public String getEtablissment() {
		return etablissment;
	}



	public void setEtablissment(String etablissment) {
		this.etablissment = etablissment;
	}



	public String getFiliere() {
		return filiere;
	}



	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public Date getDateN() {
		return dateN;
	}



	public void setDateN(Date dateN) {
		this.dateN = dateN;
	};
	
	
}
