package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.shoppinglist.bo.ShoppingList;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Homepage")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/home.jsp");
		
		ArrayList<ShoppingList> lists = new ArrayList<>();
		
		ShoppingList sl;
		sl = new ShoppingList(1, "List 1");
		lists.add(sl);
		sl = new ShoppingList(2, "List 2");
		lists.add(sl);
		sl = new ShoppingList(3, "List 3");
		lists.add(sl);
		sl = new ShoppingList(4, "List 4");
		lists.add(sl);
		
		request.setAttribute("lists", lists);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
