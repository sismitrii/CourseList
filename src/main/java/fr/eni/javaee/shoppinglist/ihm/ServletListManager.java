package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.shoppinglist.bll.ArticleManager;
import fr.eni.javaee.shoppinglist.bll.ShoppingListManager;
import fr.eni.javaee.shoppinglist.bo.Article;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

/**
 * Servlet implementation class ServletListManager
 */
@WebServlet("/ServletListManager")
public class ServletListManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingListManager shoppingListManager;
	private ArticleManager articleManager;
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
		articleManager = new ArticleManager();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/manageList.jsp");
		
		if(request.getParameter("articleId") == null) {
			ShoppingList sl = new ShoppingList(1, "maListeUne");
			
			Article a1 = new Article(1, "Beurre", false, sl);
			Article a2 = new Article(2, "Pain", false, sl);
			ArrayList<Article> articles = new ArrayList<>();
			articles.add(a1);
			articles.add(a2);
			
			request.setAttribute("list", sl);
			request.setAttribute("articles", articles);
		} else {
			if(request.getParameter("action") != null) {
				switch (request.getParameter("action")) {
				case "delete":
						if(request.getParameter("articleId") != null) {
							// articleManager.deleteArticle(Integer.parseInt(request.getParameter("articleId")));
						}
					break;
				}
			}
			// ShoppingList sl = shoppingListManager.getAllShoppingList();
		}
		
		int listId;
		if(request.getParameter("listId") != null && Integer.parseInt(request.getParameter("listId")) != -1) {
			listId = Integer.parseInt(request.getParameter("listId"));
			// request.setAttribute("list", shoppingListManager.getShoppingListById(listId));
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
		int listId;
		if(request.getParameter("listId") != null && Integer.parseInt(request.getParameter("listId")) != -1) {
			// Créer la liste
			listId = 0;
		} else {
			listId = Integer.parseInt(request.getParameter("listId"));
		}
		// ShoppingList sl = shoppingListManager.getShoppingListById(listId);
		
		// Ajouter article dans la liste existante
		
		rd.forward(request, response);
	}

}
