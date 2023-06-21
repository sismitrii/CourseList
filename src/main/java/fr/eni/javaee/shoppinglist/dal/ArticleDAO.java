package fr.eni.javaee.shoppinglist.dal;

import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;

public interface ArticleDAO {
	
	public void insert(Article article) throws DALException;

	public void delete(int articleId) throws DALException;
	
	public void deleteByListId(int listId) throws DALException;
}
