package com.session;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Absence;
import com.entities.Stagiaire;

/**
 * Session Bean implementation class AbsenceDao
 */
@Stateless
@LocalBean
public class AbsenceDao implements IAbsenceLocal {

	@PersistenceContext(unitName="UPStage")
    EntityManager em;
    public AbsenceDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddAbsence(Absence a) {
		em.persist(a);
		
	}

	@Override
	public void DeleteAbsence(int code) {
		em.remove(this.getAbsence(code));
		
	}

	@Override
	public Absence getAbsence(int code) {
		Absence a=em.find(Absence.class, code);
		return a;
	}

	@Override
	public List<Absence> getAllAbsencets() {
		Query query=em.createQuery("Select a from Absence a order by a.date_abs DESC");
		return query.getResultList();
	}

	@Override
	public void UpdateAbsence(Absence a) {
		em.merge(a);
		
	}
	
	@Override
	public void marquerAbsence(Stagiaire stagiaire) {
        Date dateAbs = new Date(); // Utilisez la date actuelle

        Absence absence = new Absence();
        absence.setDate_abs(dateAbs);
        absence.setStagiaire(stagiaire);

        this.AddAbsence(absence);
        
    }

	@Override
	  public Absence getAbsenceByStagiaireId(int idStagiaire) {
	   
	            Query query = em.createQuery("SELECT a FROM Absence a WHERE a.stagiaire.id_stagiaire = :idStagiaire order by a.date_abs DESC");
	            query.setParameter("idStagiaire", idStagiaire);
	            List<Absence> absences = query.getResultList();
	            if (absences.isEmpty()) {
	                // Aucune absence trouvée pour le stagiaire avec l'ID spécifié
	                return null; // Ou une autre indication de non-existence
	            } else {
	                // Il peut y avoir plusieurs absences si vous modifiez la requête pour en tenir compte
	                return absences.get(0); // Retournez la première absence trouvée
	            }
	        
	    }
}
