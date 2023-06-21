package fr.eni.javaee.shoppinglist.dal;

import java.util.List;

import fr.eni.javaee.shoppinglist.bo.ShoppingList;

public interface ShoppingListDAO {

	public void insert(ShoppingList shoppingList);
	
	public void delete(int shoppingListId);
	
	public List<ShoppingList> getAllShoppingList();
	
	public ShoppingList getListById(int id);

}
