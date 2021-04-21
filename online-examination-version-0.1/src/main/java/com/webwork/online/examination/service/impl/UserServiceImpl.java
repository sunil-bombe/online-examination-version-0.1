package com.webwork.online.examination.service.impl;

import java.util.List;

import com.webwork.online.examination.dao.UserDao;
import com.webwork.online.examination.dao.impl.UserDaoImpl;
import com.webwork.online.examination.exception.UserNotFoundException;
import com.webwork.online.examination.model.Feedback;
import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		if (null != userDao.getUserDetails(user.getUserId())) {
			return true;
		} else {
			return userDao.saveUserDetails(user);
		}
	}

	@Override

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		if (null != userDao.getUserDetails(userId)) {
			return userDao.getUserDetails(userId);

		} else {
			User user = new User();
			user.setUserFullName("");
			user.setUserEmail("");
			user.setUserPhone("");
			user.setUserBirthDate("");
			user.setUserCollege("");
			return user;

		}

	}

	@Override
	public List<User> getAllUser(String userType) throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> userList = userDao.getAllUser(userType);
		if (null == userList) {
			
			throw new UserNotFoundException("User not found");
		}

		return userList;
	}

	@Override
	public boolean saveFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return userDao.saveFeedback(feedback);
	}

	@Override
	public boolean newUser(User user, String userPwd) {
		// TODO Auto-generated method stub
		if(null == userDao.getUser(user.getUsername())) {
			System.out.println(user.getUsername());
			return userDao.setUser(user, userPwd);
		}else {
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}
}
