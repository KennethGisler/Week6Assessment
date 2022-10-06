import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Sep 28, 2022
 */
public class StartProgram {
	static Scanner userInput = new Scanner(System.in);
	static String userText = "";
	static ListItemHelper lih = new ListItemHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runApp();
	}
	//methods
	
	//app
	public static void runApp() { //runs the app
		while(!userText.equalsIgnoreCase("stop")) {
			System.out.println("Hello! Welcome to car list!");
			System.out.println("Let's make a groovy list about some cars!");
			System.out.println("     -Type \"add\" to add a car");
			System.out.println("     -Type \"delete\" to delet an item from the list"); //tells the user what the inputs are
			System.out.println("     -Type \"edit\" to edit an entry");
			System.out.println("     -Type \"veiwall\" to see all the cars in the list");
			System.out.println("     -Type \"stop\" to exit the program");
			
			userText = userInput.next(); //gets the user input
			userInput.nextLine();
			
			userText = userText.toLowerCase(); //puts it to lower and checks to see if it's a proper response
			if(userText.equals("add")) {
				addItem();
			}else if(userText.equals("delete")) {
				deleteItem();
			}else if(userText.equals("edit")) {
				editItem();
			}else if(userText.equals("veiwall")) {
				viewTheList();
			}else if(userText.equals("stop")) {
				lih.cleanUp();
				System.out.println("Have a nice day!");
			}else {
				System.out.println("Didn't quite get that! PLease input a command from the list!");
			}
	}
	

}
	
	//addItem
	private static void addItem() {
		String make,model;
		int year;
		System.out.print("Enter the Make of the car: ");
		make = userInput.nextLine();
		System.out.print("Enter the Model of the car: ");
		model = userInput.nextLine();
		System.out.print("Enter the year of the car: ");
		year = userInput.nextInt();
		ListItem li = new ListItem(make,model,year);
		lih.insertItem(li);
	}
	
	//show items
	private static void viewTheList() {
		// TODO Auto-generated method stub
		if(lih.showAllItems().isEmpty()) {
			System.out.println("It's empty!");
		}else {
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem : allItems) {
				System.out.println(singleItem.returnItemDetails());
			}
		}
	}
	
	//delete item
	private static void deleteItem() {
		String make,model;
		int year;
		System.out.print("Enter the Make of the car: ");
		make = userInput.nextLine();
		System.out.print("Enter the Model of the car: ");
		model = userInput.nextLine();
		System.out.print("Enter the year of the car: ");
		year = userInput.nextInt();
		ListItem toDelete = new ListItem(make,model,year);
		lih.deleteItem(toDelete);
	}
	
	//edit item
	private static void editItem() {
		int in = 0;
		System.out.println("How would you like to find the item?");
		System.out.println("     1.) Make");
		System.out.println("     2.) Model");
		System.out.println("     3.) Year");
		List<ListItem> foundItems = null;
		
		while(in < 1 || in > 3) { //forces the user to pick an option 
			in = userInput.nextInt();
			userInput.nextLine();
			if(in == 1) {
				System.out.print("Enter the car make: ");
				String make = userInput.nextLine();
				foundItems = lih.searchForItemByCarMake(make);
			}else if(in == 2) {
				System.out.print("Enter the car model: ");
				String model = userInput.nextLine();
				foundItems = lih.searchForItemByCarModel(model);
			}else if(in == 3) {
				System.out.print("Enter the year made: ");
				int year = userInput.nextInt();
				userInput.nextLine();
				foundItems = lih.searchForItemByYearMade(year);
			}else {
				System.out.println("Please input a valid response!");
			}
		}
		
		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (ListItem l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = userInput.nextInt();

			ListItem toEdit = lih.searchForItemById(idToEdit);
			System.out.println("Retrieved Car: | Make" + toEdit.getCarMake() + " | Model: " + toEdit.getCarModel() + " | Year: " + toEdit.getYearMade() + " |");
			System.out.println("1.) Update Make");
			System.out.println("2.) Update Model");
			System.out.println("3.) Update Year");
			in = 0;
			
			while(in < 1 || in > 3) {
				in = userInput.nextInt();
				userInput.nextLine();
				if(in  == 1) {
					System.out.print("Input a new Make: ");
					String newMake = userInput.nextLine();
					toEdit.setCarMake(newMake);
				}else if(in == 2) {
					System.out.print("Input a new Model: ");
					String newModel = userInput.nextLine();
					toEdit.setCarModel(newModel);
				}else if(in == 3) {
					System.out.print("Input a new Year: ");
					int newYear = userInput.nextInt();
					userInput.nextLine();
					toEdit.setYearMade(newYear);
				}else {
					System.out.println("Please input a valid response!");
				}
			}
			lih.updateItem(toEdit);
		}else {
			System.out.println("---- No results found");
		}
	}
}
