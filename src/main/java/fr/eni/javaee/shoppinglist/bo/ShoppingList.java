package fr.eni.javaee.shoppinglist.bo;

public class ShoppingList {
	private int shoppingListId;
	private String name;
	
	
	public ShoppingList(int shoppingListId, String name) {
		super();
		this.shoppingListId = shoppingListId;
		this.name = name;
	}
	
	public int getShoppingListId() {
		return shoppingListId;
	}
	public void setShoppingListId(int shoppingListId) {
		this.shoppingListId = shoppingListId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
