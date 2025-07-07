package com.example.pttk.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.example.pttk.dao.CartDAO;
import com.example.pttk.model.Cart;
import com.example.pttk.model.Customer;
import com.example.pttk.model.Item;
import com.example.pttk.model.Product;

public class CartDAOImpl implements CartDAO {

	private String url = "jdbc:mysql://localhost:3306/pttk";
	private String User = "root";
	private String pass = "";
    
	ProductDAOImpl pDAO = new ProductDAOImpl();
	private static final String SELECT_CART = "SELECT * FROM pttk.cart \r\n"
			+ "INNER JOIN pttk.item ON pttk.cart.id = pttk.item.cartid \r\n"
			+ "WHERE pttk.cart.id = ?";
	private static final String CREATE_CART = "INSERT INTO `pttk`.`cart` (`UserID`) VALUES (?);";
	private static final String ADD_TO_CART = "INSERT INTO `pttk`.`item` (`ProductID`, `Quantity`, `CartID`) VALUES (?, 1, ?);";
	private static final String CHANGE_QUANTITY = "UPDATE pttk.item\r\n"
											+ "SET quantity = ?\r\n"
											+ "WHERE id = ?;";
	private static final String DELETE_ITEM = "DELETE FROM pttk.item\r\n"
											+ "WHERE id = ?;";
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, User, pass);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}


	@Override
	public Cart GetCart(int idCus) {
		try (Connection connection = getConnection()){
			PreparedStatement ps  = connection.prepareStatement(SELECT_CART);
			ps.setInt(1, idCus);
			ResultSet result = ps.executeQuery();
			if(!result.next())
			{
				ps  = connection.prepareStatement(CREATE_CART);
				ps.setInt(1, idCus);
				System.out.println(idCus);
				ps.execute();
			}

			ps  = connection.prepareStatement(SELECT_CART);
			ps.setInt(1, idCus);
			result = ps.executeQuery();
			List<Item> items = new ArrayList<>();
			int id = -1;
			while(result.next()) 
			{
				id = result.getInt("cart.id");
				int itemid = result.getInt("item.id");
				int proid = result.getInt("productid");
				Product product = pDAO.SelectProduct(proid);
				int quantity = result.getInt("quantity");
				items.add(new Item(itemid, quantity, product));
			}
			connection.close();
			ps.close();
			result.close();
			return new Cart(id, idCus, items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void AddProduct(int id, int idPro) {
		try (Connection connection = getConnection()){
			PreparedStatement ps  = connection.prepareStatement(ADD_TO_CART);
			int idCart = GetCart(id).getId();
			ps.setInt(2, idCart);
			ps.setInt(1, idPro);
			System.out.println(idCart);
			System.out.println(idPro);
			ps.execute();
			connection.close();
			ps.close();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	@Override
	public void ChangeQuantityItems(int idItem, int quantity) {
		try (Connection connection = getConnection()){
			PreparedStatement ps;
			if(quantity == 0)
			{
				ps = connection.prepareStatement(DELETE_ITEM);
				ps.setInt(1, idItem);
			}
			else {
				ps  = connection.prepareStatement(CHANGE_QUANTITY);
				ps.setInt(1, quantity);
				ps.setInt(2, idItem);
			}
			ps.execute();
			connection.close();
			ps.close();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 
	 * @param product
	 */
	public void CreateCart(Product product) {
		// TODO - implement CartDAOImpl.CreateCart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cart
	 */
	public void EditCart(Cart cart) {
		// TODO - implement CartDAOImpl.EditCart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cart
	 */
	public void DeleteCart(Cart cart) {
		// TODO - implement CartDAOImpl.DeleteCart
		throw new UnsupportedOperationException();
	}

	public List<Cart> ViewAllCarts() {
		// TODO - implement CartDAOImpl.ViewAllCarts
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public List<Cart> ViewOwnCart(int ID) {
		// TODO - implement CartDAOImpl.ViewOwnCart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 * @param cart
	 * @param quantity
	 */
	public void ChangeQuantity(Product product, Cart cart, int quantity) {
		// TODO - implement CartDAOImpl.ChangeQuantity
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 */
	
	/**
	 * 
	 * @param product
	 */
	public void DeleteProduct(Product product) {
		// TODO - implement CartDAOImpl.DeleteProduct
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Customer GetCustomer(int ID) {
		// TODO - implement CartDAOImpl.GetCustomer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public List<Product> GetProducts(int ID) {
		// TODO - implement CartDAOImpl.GetProducts
		throw new UnsupportedOperationException();
	}

}