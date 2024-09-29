package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="absence")
public class Absence implements Serializable{

	@ManyToOne
	@JoinColumn(name="id_stagiaire") 
	private Stagiaire stagiaire;
	
	
	@Id
	private int id_abs;
	
	@Temporal(TemporalType.DATE) 
	private Date date_abs;

	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Absence(Stagiaire stagiaire, int id_abs, Date date_abs) {
		super();
		this.stagiaire = stagiaire;
		this.id_abs = id_abs;
		this.date_abs = date_abs;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public int getId_abs() {
		return id_abs;
	}

	public void setId_abs(int id_abs) {
		this.id_abs = id_abs;
	}

	public Date getDate_abs() {
		return date_abs;
	}

	public void setDate_abs(Date date_abs) {
		this.date_abs = date_abs;
	}
	
	
}
