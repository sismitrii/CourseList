package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.shoppinglist.BusinessException;
import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bll.ShoppingListManager;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

/**
 * Servlet implementation class ServletTestFLO
 */
@WebServlet("/ServletTestFLO")
public class ServletTestFLO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingListManager shoppingListManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestFLO() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		shoppingListManager = new ShoppingListManager();
		super.init();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ShoppingList> test =  shoppingListManager.getAllShoppingList();
			for (ShoppingList s : test) {
				System.out.println(s.getName());
			}
			
		} catch (DALException e ) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
