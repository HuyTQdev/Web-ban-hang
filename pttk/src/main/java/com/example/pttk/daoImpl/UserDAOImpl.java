package com.example.pttk.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.pttk.dao.UserDAO;
import com.example.pttk.model.Address;
import com.example.pttk.model.Cart;
import com.example.pttk.model.Category;
import com.example.pttk.model.FullName;
import com.example.pttk.model.Person;
import com.example.pttk.model.Product;
import com.example.pttk.model.User;
import com.fasterxml.jackson.core.sym.Name;

public class UserDAOImpl implements UserDAO {

	private String url = "jdbc:mysql://localhost:3306/pttk";
	private String User = "root";
	private String pass = "";
    
	private static final String SELECT_OWN_CART = 
			"SELECT * FROM pttk.product inner join "
			+ "pttk.category on pttk.product.categoryid = "
			+ "pttk.category.categoryid";
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
	private static final String SELECT_LOGIN = "SELECT * FROM pttk.account WHERE username = ? AND password = ?";
	@Override
	public int login (String username, String password) {
		try (Connection connection = getConnection()){
			PreparedStatement ps  = connection.prepareStatement(SELECT_LOGIN);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				int id = result.getInt("id");
				return id;
			}
			connection.close();
			ps.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	private static final String SELECT_USER = "SELECT * \r\n"
			+ "FROM pttk.user \r\n"
			+ "inner join pttk.account on pttk.user.acc = pttk.account.id \r\n"
			+ "inner join pttk.person on pttk.user.person = pttk.person.id \r\n"
			+ "inner join pttk.fullname on pttk.person.fullnameid = pttk.fullname.id \r\n"
			+ "where pttk.user.id = ?";
	@Override
	public User SelectUser(int ID) {
		try (Connection connection = getConnection()){
			PreparedStatement ps  = connection.prepareStatement(SELECT_USER);
			ps.setInt(1, ID);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				ID = result.getInt("user.id");
				FullName fullName = new FullName(result.getString("firstname"), result.getString("midname"), result.getString("lastname"));
				Person person = new Person(result.getInt("person.id"), fullName, GetAddress(result.getInt("addressid")), 
						result.getDate("dob"), result.getInt("sex") == 1, "0");
				return new User(ID, null, person);
			}
			connection.close();
			ps.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static final String GET_ADDRESS = "SELECT * \r\n"
			+ "FROM pttk.address \r\n"
			+ "where pttk.address.id = ?"; 
	@Override
	public Address GetAddress(int id)
	{
		try (Connection connection = getConnection()){
			PreparedStatement ps  = connection.prepareStatement(GET_ADDRESS);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next()) {
				int aid = result.getInt("id");
				String road = result.getString("road");
				String town = result.getString("town");
				String district = result.getString("district");
				String city = result.getString("city");
				return new Address(aid, road, town, district, city);
			}
			connection.close();
			ps.close();
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static final String GET_ALL_ADDRESS = "SELECT * \r\n"
			+ "FROM pttk.addressperson\r\n"
			+ "inner join pttk.person on pttk.addressperson.idperson = pttk.person.id\r\n"
			+ "inner join pttk.address on pttk.addressperson.idaddress = pttk.address.id\r\n"
			+ "where pttk.person.id = ?;"; 
	@Override
	public List<Address> GetAllAddress(int id)
	{
		try (Connection connection = getConnection()){
			PreparedStatement ps  = connection.prepareStatement(GET_ALL_ADDRESS);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			List<Address> addresses = new ArrayList<>();
			while(result.next()) {
				int aid = result.getInt("address.id");
				String road = result.getString("road");
				String town = result.getString("town");
				String district = result.getString("district");
				String city = result.getString("city");
				addresses.add(new Address(aid, road, town, district, city));
			}
			connection.close();
			ps.close();
			result.close();
			return addresses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * public List<Cart> GetOwnCart() { List<Cart> carts = new ArrayList<>(); try
	 * (Connection connection = getConnection(); PreparedStatement ps =
	 * connection.prepareStatement(SELECT_OWN_CART);) {
	 * 
	 * ResultSet resultSet = ps.executeQuery(); while (resultSet.next()) { int id =
	 * resultSet.getInt("productid"); int cid = resultSet.getInt("categoryid");
	 * String cname = resultSet.getString("cName"); Category c = new Category(cid,
	 * cname); String pname = resultSet.getString("pName"); String des =
	 * resultSet.getString("decription"); double price =
	 * resultSet.getDouble("price"); String pImage =
	 * resultSet.getString("imagepath");
	 * 
	 * Date publicationDate = resultSet.getDate("publicationDate"); String
	 * authorname = resultSet.getString("authorname"); String brand =
	 * resultSet.getString("brand"); String batteryCapacity =
	 * resultSet.getString("batteryCapicity"); String screenSize =
	 * resultSet.getString("screenSize"); String cameraResolution =
	 * resultSet.getString("cameraResolutin"); String material =
	 * resultSet.getString("material"); String color = resultSet.getString("color");
	 * String size = resultSet.getString("size");
	 * 
	 * products.add(new Product(id, pname, price, des, pImage, c, publicationDate,
	 * authorname, brand, batteryCapacity, screenSize, cameraResolution, material,
	 * color, size)); } } catch (SQLException e) { e.printStackTrace(); } return
	 * products; }
	 */
	
	public List<User> SelectAllUsers() {
		// TODO - implement UserDAOImpl.SelectAllUsers
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public void AddUser(User user) {
		// TODO - implement UserDAOImpl.AddUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public void EditUser(User user) {
		// TODO - implement UserDAOImpl.EditUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public void DeleteUser(User user) {
		// TODO - implement UserDAOImpl.DeleteUser
		throw new UnsupportedOperationException();
	}


}