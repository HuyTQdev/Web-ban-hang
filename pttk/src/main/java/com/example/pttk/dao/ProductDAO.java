package com.example.pttk.dao;

import java.util.List;

import com.example.pttk.model.Product;

public interface ProductDAO {
	public List<Product> SelectAllProducts();
	public Product SelectProduct(int ID);
}
