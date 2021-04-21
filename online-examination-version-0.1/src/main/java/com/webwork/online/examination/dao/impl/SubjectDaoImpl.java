package com.webwork.online.examination.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webwork.online.examination.connection.ConnectionManager;
import com.webwork.online.examination.dao.SubjectDao;
import com.webwork.online.examination.model.Subject;

public class SubjectDaoImpl implements SubjectDao {

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		List<Subject> subjectList = new ArrayList<>();

		String sql = "SELECT * FROM subject";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubject(rs.getString("subject"));
				subject.setExamTime(rs.getInt("examTime"));
				subject.setSubjectStatus((String) rs.getObject("subjectStatus"));
				subjectList.add(subject);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subjectList;
	}

	@Override
	public boolean setSubject(Subject subject) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO subject (subject, examTime) VALUES ('" + subject.getSubject() + "',"
				+ subject.getExamTime() + ")";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			if (stmt.executeUpdate(sql) == 1) {
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
	public Subject getSubject(String subject) {
		// TODO Auto-generated method stub
		Subject sub = new Subject();
		String sql = "SELECT * FROM subject WHERE subject='" + subject + "'";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				sub.setSubject(rs.getString("subject"));
				sub.setExamTime(rs.getInt("examTime"));
				sub.setSubjectStatus((String) rs.getObject("subjectStatus"));
				return sub;
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

}
