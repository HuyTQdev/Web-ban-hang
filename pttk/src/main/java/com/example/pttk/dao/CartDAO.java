package com.example.pttk.dao;

import java.util.List;

import com.example.pttk.model.Cart;
import com.example.pttk.model.Customer;
import com.example.pttk.model.Product;

public interface CartDAO {
	Cart GetCart(int id);
	/**
	 * 
	 * @param product
	 */
	void CreateCart(Product product);

	/**
	 * 
	 * @param cart
	 */
	void ChangeQuantityItems(int idItem, int quantity);
	void EditCart(Cart cart);

	/**
	 * 
	 * @param cart
	 */
	void DeleteCart(Cart cart);

	List<Cart> ViewAllCarts();

	/**
	 * 
	 * @param ID
	 */
	List<Cart> ViewOwnCart(int ID);

	/**
	 * 
	 * @param product
	 * @param cart
	 * @param quantity
	 */
	void ChangeQuantity(Product product, Cart cart, int quantity);

	/**
	 * 
	 * @param product
	 */
	void AddProduct(int idCus, int idPro);

	/**
	 * 
	 * @param product
	 */
	void DeleteProduct(Product product);

	/**
	 * 
	 * @param ID
	 */
	Customer GetCustomer(int ID);

}