package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class to provide the single instance of Entity Manger and Entity Manager Factory 
 * 
 * @author Claudinei Dias
 */
public class ConAdmin {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    /**
     * Returns the entity manager factory instance 
     */
    public static EntityManagerFactory getEMF(){
    	if (emf == null){
    		 emf = Persistence.createEntityManagerFactory("webapp");
    	}
    	return emf;
    }
    
    /**
     * Returns the entity manager instance
     */
    public static EntityManager getEM(){
    	if (em == null){
    		em = getEMF().createEntityManager();
    	}
    	return em;
    }
}
