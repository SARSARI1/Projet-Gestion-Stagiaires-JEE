package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable{
	
	@OneToMany(mappedBy="departement")
	List<Stagiaire> stagiaires;

	@Id
	private int id_dep;
	
	@Column
	private String nom;

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(List<Stagiaire> stagiaires, int id_dep, String nom) {
		super();
		this.stagiaires = stagiaires;
		this.id_dep = id_dep;
		this.nom = nom;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public int getId_dep() {
		return id_dep;
	}

	public void setId_dep(int id_dep) {
		this.id_dep = id_dep;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
