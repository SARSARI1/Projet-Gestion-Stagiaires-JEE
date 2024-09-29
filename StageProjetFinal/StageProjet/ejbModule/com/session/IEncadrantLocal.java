package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Encadrant;

@Local
public interface IEncadrantLocal {

	
	public void AddEncadrant(Encadrant e);
	public void DeleteEncadrant(int code);
	public Encadrant getEncadrant(int code);
	public List<Encadrant> getAllEncadrants();
	public void UpdateEncadrant(Encadrant e);
	public Long countNbEncadrants();
	public Long countNbStagesByEncadrant(String nomDepartement);
	public Long countNbEncadrantsAffectes(String nomDepartement);
	public Long countNbEncadrantsNonAffectes(String nomDepartement);
	public List<Encadrant> getEncadrantByNom(String nom);
	
}
