package com.webwork.online.examination.service.impl;

import com.webwork.online.examination.dao.UserDao;
import com.webwork.online.examination.dao.impl.UserDaoImpl;
import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.LoginService;


public class LoginServiceImpl implements LoginService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User userLogin(String username, String userpwd) {
		return userDao.login(username, userpwd);
	}
	


}
