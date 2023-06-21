package fr.eni.javaee.shoppinglist.bo;

import java.util.List;

public class ShoppingList {
	private int shoppingListId;
	private String name;
	private List<Article> articleList;
	
	public ShoppingList(String name) {
		super();
		this.name = name;
	}
	
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

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	
	
	
}
