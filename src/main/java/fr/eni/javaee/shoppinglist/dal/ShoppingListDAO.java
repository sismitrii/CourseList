package fr.eni.javaee.shoppinglist.dal;

import java.util.List;

import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

public interface ShoppingListDAO {

	public void insert(ShoppingList shoppingList) throws DALException;
	
	public void delete(int shoppingListId) throws DALException;
	
	public List<ShoppingList> getAllShoppingList() throws DALException;
	
	public ShoppingList getListById(int id);

}
