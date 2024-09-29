package com.session;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Stage;
import com.entities.Stagiaire;

/**
 * Session Bean implementation class StageDao
 */
@Stateless
public class StageDao implements IStageLocal {

   
	@PersistenceContext(unitName="UPStage") 
    EntityManager em;
	
    public StageDao() {
        
    }

	@Override
	public void AddStage(Stage s) {
		em.persist(s);
		
	}

	@Override
	public void DeleteStage(int code) {
	em.remove(this.getStage(code));
		
	}

	@Override
	public Stage getStage(int code) {
		Stage s=em.find(Stage.class, code);
		
		return s;
	}

	@Override
	public List<Stage> getAllStages() {
		
		Query q =em.createQuery("select s from Stage s");
		return q.getResultList();
	}

	@Override
	public void UpdateStage(Stage s) {
		em.merge(s);
		
	}
	
	@Override
     public Long countNbStages() {
		
		Query qr=em.createQuery("select count(*) from Stage");
		return (Long) qr.getSingleResult();
		
	}
	
	@Override
     public Long countNbStagesByDepartement(String nomDepartement) {
          Query query = em.createQuery("SELECT COUNT(s) FROM Stage s " +
                  "JOIN s.stagiaires st " +
                  "JOIN st.departement d " +
                  "WHERE d.nom = :nomDepartement");
    query.setParameter("nomDepartement", nomDepartement);
    return (Long) query.getSingleResult();
                         }

	 @Override
	   	public Long countNbStagesAffectes(String nomDepartement) {
		 Date dateNow=new Date();
	    Query query = em.createQuery("SELECT COUNT(DISTINCT st) FROM Stage st " +
	            "JOIN st.stagiaires s " +
	            "JOIN s.departement d " +
	            "WHERE d.nom = :nomDepartement AND (s IS NOT NULL AND st.dateFin> :dateNow)");

	    query.setParameter("nomDepartement", nomDepartement);
	    query.setParameter("dateNow", dateNow);
	    
	    return (Long) query.getSingleResult();
	   	}
	 
	 @Override
	   	public Long countNbStagesNonAffectes(String nomDepartement) {
		 Date dateNow=new Date();
	    Query query = em.createQuery("SELECT COUNT(DISTINCT st) FROM Stage st " +
	            "JOIN st.stagiaires s " +
	            "JOIN s.departement d " +
	            "WHERE d.nom = :nomDepartement AND (s IS NULL AND st.dateFin < :dateNow)");

	    query.setParameter("nomDepartement", nomDepartement);
	    query.setParameter("dateNow", dateNow);
	    
	    return (Long) query.getSingleResult();
	   	}
	 @Override
		public List<Stage> getStageBySujet(String sujet) {
			Query query=em.createQuery("select s from Stage s WHERE s.sujet = :sujet");
			query.setParameter("sujet", sujet);
			
			return query.getResultList();
		}
}
