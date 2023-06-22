package fr.eni.javaee.shoppinglist.dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.shoppinglist.exception.DALException;
import fr.eni.javaee.shoppinglist.bo.ShoppingList;

public class ShoppingListDAOJdbcImpl implements ShoppingListDAO {

	@Override
	public void insert(ShoppingList shoppingList) throws DALException {
		String INSERT = "INSERT INTO List (name) VALUES (?)";
		
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, shoppingList.getName());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			
			while(rs.next()) {
				shoppingList.setShoppingListId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			String message = String.format("An error happen during insert of ShoppingList : %s", shoppingList.getName());
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		}
		
	}

	@Override
	public void delete(int shoppingListId) throws DALException {
		String DELETE = "DELETE List WHERE listId = ?";

		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(DELETE);
			pst.setInt(1, shoppingListId);
			int modif = pst.executeUpdate();
			if (modif <=0) {
				throw new DALException(String.format("No List found for this listId : %d", shoppingListId ));
			}
		} catch (SQLException e) {
			String message = String.format("An error happen during delete of articles of List : %d", shoppingListId);
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		}
			
	}

	@Override
	public List<ShoppingList> getAllShoppingList() throws DALException {
		String GETALL = "SELECT [listId],[name] FROM List";
		List<ShoppingList> shoppingLists = new ArrayList<>();
		try( Connection cnx = ConnectionProvider.getConnection()) {
			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery(GETALL);
			while(rs.next()) {
				ShoppingList shoppingList = new ShoppingList(rs.getInt(1), rs.getString(2));
				shoppingLists.add(shoppingList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("An error happen during getAllShoppingList");
		}

		return shoppingLists;
	}

	@Override
	public ShoppingList getShoppingListById(int shoppingListId) throws DALException {
		String SELECT_BY_LISTID = "SELECT [listId],[name] FROM List WHERE listId = ?";
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(SELECT_BY_LISTID, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, shoppingListId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				return new ShoppingList(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(String.format("An error happen during getShoppingListById for shoppingList : %d", shoppingListId));
		}

		return null;
	}

	@Override
	public void rename(String shoppingListName, int shoppingListId) throws DALException {
		String UPDATE = "UPDATE List SET [name] = (?)  WHERE [listId] = ? ;";

		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pst = cnx.prepareStatement(UPDATE);
			pst.setString(1, shoppingListName);
			pst.setInt(2, shoppingListId);
			int modif = pst.executeUpdate();
			if (modif <=0) {
				throw new DALException(String.format("No List found for this listId : %d", shoppingListId ));
			}
		} catch (SQLException e) {
			String message = String.format("An error happen during update name of List : %d", shoppingListId);
			e.printStackTrace();
			System.err.println(message);
			throw new DALException(message);
		} 
	}
	
}
