package com.session;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.Encadrant;
import com.entities.Stage;
import com.entities.Stagiaire;

/**
 * Session Bean implementation class StagiaireDao
 */
@Stateless
@LocalBean
public class StagiaireDao implements IStagiaireLocal {
	
	
	@PersistenceContext(unitName="UPStage")
    EntityManager em;  
	
    public StagiaireDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddStagiaire(Stagiaire s) {
		em.persist(s);
		
	}

	@Override
	public void DeleteStagiaire(int code) {
		em.remove(this.getStagiaire(code));
		
	}

	@Override
	public Stagiaire getStagiaire(int code) {
		Stagiaire s =em.find(Stagiaire.class, code);
		return s;
	}

	@Override
	public List<Stagiaire> getAllStagiaires() {
		Query query=em.createQuery("select s from Stagiaire s");
		return query.getResultList();
	}
	
	@Override
	public List<Stagiaire> getStagiaireByNomCIN(String nomcin) {
		Query query=em.createQuery("select s from Stagiaire s WHERE s.nom = :nomcin OR s.cin = :nomcin ");
		query.setParameter("nomcin", nomcin);
		query.setParameter("nomcin", nomcin);
		return query.getResultList();
	}

	
	@Override
	public void UpdateStagiaire(Stagiaire s) {
		em.merge(s);
		
	}
	
	@Override
	public Long countNbStagiaire() {
		
		Query qr=em.createQuery("select count(*) from Stagiaire");
		return (Long) qr.getSingleResult();
		
	}
	@Override
	public Long countNbStagiaireByDepartement(String nomDepartement) {
	    Query query = em.createQuery("SELECT COUNT(s) FROM Stagiaire s JOIN s.departement d WHERE d.nom = :nomDepartement");
	    query.setParameter("nomDepartement", nomDepartement);
	    return (Long) query.getSingleResult();
	}

	@Override
	public Stagiaire getStagiaireByCne(String cne) {
		Query query=em.createQuery("select s from Stagiaire s WHERE s.cne = :cne");
		query.setParameter("cne", cne);
		return (Stagiaire) query.getSingleResult();
	}
	
	public void affecterEncadrant(Stagiaire stagiaire, Encadrant encadrant) {
        stagiaire.setEncadrant(encadrant);
        em.merge(encadrant);
        
        // Sauvegardez les changements dans la base de données
        em.merge(stagiaire);
    }

    public void affecterStage(Stagiaire stagiaire, Stage stage) {
        stagiaire.setStage(stage);
        
        // Assurez-vous que le stage est correctement géré dans la base de données
        em.merge(stage);
        
        // Sauvegardez les changements dans la base de données
        em.merge(stagiaire);
    }
    @Override
	public Long countNbStagiaireCourt(String nomDepartement) {
    	Date dateNow=new Date();
    	Query query = em.createQuery("SELECT COUNT(s) FROM Stagiaire s " +
    	        "JOIN s.departement d " +
    	        "JOIN s.stage st " +
    	        "WHERE d.nom = :nomDepartement AND st.dateFin >:dateNow");

    	query.setParameter("nomDepartement", nomDepartement);
    	query.setParameter("dateNow", dateNow);
	    return (Long) query.getSingleResult();
	}
    
    @Override
	public Long countNbStagiaireArchive(String nomDepartement) {
    	Date dateNow=new Date();
    	Query query = em.createQuery("SELECT COUNT(s) FROM Stagiaire s " +
    	        "JOIN s.departement d " +
    	        "JOIN s.stage st " +
    	        "WHERE d.nom = :nomDepartement AND st.dateFin <:dateNow");

    	query.setParameter("nomDepartement", nomDepartement);
    	query.setParameter("dateNow", dateNow);
	    return (Long) query.getSingleResult();
	}
    
    @Override
   	public Long countNbStagiaireNouveau(String nomDepartement) {
       	Query query = em.createQuery("SELECT COUNT(s) FROM Stagiaire s " +
       			"JOIN s.departement d " +
       	        "WHERE d.nom = :nomDepartement AND s.stage IS NULL");

       	query.setParameter("nomDepartement", nomDepartement);
       	
   	    return (Long) query.getSingleResult();
   	}
    
    @Override
   	public List<Stagiaire> getStagiaireNouveau() {
    	TypedQuery<Stagiaire> query = em.createQuery(
                "SELECT s FROM Stagiaire s WHERE s.stage IS NULL", Stagiaire.class);
        return query.getResultList();
   	}

    @Override
	public List<Stagiaire> countNbStagiairesArchives() {
    	Date dateNow=new Date();
    	Query query = em.createQuery("SELECT s FROM Stagiaire s where (s.stage).dateFin <:dateNow");

    	
    	query.setParameter("dateNow", dateNow);
	    return query.getResultList();
	}
	
   

}
