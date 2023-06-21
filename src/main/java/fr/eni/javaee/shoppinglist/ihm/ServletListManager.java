package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.shoppinglist.bll.ShoppingListManager;

/**
 * Servlet implementation class ServletListManager
 */
@WebServlet("/ServletListManager")
public class ServletListManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingListManager shoppingListManager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListManager() {
        super();
        
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
		shoppingListManager = new ShoppingListManager();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/manageList.jsp");
		
		if(request.getParameter("listId") != null) {
			// shoppingListManager
		}
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/manageList.jsp");
		/*
		if(request.getAttribute("id") == -1) {
			// Créer la liste
		}
		// Récupérer l'id
		// Récupérer la liste avec l'id
		if(request.getAttribute("action") != null)
			
		}
		*/
		rd.forward(request, response);
	}

}
