package com.entities;

import java.io.Serializable;

import java.time.Period;
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
@Table(name="stage")
public class Stage implements Serializable{

	@OneToMany(mappedBy="stage" , orphanRemoval = true) 
	private List<Stagiaire> stagiaires;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  int id_stage;
	
	@Column
	private String sujet;
	
	@Temporal(TemporalType.DATE) 
	private Date dateDebut ;
	
	@Temporal(TemporalType.DATE) 
	private Date dateFin ;
	
	@Column
	private String division ;
	
	@Column
	private String type ;
	

	private enum etat{affecté, non_affecté};
	
	private Period periode;

	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stage(List<Stagiaire> stagiaires, int id_stage, String sujet, Date dateDebut, Date dateFin, String division,
			String type, Period periode) {
		super();
		this.stagiaires = stagiaires;
		this.id_stage = id_stage;
		this.sujet = sujet;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.division = division;
		this.type = type;
		this.periode = periode;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public int getId_stage() {
		return id_stage;
	}

	public void setId_stage(int id_stage) {
		this.id_stage = id_stage;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Period getPeriode() {
		return periode;
	}

	public void setPeriode(Period periode) {
		this.periode = periode;
	}
	
	
}
