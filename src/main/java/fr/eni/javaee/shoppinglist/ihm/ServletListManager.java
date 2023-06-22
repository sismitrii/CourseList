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
import fr.eni.javaee.shoppinglist.exception.BusinessException;
import fr.eni.javaee.shoppinglist.exception.DALException;
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
		
		if(request.getParameter("articleId") != null && StringUtils.isNotEmpty(request.getParameter("articleId"))) {
			if(request.getParameter("action") != null && StringUtils.isNotEmpty(request.getParameter("articleId"))) {
				switch (request.getParameter("action")) {
				case "delete":
						try {
							articleManager.deleteArticle(Integer.parseInt(request.getParameter("articleId")));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DALException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
				}
			}
			// ShoppingList sl = shoppingListManager.getAllShoppingList();
		}
		
		int listId;
		if(request.getParameter("listId") != null && StringUtils.isNotEmpty(request.getParameter("listId")) && Integer.parseInt(request.getParameter("listId")) != -1) {
			listId = Integer.parseInt(request.getParameter("listId"));
			try {
				ShoppingList sl = shoppingListManager.getShoppingListById(listId);
				List<Article> articles = articleManager.getArticlesForShoppingList(sl.getShoppingListId());
				request.setAttribute("list", sl);
				request.setAttribute("articles", articles);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/manageList.jsp");
		int listId = -1;
		ShoppingList sl = null;
		List<Article> articles = new ArrayList<Article>();
		System.out.println("rename" + request.getParameter("rename"));
				
			// Je récupère l'id de la liste existante et je lui ajoute l'article
						if(request.getParameter("listId") != null && Integer.parseInt(request.getParameter("listId")) != -1) {
							if (request.getParameter("rename") != null && StringUtils.isNoneEmpty(request.getParameter("rename"))&& Integer.parseInt(request.getParameter("rename")) == 1) {
								try {
									shoppingListManager.renameShoppingList(request.getParameter("listName"),Integer.parseInt(request.getParameter("listId")));
									listId = Integer.parseInt(request.getParameter("listId"));
								} catch (NumberFormatException |BusinessException | DALException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} else {
								listId = Integer.parseInt(request.getParameter("listId"));
								try {
									articleManager.createArticle(request.getParameter("articleName"), listId);
								} catch (DALException | BusinessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						// Sinon créer la liste et récupérer son id après la création
						} else {
						
							try {
								System.out.println(request.getParameter("articleName"));
								listId = shoppingListManager.createShoppingList(request.getParameter("listName"), request.getParameter("articleName"));
							} catch (BusinessException | DALException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						// Dans tous les cas je construis les éléments nécessaires à l'affichage
						try {
							sl = shoppingListManager.getShoppingListById(listId);
							articles = articleManager.getArticlesForShoppingList(sl.getShoppingListId());
						} catch (DALException |BusinessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 

		
		
		request.setAttribute("list", sl);
		request.setAttribute("articles", articles);
		
		rd.forward(request, response);
	}

}
