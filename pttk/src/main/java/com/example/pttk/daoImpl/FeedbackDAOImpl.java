package com.example.pttk.daoImpl;

import java.util.List;

import com.example.pttk.dao.FeedbackDAO;
import com.example.pttk.model.Customer;
import com.example.pttk.model.Feedback;
import com.example.pttk.model.Product;

public class FeedbackDAOImpl implements FeedbackDAO {

	public List<Feedback> ViewAllFeedbacks() {
		// TODO - implement FeedbackDAOImpl.ViewAllFeedbacks
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 */
	public List<Feedback> ViewAllFeedbacksByProduct(Product product) {
		// TODO - implement FeedbackDAOImpl.ViewAllFeedbacksByProduct
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public List<Feedback> ViewOwnFeedback(int id) {
		// TODO - implement FeedbackDAOImpl.ViewOwnFeedback
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param state
	 * @param feedback
	 */
	public void ChangeStateFeedback(String state, Feedback feedback) {
		// TODO - implement FeedbackDAOImpl.ChangeStateFeedback
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Customer GetCustomer(int ID) {
		// TODO - implement FeedbackDAOImpl.GetCustomer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public Product GetProduct(int ID) {
		// TODO - implement FeedbackDAOImpl.GetProduct
		throw new UnsupportedOperationException();
	}

	@Override
	public Feedback CreateFeedback() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Feedback> SelectAllFeedbacksByIDProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}