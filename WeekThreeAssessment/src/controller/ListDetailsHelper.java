package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 6, 2022
 */
public class ListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WeekThreeAssessment");
	/**
	 * 
	 */
	//constructors
	public ListDetailsHelper() {
		super();
	}
	
	//methods
	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

	public ListDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteList(ListDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> tq = em.createQuery("select detail from ListDetails detail where detail.id = :selectedId",ListDetails.class);
		
		tq.setParameter("selectedId", toDelete.getId());
		tq.setMaxResults(1);
		
		ListDetails result = tq.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateList(ListDetails listToUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(listToUpdate);
		em.getTransaction().commit();
		em.close();
		
	}
}
