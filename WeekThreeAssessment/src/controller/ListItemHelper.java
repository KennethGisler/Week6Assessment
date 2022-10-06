package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Sep 28, 2022
 */
public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WeekThreeAssessment");
	/**
	 * 
	 */
	public ListItemHelper() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	//methods
	public void insertItem(ListItem li) {
		System.out.println(li.toString());
		System.out.println("Adding this car!!!!!!| " + li.getCarMake() + " | " + li.getCarModel() + " | " + li.getYearMade() + " |");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}
	
	//delete item
	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.carMake = :selectedCarMake and li.carModel = :selectedCarModel and li.yearMade = :selectedYearMade", ListItem.class);
		
		typedQuery.setParameter("selectedCarMake", toDelete.getCarMake());
		typedQuery.setParameter("selectedCarModel", toDelete.getCarModel());
		typedQuery.setParameter("selectedYearMade", toDelete.getYearMade());
		
		typedQuery.setMaxResults(1);
		
		ListItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	//search by Car Make
	public List<ListItem> searchForItemByCarMake(String make) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.carMake = :selectedCarMake", ListItem.class);
		typedQuery.setParameter("selectedCarMake", make);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	//search by Model
	public List<ListItem> searchForItemByCarModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.carModel = :selectedCarModel", ListItem.class);
		typedQuery.setParameter("selectedCarModel", model);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	//search by Year Made
	public List<ListItem> searchForItemByYearMade(int year){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.yearMade = :selectedYearMade", ListItem.class);
		typedQuery.setParameter("selectedYearMade", year);
		
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public ListItem searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}
	
	//update item
	public void updateItem(ListItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	//clean up
	public void cleanUp(){
		emfactory.close();
	}
}
