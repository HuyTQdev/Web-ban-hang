package com.example.pttk.daoImpl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.pttk.dao.ProductDAO;
import com.example.pttk.model.Category;
import com.example.pttk.model.Product;

public class ProductDAOImpl implements ProductDAO {
	private static final String SELECT_ALL_PRODUCTS = 
			"SELECT * FROM pttk.product inner join "
			+ "pttk.category on pttk.product.categoryid = "
			+ "pttk.category.categoryid";
	private static final String SELECT_PRODUCT_BY_ID = 
			"SELECT * FROM pttk.product inner join "
			+ "pttk.category on pttk.product.categoryid = "
			+ "pttk.category.categoryid where pttk.product.productid = ?";
	
	
	private String url = "jdbc:mysql://localhost:3306/pttk";
	private String User = "root";
	private String pass = "";
    
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

	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Product> SelectAllProducts() {
	    List<Product> products = new ArrayList<>();
	    try (Connection connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
	        
	        ResultSet resultSet = ps.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("productid");
	            int cid = resultSet.getInt("categoryid");
	            String cname = resultSet.getString("cName");
	            Category c = new Category(cid, cname);
	            String pname = resultSet.getString("pName");
	            String des = resultSet.getString("decription");
	            double price = resultSet.getDouble("price");
	            String pImage = resultSet.getString("imagepath");
	            
	            Date publicationDate = resultSet.getDate("publicationDate");
	            String authorname = resultSet.getString("authorname");
	            String brand = resultSet.getString("brand");
	            String batteryCapacity = resultSet.getString("batteryCapicity");
	            String screenSize = resultSet.getString("screenSize");
	            String cameraResolution = resultSet.getString("cameraResolutin");
	            String material = resultSet.getString("material");
	            String color = resultSet.getString("color");
	            String size = resultSet.getString("size");
	            
	            products.add(new Product(id, pname, price, des, pImage, c, publicationDate, authorname, brand, batteryCapacity, screenSize, cameraResolution, material, color, size));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
	}

	@Override
	public Product SelectProduct(int ID) {
	    try {
	        Connection connection = getConnection();
	        PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
	        ps.setInt(1, ID);
	        ResultSet resultSet = ps.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("productid");
	            int cid = resultSet.getInt("categoryid");
	            String cname = resultSet.getString("cName");
	            Category c = new Category(cid, cname);
	            String pname = resultSet.getString("pName");
	            String des = resultSet.getString("decription");
	            double price = resultSet.getDouble("price");
	            String pImage = resultSet.getString("imagepath");
	            
	            Date publicationDate = resultSet.getDate("publicationDate");
	            String authorname = resultSet.getString("authorname");
	            String brand = resultSet.getString("brand");
	            String batteryCapacity = resultSet.getString("batteryCapicity");
	            String screenSize = resultSet.getString("screenSize");
	            String cameraResolution = resultSet.getString("cameraResolutin");
	            String material = resultSet.getString("material");
	            String color = resultSet.getString("color");
	            String size = resultSet.getString("size");
	            
	            return new Product(id, pname, price, des, pImage, c, publicationDate, authorname, brand, batteryCapacity, screenSize, cameraResolution, material, color, size);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	

}