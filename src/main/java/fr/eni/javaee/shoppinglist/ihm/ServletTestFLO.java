package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class ServletTestFLO
 */
@WebServlet("/ServletTestFLO")
public class ServletTestFLO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingListManager shoppingListManager;
	private ArticleManager articleManager;
       
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
		articleManager = new ArticleManager();
		super.init();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//int test = shoppingListManager.createShoppingList("list22", "article22");
			//shoppingListManager.deleteList(15);
//			int test = articleManager.createArticle("pate", 16);
			articleManager.createArticle("riz", 100);
//			ShoppingList test = shoppingListManager.getShoppingListById(17);
//			System.out.println(test.getName());
//			System.out.println(test.getShoppingListId());
//			for (Article a : test.getArticleList()) {
//				System.out.println(a.getName());
//			}
//			Article article = test.getArticleList().get(1);
//			articleManager.changeStatus(article.getArticleId());
			articleManager.resetShoppingListStatus(16);
			
		} catch (DALException | BusinessException e ) {
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
