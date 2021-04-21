package com.webwork.online.examination.service;

import com.webwork.online.examination.model.User;

public interface LoginService {

	User userLogin(String username, String userpwd);

}
