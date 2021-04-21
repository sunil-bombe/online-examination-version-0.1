package com.webwork.online.examination.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webwork.online.examination.connection.ConnectionManager;
import com.webwork.online.examination.dao.QuestionPaperDao;
import com.webwork.online.examination.model.Answer;
import com.webwork.online.examination.model.QuestionPaper;

public class QuestionPaperDaoImpl implements QuestionPaperDao {

	@Override
	public List<QuestionPaper> getQuestion() {

		List<QuestionPaper> questionPaperList = new ArrayList<>();
		String sql2 = "SELECT * FROM questionpaper WHERE subject='Angular'";
		try {
			Statement stmt2 = (Statement) ConnectionManager.getConnection().createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			while (rs2.next()) {
				QuestionPaper questionPaper = new QuestionPaper();
				questionPaper.setqID(rs2.getInt("qId"));
				questionPaper.setQuestion(rs2.getString("question"));
				questionPaper.setA(rs2.getString("A"));
				questionPaper.setB(rs2.getString("B"));
				questionPaper.setC(rs2.getString("C"));
				questionPaper.setD(rs2.getString("D"));
				questionPaper.setAnswer(rs2.getString("answer"));
				questionPaperList.add(questionPaper);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return questionPaperList;
	}

	@Override
	public int getQuestionCount(String subject) {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT COUNT(*) AS rowcount FROM questionpaper WHERE subject='" + subject + "'";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			count = (int) rs.getInt("rowcount");
			return count;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean saveAnswer(Answer[] answer, int count) {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {
			int qId = answer[i].getQuestionId();
			String ans = answer[i].getAnswer();
			int userId = answer[i].getUserId();
			String sql = "INSERT INTO answer (qId, answer, userId) VALUES (" + qId + ",'" + ans + "'," + userId + ")";
			try {
				Statement stmt = ConnectionManager.getConnection().createStatement();
				if (stmt.executeUpdate(sql) != 1) {
					return false;
				}
				// DatabaseConnection.getConnection().close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return true;
	}

	@Override
	public boolean isTestGivenBefore(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM answer WHERE userId=" + userId + "";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
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

	@Override
	public int submitAnswerCount(int userId) {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT COUNT(*) AS answerCount FROM answer WHERE userId='" + userId + "'";
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			count = (int) rs.getInt("answerCount");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Answer> getUserAnswer(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM answer WHERE userId=" + userId;
		List<Answer> answerList = new ArrayList<>();
		try {
			Statement stmt = ConnectionManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Answer answer = new Answer();
				answer.setQuestionId(rs.getInt("qId"));
				answer.setAnswer(rs.getString("answer"));
				answer.setUserId(userId);
				answerList.add(answer);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return answerList;
	}

	@Override
	public List<QuestionPaper> getQuestionBySubject(String subject) {
		// TODO Auto-generated method stub

		List<QuestionPaper> questionPaperList = new ArrayList<>();
		String sql2 = "SELECT * FROM questionpaper WHERE subject='"+ subject +"'";
		try {
			Statement stmt2 = (Statement) ConnectionManager.getConnection().createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			while (rs2.next()) {
				QuestionPaper questionPaper = new QuestionPaper();
				questionPaper.setqID(rs2.getInt("qId"));
				questionPaper.setQuestion(rs2.getString("question"));
				questionPaper.setA(rs2.getString("A"));
				questionPaper.setB(rs2.getString("B"));
				questionPaper.setC(rs2.getString("C"));
				questionPaper.setD(rs2.getString("D"));
				questionPaper.setAnswer(rs2.getString("answer"));
				questionPaperList.add(questionPaper);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return questionPaperList;
	}

}
