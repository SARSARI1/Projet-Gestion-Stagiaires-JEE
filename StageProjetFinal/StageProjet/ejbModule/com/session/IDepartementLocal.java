package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Departement;


@Local
public interface IDepartementLocal {
	
	public void AddDepartement(Departement d);
	public void DeleteDepartement(Departement d);
	public Departement getDepartement(int code);
	public List<Departement> getAllDepartements();
	public void UpdateStagiaire(Departement d);

}
