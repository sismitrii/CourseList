package fr.eni.javaee.shoppinglist.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.shoppinglist.DALException;
import fr.eni.javaee.shoppinglist.bo.Article;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	@Override
	public void insert(Article article) throws DALException {
		String INSERT = "INSERT INTO Article (name, listId) VALUES (?,?)";
		if (article == null) {
			throw new DALException("Enable to insert null article");
		}
		
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, article.getName());
			pst.setInt(2, article.getShoppingList().getShoppingListId());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			while (rs.next()) {
				article.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			String message = String.format("An error happen during insert of Article : %s", article.getName());
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		}
	}

//	@Override
//	public void delete(int articleId) {
//		// TODO 
//		
//	}
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
