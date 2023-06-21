package fr.eni.javaee.shoppinglist.dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.shoppinglist.DALException;
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
	public void delete(int shoppingListId) {
		// TODO Auto-generated method stub
		
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
			throw new DALException("An error happen during getAll of ShoppingList");
		}

		return shoppingLists;
	}

	@Override
	public ShoppingList getListById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
