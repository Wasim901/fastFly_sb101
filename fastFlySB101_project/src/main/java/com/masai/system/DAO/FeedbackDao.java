package com.masai.system.DAO;

import com.masai.system.DTO.Feedback;

public interface FeedbackDao {
	
	public void addFeedback(Feedback feedback);
	public Feedback getFeedbackById(int feedbackId);
	public void updateFeedback(Feedback feedback);
	public void deleteFeedbackById(int feedbackId);
	

}
