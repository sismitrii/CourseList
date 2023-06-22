package fr.eni.javaee.shoppinglist.bo;

public class Article {
	private int articleId;
	private String name;
	private boolean status;
	
	public Article(String name) {
		super();
		this.name = name;
		this.status = false;
	}
	
	public Article(int articleId, String name, boolean status) {
		super();
		this.articleId = articleId;
		this.name = name;
		this.status = status;
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
	
	
}
