package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dealership;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 6, 2022
 */
public class DealershipHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WeekThreeAssessment");
	/**
	 * 
	 */
	public DealershipHelper() {
		super();
	}
	
	public void insertDealership(Dealership ds) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ds);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Dealership> showAllDealerships(){
		EntityManager em = emfactory.createEntityManager();
		List<Dealership> allDealerships = em.createQuery("SELECT s FROM Dealership s").getResultList();
		return allDealerships;
	}
	
	public Dealership findDealership(String name,String address) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Dealership> typedQuery = em.createQuery("select ds from Dealership ds where ds.name = :selectedName and ds.address = :selectedAddress",Dealership.class);
		
		typedQuery.setParameter("selectedName", name);
		typedQuery.setParameter("selectedAddress", address);
		
		typedQuery.setMaxResults(1);
		
		Dealership dealershipFound;
		try {
			dealershipFound = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			dealershipFound = new Dealership(name,address);
		}
		
		em.close();
		return dealershipFound;
	}

	

}
