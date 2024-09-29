package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entities.Compte;

/**
 * Session Bean implementation class CompteDao
 */
@Stateless
@LocalBean
public class CompteDao implements ICompteLocal {

	@PersistenceContext(unitName="UPStage")
    EntityManager em;
	
    public CompteDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddCompte(Compte c) {
		em.persist(c);
		
	}

	@Override
	public void DeleteCompte(int code) {
		em.remove(this.getCompte(code));
		
	}

	@Override
	public Compte getCompte(int code) {
		Compte c=em.find(Compte.class, code);
		return c;
	}

	@Override
	public List<Compte> getAllComptes() {
		Query query=em.createQuery("Select c from Compte c");
		return query.getResultList();
	}

	@Override
	public void UpdateCompte(Compte c) {
		em.merge(c);
		
	}
	


	@Override
	public boolean Connection(String login, String passwd) {
		boolean ok=false;
		TypedQuery<Compte> query = em.createQuery("SELECT u FROM Compte u WHERE u.login = :login AND u.passwd = :passwd", Compte.class);
        query.setParameter("login", login);
        query.setParameter("passwd", passwd);

        try {
        	Compte c= this.getCompte(login, passwd);
        	if(login.compareTo("")==0||c==null) {
    			return ok;
    		}
    		else if(c.getPasswd().compareTo(passwd)==0) {
    			ok=true;
    		}
    		return ok;
        } catch (NoResultException e) {
            return false; 
        }
			}
	
	@Override
	public Compte getCompte(String login, String passwd) {
		TypedQuery<Compte> query = em.createQuery("SELECT u FROM Compte u WHERE u.login = :login AND u.passwd = :passwd", Compte.class);
        query.setParameter("login", login);
        query.setParameter("passwd", passwd);

        try {
        	return query.getSingleResult();
        	
    	
        } catch (NoResultException e) {
            return null; 
        }
	}
    }
	
