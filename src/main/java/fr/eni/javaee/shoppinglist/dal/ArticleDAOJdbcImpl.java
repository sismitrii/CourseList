package fr.eni.javaee.shoppinglist.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;

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
			String message = String.format("An error happen during delete Article : %s", articleId);
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
				throw new DALException(String.format("No Article found for this listId : %s", listId ));
			}
		} catch (SQLException e) {
			String message = String.format("An error happen during delete of articles of List : %s", listId);
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
		
//	}
	
}
