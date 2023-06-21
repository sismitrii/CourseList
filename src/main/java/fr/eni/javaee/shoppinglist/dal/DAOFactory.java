package fr.eni.javaee.shoppinglist.dal;

public abstract class DAOFactory {
	
	public static ShoppingListDAO getShoppingListDAO() {
		return new ShoppingListDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
}
