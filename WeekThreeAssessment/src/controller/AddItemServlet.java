package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddItemServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		Integer year = Integer.parseInt(request.getParameter("year"));
		
		System.out.println("Adding car with attributes: |" + make + " | " + model + " | " + year + "|");
		
		ListItemHelper dao = new ListItemHelper();
		ListItem li = new ListItem(make,model,year);
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/startpage.jsp").forward(request, response);
	}

}
