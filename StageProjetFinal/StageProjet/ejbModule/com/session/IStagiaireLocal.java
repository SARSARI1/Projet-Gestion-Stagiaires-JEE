package com.session;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import com.entities.Stagiaire;

@Local
public interface IStagiaireLocal {

	public void AddStagiaire(Stagiaire s);
	public void DeleteStagiaire(int code);
	public Stagiaire getStagiaire(int code);
	public List<Stagiaire> getAllStagiaires();
	public void UpdateStagiaire(Stagiaire s);
	//public Stagiaire getStagiaireByNom(String nom);
	public Stagiaire getStagiaireByCne(String cne);
    public Long countNbStagiaire();
	public Long countNbStagiaireByDepartement(String nomDepartement);
	public Long countNbStagiaireCourt(String nomDepartement);
	public Long countNbStagiaireArchive(String nomDepartement);
	public Long countNbStagiaireNouveau(String nomDepartement);
	public List<Stagiaire> getStagiaireByNomCIN(String nomcin);
	public List<Stagiaire> getStagiaireNouveau();
	public List<Stagiaire> countNbStagiairesArchives();
}
