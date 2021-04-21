package com.webwork.online.examination.dao;

import com.webwork.online.examination.model.User;

public interface LoginDao {

	public User login(String username, String userpwd);
}
