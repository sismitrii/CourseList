package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.shoppinglist.exception.BusinessException;
import fr.eni.javaee.shoppinglist.exception.DALException;
import fr.eni.javaee.shoppinglist.bll.ArticleManager;
import fr.eni.javaee.shoppinglist.bll.ShoppingListManager;
import fr.eni.javaee.shoppinglist.bo.Article;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class ServletKartManager
 */
@WebServlet("/ServletKartManager")
public class ServletKartManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingListManager shoppingListManager;
	private ArticleManager articleManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletKartManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		shoppingListManager = new ShoppingListManager();
		articleManager = new ArticleManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/manageKart.jsp");
		int listId = -1;
		if(request.getParameter("listId") != null && StringUtils.isNotEmpty(request.getParameter("listId"))) {
			try {
				listId = Integer.parseInt(request.getParameter("listId"));
				ShoppingList sl = shoppingListManager.getShoppingListById(listId);
				List<Article> articles = articleManager.getArticlesForShoppingList(listId);
				request.setAttribute("list", sl);
				request.setAttribute("articles", articles);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listId = -1;
		int articleId = -1;
		if(request.getParameter("listId") != null && StringUtils.isNotEmpty(request.getParameter("listId"))) {
			listId = Integer.parseInt(request.getParameter("listId"));
			if(request.getParameter("articleId") != null && StringUtils.isNotEmpty(request.getParameter("articleId"))) {
				articleId = Integer.parseInt(request.getParameter("articleId"));
				System.out.println("article concerné " +articleId);
				// toggleOne
				try {
					articleManager.toggleStatus(articleId);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			} else {
				// unCheckAll
				try {
					articleManager.resetShoppingListStatus(listId);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		doGet(request, response);
	}

}
