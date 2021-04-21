package com.webwork.online.examination.dao;

import java.util.List;

import com.webwork.online.examination.model.Feedback;
import com.webwork.online.examination.model.User;

public interface UserDao {

	boolean saveUserDetails(User user);

	User getUserDetails(int userId);

	List<User> getAllUser(String userType);
	
	boolean saveFeedback(Feedback feedback);
	
	User getUser(String userName);
	
	boolean setUser(User user, String userPwd);
	
	boolean deleteUser(int userId);
	
	public User login(String username, String userpwd);
	
}
