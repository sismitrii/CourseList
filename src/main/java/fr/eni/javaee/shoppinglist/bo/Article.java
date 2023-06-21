package fr.eni.javaee.shoppinglist.bo;

public class Article {
	private int articleId;
	private String name;
	private boolean status;
	private ShoppingList shoppingList;
	
	public Article(String name) {
		super();
		this.name = name;
		this.status = false;
	}
	
	public Article(String name, ShoppingList shoppingList) {
		super();
		this.name = name;
		this.status = false;
		this.shoppingList = shoppingList;
	}
	
	public Article(int articleId, String name, boolean status, ShoppingList shoppingList) {
		super();
		this.articleId = articleId;
		this.name = name;
		this.status = status;
		this.shoppingList = shoppingList;
	}
	
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ShoppingList getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}
	
	
}
