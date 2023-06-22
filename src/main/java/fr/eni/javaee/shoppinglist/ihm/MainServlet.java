package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import fr.eni.javaee.shoppinglist.exception.DALException;
import fr.eni.javaee.shoppinglist.bll.ShoppingListManager;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Homepage")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingListManager shoppingListManager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		super.init();
		shoppingListManager = new ShoppingListManager();
	}

	private List<ShoppingList> getLists() {
		List<ShoppingList> lists = new ArrayList<>();
		
		try {
			lists = shoppingListManager.getAllShoppingList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/home.jsp");
		
		List<ShoppingList> lists = this.getLists();	
		request.setAttribute("lists", lists);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/home.jsp");
		
		int listId;
		if(request.getParameter("listId") != null && StringUtils.isNotEmpty(request.getParameter("listId"))) {
			listId = Integer.parseInt((String)request.getParameter("listId"));
			try {
				shoppingListManager.deleteList(listId);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<ShoppingList> lists = this.getLists();	
		request.setAttribute("lists", lists);
		
		rd.forward(request, response);
	}

}
