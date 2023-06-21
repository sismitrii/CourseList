package fr.eni.javaee.shoppinglist.bll;

import java.util.List;

import com.microsoft.sqlserver.jdbc.StringUtils;

import fr.eni.javaee.shoppinglist.BusinessException;
import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;
import fr.eni.javaee.shoppinglist.dal.ArticleDAO;
import fr.eni.javaee.shoppinglist.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	public int createArticle(String articleName, int shoppingListId) throws DALException, BusinessException {
		if (articleName == null || StringUtils.isEmpty(articleName)) {
			throw new BusinessException("Name of the article to add can't be null or empty");
		}
		
		Article articleToInsert = new Article(articleName);
		articleDAO.insert(articleToInsert, shoppingListId);
		return articleToInsert.getArticleId();
	}
		
	
	public void deleteArticle(int articleId) throws DALException {
		
		articleDAO.delete(articleId);
	}
	
	public void deleteAllArticleForList(int listId) throws DALException {
		articleDAO.deleteByListId(listId);
	}
	
	public List<Article> getArticlesForShoppingList(int shoppingListId) throws DALException{
		return articleDAO.getArticleByShoppingListId(shoppingListId);
	}
	

}