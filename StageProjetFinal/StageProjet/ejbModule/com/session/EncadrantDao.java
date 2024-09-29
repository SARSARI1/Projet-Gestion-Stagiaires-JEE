package com.session;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Encadrant;
import com.entities.Stage;

/**
 * Session Bean implementation class EncadrantDao
 */
@Stateless
@LocalBean
public class EncadrantDao implements IEncadrantLocal {

	@PersistenceContext(unitName="UPStage")
    EntityManager em;
	
	
    public EncadrantDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddEncadrant(Encadrant e) {
		em.persist(e);
		
	}

	@Override
	public void DeleteEncadrant(int code) {
		em.remove(this.getEncadrant(code));
		
	}

	@Override
	public Encadrant getEncadrant(int code) {
Encadrant e=em.find(Encadrant.class,code);
		return e;
	}

	@Override
	public List<Encadrant> getAllEncadrants() {
		Query query=em.createQuery("Select e from Encadrant e");
		return query.getResultList();
	}

	@Override
	public void UpdateEncadrant(Encadrant e) {
		em.merge(e);
		
	}
	
	
	@Override
public Long countNbEncadrants() {
		
		Query qr=em.createQuery("select count(*) from Encadrant");
		return (Long) qr.getSingleResult();
		
	}
	
	@Override
     public Long countNbStagesByEncadrant(String nomDepartement) {
          Query query = em.createQuery("SELECT COUNT(DISTINCT e) FROM Encadrant e " +
                  "JOIN e.stagiaires st " +
                  "JOIN st.departement d " +
                  "WHERE d.nom = :nomDepartement");
    query.setParameter("nomDepartement", nomDepartement);
    return (Long) query.getSingleResult();
                         }
	
	 @Override
	   	public Long countNbEncadrantsAffectes(String nomDepartement) {
		
	    Query query = em.createQuery("SELECT COUNT(DISTINCT e) FROM Encadrant e " +
	            "JOIN e.stagiaires s " +
	            "JOIN s.departement d " +
	            "WHERE d.nom = :nomDepartement AND (s IS NOT NULL )");

	    query.setParameter("nomDepartement", nomDepartement);
	   
	    
	    return (Long) query.getSingleResult();
	   	}
	 
	 @Override
	   	public Long countNbEncadrantsNonAffectes(String nomDepartement) {
		 
	    Query query = em.createQuery("SELECT COUNT(DISTINCT e) FROM Encadrant e " +
	            "JOIN e.stagiaires s " +
	            "JOIN s.departement d " +
	            "WHERE d.nom = :nomDepartement AND (s IS NULL)");

	    query.setParameter("nomDepartement", nomDepartement);
	   
	    
	    return (Long) query.getSingleResult();
	   	}
	 @Override
		public List<Encadrant> getEncadrantByNom(String nom) {
			Query query=em.createQuery("select e from Encadrant e WHERE e.nom = :nom");
			query.setParameter("nom", nom);
			
			return query.getResultList();
		}

}
