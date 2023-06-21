package fr.eni.javaee.shoppinglist.bll;

import com.microsoft.sqlserver.jdbc.StringUtils;

import fr.eni.javaee.shoppinglist.BusinessException;
import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;
import fr.eni.javaee.shoppinglist.dal.DAOFactory;
import fr.eni.javaee.shoppinglist.dal.ShoppingListDAO;

public class ShoppingListManager {
	private ShoppingListDAO shoppingListDAO;
	private ArticleManager articleManager;

	public ShoppingListManager(ShoppingListDAO shoppingListDAO) {
		super();
		this.shoppingListDAO = DAOFactory.getShoppingListDAO();
	}
	
	public void createShoppingList(String shoppingListName, String articleName) throws BusinessException, DALException {
		if (shoppingListName == null || StringUtils.isEmpty(shoppingListName)) {
			throw new BusinessException("Name of the shopingList to create can't be null or empty");
		}
		
		if (articleName == null || StringUtils.isEmpty(articleName)) {
			throw new BusinessException("Name of the article to add can't be null or empty");
		}
		ShoppingList shoppingListToCreate = new ShoppingList(shoppingListName);
		shoppingListDAO.insert(shoppingListToCreate);
		articleManager.createArticle(articleName, shoppingListToCreate);
	}
	
	
}
