import java.util.List;

import controller.DealershipHelper;
import model.Dealership;

/**
 * Kenneth Gisler - kgisler@dmacc.edu
 * CIS171 22149
 * Oct 6, 2022
 */
public class DealershipTester {

	public static void main(String[] args) {
		Dealership test = new Dealership("test","123fakeSt.");
		Dealership test2 = new Dealership("Honda","2nd St WDM");
		
		DealershipHelper dsh = new DealershipHelper();
		dsh.insertDealership(test);
		dsh.insertDealership(test2);
		
		List<Dealership> allDealerships = dsh.showAllDealerships(); 
		for(Dealership a: allDealerships) {
			System.out.println(a.toString());
		}
	}

}
