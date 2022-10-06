import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.DealershipHelper;
import controller.ListDetailsHelper;
import controller.ListItemHelper;
import model.Dealership;
import model.ListDetails;
import model.ListItem;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 6, 2022
 */
public class ListDetailsTester {
	
	public static void main(String[] args) {
		Dealership test = new Dealership("test","123Fake st xyz");
		Dealership test2 = new Dealership("Tesla", "real st xyz");
		
		ListItem one = new ListItem("Tesla","Y",2020);
		ListItem two = new ListItem("Tesla","S",2017);
		ListItemHelper lih = new ListItemHelper();
		lih.insertItem(one);
		lih.insertItem(two);
		
		List<ListItem> aList = new ArrayList<ListItem>();
		aList.add(one);
		aList.add(two);
		
		ListDetails tester = new ListDetails("Tester List", LocalDate.now(), test);
		tester.setItemList(aList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ldh.insertNewListDetails(tester);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a:allLists) {
			System.out.println(a.toString());
		}

	}

}
