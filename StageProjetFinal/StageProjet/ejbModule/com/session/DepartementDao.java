package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Departement;
import com.entities.Stagiaire;

/**
 * Session Bean implementation class DepartementDao
 */
@Stateless
@LocalBean
public class DepartementDao implements IDepartementLocal {

	@PersistenceContext(unitName="UPStage")
    EntityManager em;
	
    public DepartementDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddDepartement(Departement d) {
		em.persist(d);
		
	}

	@Override
	public void DeleteDepartement(Departement d) {
		em.remove(d);
		
	}

	@Override
	public Departement getDepartement(int code) {
		Departement d=em .find(Departement.class, code);
		return d;
	}

	@Override
	public List<Departement> getAllDepartements() {
		Query query=em.createQuery("Select d from Departement d");
		return query.getResultList();
	}

	@Override
	public void UpdateStagiaire(Departement d) {
		em.merge(d);
	}
	
	

}
