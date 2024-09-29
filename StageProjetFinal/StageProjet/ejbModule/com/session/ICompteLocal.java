package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Compte;

@Local
public interface ICompteLocal {

	public void AddCompte(Compte c);
	public void DeleteCompte(int code);
	public Compte getCompte(int code);
	public List<Compte> getAllComptes();
	public void UpdateCompte(Compte c);
	public boolean Connection(String login,String passwd);
	public  Compte getCompte(String login, String passwd);
}
