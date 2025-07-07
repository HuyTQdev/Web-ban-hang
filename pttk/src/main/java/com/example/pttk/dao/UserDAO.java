package com.example.pttk.dao;

import java.util.List;

import com.example.pttk.model.Address;
import com.example.pttk.model.User;

public interface UserDAO {

	public List<Address> GetAllAddress(int id);
	public int login (String username, String password);
	public Address GetAddress(int id);
	public User SelectUser (int id);
	List<User> SelectAllUsers();

	/**
	 * 
	 * @param user
	 */
	void AddUser(User user);

	/**
	 * 
	 * @param user
	 */
	void EditUser(User user);

	/**
	 * 
	 * @param user
	 */
	void DeleteUser(User user);

	/**
	 * 
	 * @param ID
	 * @return 
	 */

}