package fr.eni.javaee.shoppinglist.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	@Override
	public void insert(Article article, int shoppingListId) throws DALException {
		String INSERT = "INSERT INTO Article (name, listId) VALUES (?,?)";
		if (article == null) {
			throw new DALException("Enable to insert null article");
		}
		
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, article.getName());
			pst.setInt(2, shoppingListId);
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			while (rs.next()) {
				article.setArticleId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			String message = String.format("An error happen during insert of Article : %s", article.getName());
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		}
	}

	@Override
	public void delete(int articleId) throws DALException {
		String DELETE = "DELETE Article WHERE articleId = ?";

		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(DELETE);
			pst.setInt(1, articleId);
			int modif = pst.executeUpdate();
			if (modif <=0) {
				System.out.println("No Article found for this Id");
			}
		} catch (SQLException e) {
			String message = String.format("An error happen during delete Article : %d", articleId);
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		}		
	}
	
	public void deleteByListId(int listId) throws DALException {
		String DELETE = "DELETE Article WHERE listId = ?";

		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(DELETE);
			pst.setInt(1, listId);
			int modif = pst.executeUpdate();
			if (modif <=0) {
				throw new DALException(String.format("No Article found for this listId : %d", listId ));
			}
		} catch (SQLException e) {
			String message = String.format("An error happen during delete of articles of List : %d", listId);
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		}		
	}
//
//	@Override
//	public void changeStatus(int articleId, boolean status) {
//		// TODO 
//		
//	}
//
//	@Override
//	public void changeAllStatus() {
//		// TODO 

	@Override
	public List<Article> getArticleByShoppingListId(int shoppingListId) throws DALException {
		List<Article> articles = new ArrayList<>();
		String SELECT_BY_LISTID = "SELECT [articleId], [name], [status] FROM Article WHERE listId = ?";
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECT_BY_LISTID, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, shoppingListId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Article article = new Article(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(String.format("An error happen during getArticleByShoppingListId of ShoppingList : %d", shoppingListId));
		}
		return articles;
	}
		
//	}
	
}
