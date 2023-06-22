package fr.eni.javaee.shoppinglist.bll;

import java.util.List;

import com.microsoft.sqlserver.jdbc.StringUtils;

import fr.eni.javaee.shoppinglist.exception.BusinessException;
import fr.eni.javaee.shoppinglist.exception.DALException;
import fr.eni.javaee.shoppinglist.bll.ArticleManager;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;
import fr.eni.javaee.shoppinglist.dal.DAOFactory;
import fr.eni.javaee.shoppinglist.dal.ShoppingListDAO;

public class ShoppingListManager {
	private ShoppingListDAO shoppingListDAO;
	private ArticleManager articleManager;

	public ShoppingListManager() {
		super();
		this.shoppingListDAO = DAOFactory.getShoppingListDAO();
		articleManager = new ArticleManager();
	}
	
	public int createShoppingList(String shoppingListName, String articleName) throws BusinessException, DALException {
		if (shoppingListName == null || StringUtils.isEmpty(shoppingListName)) {
			throw new BusinessException("Name of the shopingList to create can't be null or empty");
		}
		
		if (articleName == null || StringUtils.isEmpty(articleName)) {
			throw new BusinessException("Name of the article to add can't be null or empty");
		}
		ShoppingList shoppingListToCreate = new ShoppingList(shoppingListName);
		shoppingListDAO.insert(shoppingListToCreate);
		articleManager.createArticle(articleName, shoppingListToCreate.getShoppingListId());
		return shoppingListToCreate.getShoppingListId();
	}
	
	public List<ShoppingList> getAllShoppingList() throws DALException {
		return shoppingListDAO.getAllShoppingList();
	}
	
	public void deleteList(int listId) throws DALException {
		articleManager.deleteAllArticleForList(listId);
		shoppingListDAO.delete(listId);
		
	}
	
	public ShoppingList getShoppingListById(int shoppingListId) throws DALException, BusinessException {	
		ShoppingList shoppingList = shoppingListDAO.getShoppingListById(shoppingListId);
		if (shoppingList == null) {
			throw new BusinessException(String.format("No shopping List Found for this shoppingListId : %d", shoppingListId));
		}
		shoppingList.setArticleList(articleManager.getArticlesForShoppingList(shoppingListId));
		
		return shoppingList;
		
	}
	
	
}
