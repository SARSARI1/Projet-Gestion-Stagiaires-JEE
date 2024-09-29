package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Absence;
import com.entities.Stagiaire;

@Local
public interface IAbsenceLocal {

	public void AddAbsence(Absence a);
	public void DeleteAbsence(int code);
	public Absence getAbsence(int code);
	public List<Absence> getAllAbsencets();
	public void UpdateAbsence(Absence a);
	public void marquerAbsence(Stagiaire stagiaire);
	 public Absence getAbsenceByStagiaireId(int idStagiaire);
}
