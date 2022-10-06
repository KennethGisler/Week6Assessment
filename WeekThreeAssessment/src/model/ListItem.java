package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Sep 28, 2022
 */
@Entity
@Table(name="items")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	int id;
	@Column(name="CARMAKE") 
	private String carMake;
	@Column(name="CARMODEL")
	private String carModel;
	@Column(name="YEARMADE")
	private int yearMade;
	/**
	 * 
	 */
	public ListItem() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public ListItem(String make, String model, int yearMade) {
		this.carMake = make;
		this.carModel = model;
		this.yearMade = yearMade;
	}
	
	public ListItem(String model, int year) {
		this.carModel = model;
		this.yearMade = year;
	}

	//getters
	public String getCarMake() {
		return carMake;
	}
	
	public String getCarModel() {
		return carModel;
	}
	public int getYearMade() {
		return yearMade;
	}
	public int getId(){
		return this.id;
	}
	
	//setters
	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}
	public void setId(int newID) {
		this.id = newID;
	}

	//methods
	public String returnItemDetails() {
		return "Car's | Make: " + this.carMake + " | Model:  " + this.carModel + " | Year: " + this.yearMade + " |";
	}
}
