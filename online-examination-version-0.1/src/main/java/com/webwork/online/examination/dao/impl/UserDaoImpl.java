package com.webwork.online.examination.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webwork.online.examination.connection.ConnectionManager;
import com.webwork.online.examination.dao.UserDao;
import com.webwork.online.examination.model.Feedback;
import com.webwork.online.examination.model.User;

public class UserDaoImpl implements UserDao {
	
	

	public boolean saveUserDetails(User user) {
		String userfullname = user.getUserFullName();
		String email = user.getUserEmail();
		String phone = user.getUserPhone();
		String dob = user.getUserBirthDate();
		String college = user.getUserCollege();
		int userId = user.getUserId();

		try {

			Statement smt = ConnectionManager.getConnection().createStatement();
			System.out.println(userfullname);
			String sql = "INSERT INTO userdetails (fullname, email, phone, dateOfBirth, college, userId) VALUES ('"
					+ userfullname + "','" + email + "','" + phone + "','" + dob + "','" + college + "'," + userId
					+ ")";
			if (smt.executeUpdate(sql) == 1) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public User getUserDetails(int userId) {

		String sql = "SELECT * FROM userdetails WHERE userId=?";
		try {
			PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = (ResultSet) ps.executeQuery();
			if (rs.next()) {
				User  user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserFullName(rs.getString("fullname"));
				user.setUserEmail(rs.getString("email"));
				user.setUserPhone(rs.getString("phone"));
				user.setUserBirthDate(rs.getString("dateOfBirth"));
				user.setUserCollege(rs.getString("college"));
				return user;

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<User> getAllUser(String userType) {
		// TODO Auto-generated method stub

		List<User> userList = new ArrayList<>();

		String sql = "SELECT * FROM user WHERE userType='" + userType + "'";

		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("userName"));
				user.setUserStatus(rs.getString("userStatus"));
				user.setUserType((String) rs.getObject("userType"));
				userList.add(user);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public boolean saveFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO userfeedback (userName, userEmail, userPhone, userComment, userRemark, userId) VALUES ('"+ feedback.getUserName() +"','"+ feedback.getUserEmail() +"','"+ feedback.getUserPhone() +"','"+ feedback.getUserComment() +"','"+ feedback.getUserRemark() +"',"+ feedback.getUserId() +")";
		
		try {
			Statement stmt  = ConnectionManager.getConnection().createStatement();
			if(stmt.executeUpdate(sql)==1) {
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "SELECT * FROM user WHERE userName='" + userName + "'";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			if(rs.next()) {
				user.setUsername(rs.getString("userName"));
				user.setUserStatus(rs.getString("userStatus"));
				user.setUserType((String)rs.getObject("usertype"));
				return user;
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public boolean setUser(User user,String userPwd) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO user (userName, userPwd, userStatus) VALUES ('"+ user.getUsername() +"','"+ userPwd +"','"+ user.getUserStatus() +"')";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			if(stmt.executeUpdate(sql)==1){
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		
		String sql ="DELETE FROM user WHERE userId="+ userId;
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			if(stmt.executeUpdate(sql)==1) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public User login(String username, String userpwd) {

		User user = null;
		try {
			String sql = "SELECT * FROM user WHERE userName=? AND userPwd=?";
			PreparedStatement preparedstatement = ConnectionManager.getConnection().prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, userpwd);
			ResultSet rs = (ResultSet) preparedstatement.executeQuery();
			if (rs.next()) {
				System.out.println("Loged In" + username + userpwd);
				 user = this.getUserDetails(rs.getInt("userId"));
				 if(null!=user) {
					 user.setUserType((String) rs.getObject("userType"));
					 user.setUserStatus(rs.getString("userStatus"));
					 user.setUserEmail(rs.getString("userName"));
				 }else {
					 user = new User();
					 user.setUserId(rs.getInt("userId"));
					 user.setUserType((String) rs.getObject("userType"));
					 user.setUserStatus(rs.getString("userStatus"));
					 user.setUserEmail(rs.getString("userName"));		 
				 }
				 
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
	

}
