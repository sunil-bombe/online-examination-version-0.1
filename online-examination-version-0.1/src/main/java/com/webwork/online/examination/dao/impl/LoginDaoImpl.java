package com.webwork.online.examination.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.webwork.online.examination.connection.ConnectionManager;
import com.webwork.online.examination.dao.LoginDao;
import com.webwork.online.examination.model.User;

public class LoginDaoImpl implements LoginDao {

	public User login(String username, String userpwd) {

		User user = null;
		try {
			String sql = "SELECT * FROM user WHERE userName=? AND userPwd=?";
			PreparedStatement preparedstatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, userpwd);
			ResultSet rs = preparedstatement.executeQuery();
			if (rs.next()) {
				user = new User();
				System.out.println("Loged In" + username + userpwd);
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("userName"));
				user.setUserType((String) rs.getObject("userType"));
				user.setUserPhone(rs.getNString("userPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

}
