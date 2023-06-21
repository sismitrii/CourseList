package fr.eni.javaee.shoppinglist.dal;

import fr.eni.javaee.shoppinglist.DALException;

public interface ArticleDAO {
	
	public void insert(Article article) throws DALException;
}
