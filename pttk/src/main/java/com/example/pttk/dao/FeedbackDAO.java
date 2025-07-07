package com.example.pttk.dao;

import java.util.List;

import com.example.pttk.model.Feedback;

public interface FeedbackDAO {
	public Feedback CreateFeedback();
	
	public void UpdateFeedback(Feedback feedback);
	
	public void DeleteFeedback(Feedback feedback);
	
	public List<Feedback> SelectAllFeedbacksByIDProduct(String id);
}
