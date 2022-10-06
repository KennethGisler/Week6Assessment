package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListItem;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper dao = new ListDetailsHelper();
		String act = request.getParameter("doThisToList");
		String path =  "/viewAllListsServlet";
		
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = dao.searchForListDetailsById(tempId);
				dao.deleteList(listToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		}else if(act.equals("edit")){
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = dao.searchForListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				
				request.setAttribute("month",listToEdit.getDateAdded().getMonthValue());
				request.setAttribute("day",listToEdit.getDateAdded().getDayOfMonth());
				request.setAttribute("year",listToEdit.getDateAdded().getYear());
				
				ListItemHelper daoForItems = new ListItemHelper();
				
				
				if(daoForItems.showAllItems().isEmpty()) {
					request.setAttribute("allItems", "");
				}else {
					request.setAttribute("allItems", daoForItems.showAllItems());
				}
				path = "/edit-list.jsp";
				
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		}else if(act.equals("add")) {
			path = "/addItemsForListServelet";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
