package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 6, 2022
 */
@Entity
@Table(name="dealership")
public class Dealership {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	/**
	 * 
	 */
	//constructors
	public Dealership() {
		super();
	}
	
	public Dealership(int id, String name,String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Dealership(String name,String address) {
		this.name = name;
		this.address = address;
	}

	//getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}

	//setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//methods
	
	@Override
	public String toString() {
		return "Dealership: [Name: " + this.name +",Address: " + this.address +",ID: " +this.id + "]";
	}
	

}
