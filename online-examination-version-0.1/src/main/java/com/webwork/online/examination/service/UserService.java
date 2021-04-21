package com.webwork.online.examination.service;

import java.util.List;

import com.webwork.online.examination.exception.UserNotFoundException;
import com.webwork.online.examination.model.Feedback;
import com.webwork.online.examination.model.User;

public interface UserService {

	boolean saveUser(User user);

	User getUser(int userId);

	List<User> getAllUser(String userType) throws UserNotFoundException;

	boolean saveFeedback(Feedback feedback);
	
	boolean newUser(User user, String userPwd);
	
	boolean deleteUser(int userId);

}
