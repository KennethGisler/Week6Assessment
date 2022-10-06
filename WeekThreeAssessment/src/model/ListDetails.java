package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 3, 2022
 */
@Entity
public class ListDetails {

	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate dateAdded;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Dealership dealership;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	private List<ListItem> itemList;
	
	//constructors
	public ListDetails() {
		super();
	}
	public ListDetails(int id,String listName, LocalDate dateAdded,Dealership dealership,List<ListItem> itemList) {
		this.id = id;
		this.listName = listName;
		this.dateAdded = dateAdded;
		this.dealership = dealership;
		this.itemList = itemList;
	}
	public ListDetails(String listName, LocalDate dateAdded,Dealership dealership,List<ListItem> itemList) {
		this.listName = listName;
		this.dateAdded = dateAdded;
		this.dealership = dealership;
		this.itemList = itemList;
	}
	public ListDetails(String listName,LocalDate dateAdded,Dealership dealership) {
		this.listName = listName;
		this.dateAdded = dateAdded;
		this.dealership = dealership;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getListName() {
		return listName;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public Dealership getDealership() {
		return dealership;
	}
	public List<ListItem> getItemList() {
		return itemList;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public void setDealership(Dealership dealership) {
		this.dealership = dealership;
	}
	public void setItemList(List<ListItem> itemList) {
		this.itemList = itemList;
	}
	
	//methods
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", dateAdded=" + dateAdded + ", dealership="+ dealership + ", itemList=" + itemList + "]";
	}
	
	
}
