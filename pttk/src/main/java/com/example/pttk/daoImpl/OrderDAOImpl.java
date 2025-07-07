package com.example.pttk.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import com.example.pttk.dao.OrderDAO;
import com.example.pttk.model.Cart;
import com.example.pttk.model.Order;
import com.example.pttk.model.Payment;
import com.example.pttk.model.Shipment;

public class OrderDAOImpl implements OrderDAO{
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
    public void saveOrder(Order order) {
	 	Connection connection = getConnection();
	    PreparedStatement orderStatement = null;
	    PreparedStatement shipmentStatement = null;
	    PreparedStatement paymentStatement = null;
	    ResultSet generatedKeys = null;
    	 try {
    	        // Lưu lô hàng
    	        String shipmentQuery = "INSERT INTO shipment (address, type, fee) VALUES (?, ?, ?)";
    	        shipmentStatement = connection.prepareStatement(shipmentQuery, Statement.RETURN_GENERATED_KEYS);
    	        shipmentStatement.setInt(1, order.getShipment().getAddress().getId());
    	        shipmentStatement.setString(2, order.getShipment().getType());
    	        shipmentStatement.setDouble(3, order.getShipment().getFee());
    	        shipmentStatement.executeUpdate();

    	        // Lấy ID mới của lô hàng
    	        generatedKeys = shipmentStatement.getGeneratedKeys();
    	        if (generatedKeys.next()) {
    	            int shipmentID = generatedKeys.getInt(1);
    	            order.getShipment().setId(shipmentID);
    	        }

    	        // Lưu thanh toán
    	        String paymentQuery = "INSERT INTO payment (method, state, totalPrice, shipmentfee, productPrice) VALUES (?, ?, ?, ?, ?)";
    	        paymentStatement = connection.prepareStatement(paymentQuery, Statement.RETURN_GENERATED_KEYS);
    	        paymentStatement.setString(1, order.getPayment().getMethod());
    	        paymentStatement.setString(2, order.getPayment().getState());
    	        paymentStatement.setDouble(3, order.getPayment().getTotalPrice());
    	        paymentStatement.setDouble(4, order.getPayment().getShipmentPrice());
    	        paymentStatement.setDouble(5, order.getPayment().getProductPrice());
    	        paymentStatement.executeUpdate();

    	        // Lấy ID mới của thanh toán
    	        generatedKeys = paymentStatement.getGeneratedKeys();
    	        if (generatedKeys.next()) {
    	            int paymentID = generatedKeys.getInt(1);
    	            order.getPayment().setId(paymentID);
    	        }
    	        // Lưu đơn hàng
    	        String orderQuery = "INSERT INTO `order` (userid, cartid, payid, shipid) VALUES (?, ? , ? , ?)";
    	        orderStatement = connection.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
    	        orderStatement.setInt(1, order.getCart().getIdCus());
    	        orderStatement.setInt(2, order.getCart().getId());
    	        orderStatement.setInt(3, order.getPayment().getId());
    	        orderStatement.setInt(4, order.getShipment().getId());
    	        orderStatement.executeUpdate();

    	        // Lấy ID mới của đơn hàng
    	        generatedKeys = orderStatement.getGeneratedKeys();
    	        if (generatedKeys.next()) {
    	            int orderID = generatedKeys.getInt(1);
    	            order.setId(orderID);
    	        }

    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        // Đóng các tài nguyên
    	        try {
    	            if (generatedKeys != null) {
    	                generatedKeys.close();
    	            }
    	            if (orderStatement != null) {
    	                orderStatement.close();
    	            }
    	            if (shipmentStatement != null) {
    	                shipmentStatement.close();
    	            }
    	            if (paymentStatement != null) {
    	                paymentStatement.close();
    	            }
    	            if (connection != null) {
    	                connection.close();
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    }
	public List<Order> ViewAllOrders() {
		// TODO - implement OrderDAOImpl.ViewAllOrders
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public void EditOrder(Order order) {
		// TODO - implement OrderDAOImpl.EditOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public void DeleteOrder(Order order) {
		// TODO - implement OrderDAOImpl.DeleteOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public List<Order> ViewOwnOrder(int ID) {
		// TODO - implement OrderDAOImpl.ViewOwnOrder
		throw new UnsupportedOperationException();
	}

	public List<Payment> SelectAllPayments() {
		// TODO - implement OrderDAOImpl.SelectAllPayments
		throw new UnsupportedOperationException();
	}

	public List<Shipment> SelectAllShipment() {
		// TODO - implement OrderDAOImpl.SelectAllShipment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public void CreatOrder(Order order) {
		// TODO - implement OrderDAOImpl.CreatOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Cart GetCart(int ID) {
		// TODO - implement OrderDAOImpl.GetCart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Shipment GetShipment(int ID) {
		// TODO - implement OrderDAOImpl.GetShipment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Payment GetPayment(int ID) {
		// TODO - implement OrderDAOImpl.GetPayment
		throw new UnsupportedOperationException();
	}

	@Override
	public Order CreateOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> SelectAllOrdersByIDCustomer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateDateArrived(Order order, Date dateArrived) {
		// TODO Auto-generated method stub
		
	}

}