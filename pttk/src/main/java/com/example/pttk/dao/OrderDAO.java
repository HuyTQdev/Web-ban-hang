package com.example.pttk.dao;

import java.sql.Date;
import java.util.List;

import com.example.pttk.model.Order;

public interface OrderDAO {
	
	public Order CreateOrder();
	
	public List<Order> SelectAllOrdersByIDCustomer(String id);
	
	public void DeleteOrder();
	
	public void UpdateDateArrived(Order order, Date dateArrived);
}
