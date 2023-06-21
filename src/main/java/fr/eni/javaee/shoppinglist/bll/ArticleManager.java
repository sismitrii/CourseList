package fr.eni.javaee.shoppinglist.bll;

import com.microsoft.sqlserver.jdbc.StringUtils;

import fr.eni.javaee.shoppinglist.BusinessException;
import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;
import fr.eni.javaee.shoppinglist.dal.ArticleDAO;
import fr.eni.javaee.shoppinglist.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager(ArticleDAO articleDAO) {
		super();
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	public void createArticle(String articleName, ShoppingList shoppingList) throws DALException, BusinessException {
		if (articleName == null || StringUtils.isEmpty(articleName)) {
			throw new BusinessException("Name of the article to add can't be null or empty");
		}
		
		if (shoppingList == null) {
			throw new BusinessException("ShoppingList not null is mandatory to add an article");
		}
		
		Article articleToInsert = new Article(articleName, shoppingList);
		articleDAO.insert(articleToInsert);
	}
}
