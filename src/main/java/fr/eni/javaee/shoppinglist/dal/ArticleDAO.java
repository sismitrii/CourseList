package fr.eni.javaee.shoppinglist.dal;

import java.util.List;

import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;

public interface ArticleDAO {
	
	public void insert(Article article, int shoppingListId) throws DALException;

	public void delete(int articleId) throws DALException;
	
	public void deleteByListId(int listId) throws DALException;

	public List<Article> getArticleByShoppingListId(int shoppingListId) throws DALException;
}
