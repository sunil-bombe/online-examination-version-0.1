package com.webwork.online.examination.service.impl;

import java.util.List;

import com.webwork.online.examination.dao.QuestionPaperDao;
import com.webwork.online.examination.dao.impl.QuestionPaperDaoImpl;
import com.webwork.online.examination.model.Answer;
import com.webwork.online.examination.model.QuestionPaper;
import com.webwork.online.examination.service.QuestionPaperService;

public class QuestionPaperServiceImpl implements QuestionPaperService {
	private QuestionPaperDao questionPaperDao = new QuestionPaperDaoImpl();

	private List<QuestionPaper> questionPaperList = questionPaperDao.getQuestion();

	@Override
	public List<QuestionPaper> getQuestionPaper(String subject) {
		// TODO Auto-generated method stub
		return questionPaperDao.getQuestionBySubject(subject);
	}

	@Override
	public int getQuestionCount(String subject) {
		// TODO Auto-generated method stub
		return questionPaperDao.getQuestionCount(subject);
	}

	@Override
	public boolean saveAnswer(Answer[] answer, int count) {
		// TODO Auto-generated method stub
		return questionPaperDao.saveAnswer(answer, count);
	}

	@Override
	public boolean isTestGivenBefore(int userId) {
		// TODO Auto-generated method stub
		return questionPaperDao.isTestGivenBefore(userId);
	}

	@Override
	public boolean checkAnswer(int qId, String answer) {
		// TODO Auto-generated method stub
		for (QuestionPaper questionPaper : questionPaperList) {
			if (questionPaper.getqID() == qId) {
				if (questionPaper.getAnswer().equals(answer)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getUserAnswer(int userId, int qId) {
		// TODO Auto-generated method stub
		String userAnswer = null;
		List<Answer> answerList = questionPaperDao.getUserAnswer(userId);
		for (Answer ans : answerList) {
			if (ans.getQuestionId() == qId) {
				userAnswer = ans.getAnswer();
			}
		}
		String newAnswer = null;

		for (QuestionPaper questionPaper : questionPaperList) {
			if (questionPaper.getqID() == qId) {
				if (userAnswer.equals("A")) {
					newAnswer = questionPaper.getA();
				} else if (userAnswer.equals("B")) {
					newAnswer = questionPaper.getB();
				} else if (userAnswer.equals("C")) {
					newAnswer = questionPaper.getC();
				} else if (userAnswer.equals("D")) {
					newAnswer = questionPaper.getD();
				}
			}

		}

		return newAnswer;

	}

	@Override
	public boolean checkUserAnswer(int qId, String answer) {
		// TODO Auto-generated method stub
		String newAnswer = null;
		for (QuestionPaper questionPaper : questionPaperList) {
			if (questionPaper.getqID() == qId) {
				if (questionPaper.getAnswer().equals("A")) {
					newAnswer = questionPaper.getA();
				} else if (questionPaper.getAnswer().equals("B")) {
					newAnswer = questionPaper.getB();
				} else if (questionPaper.getAnswer().equals("C")) {
					newAnswer = questionPaper.getC();
				} else if (questionPaper.getAnswer().equals("D")) {
					newAnswer = questionPaper.getD();
				}
			}

		}

		if (answer.contentEquals(newAnswer)) {
			return true;
		} else {
			return false;
		}
	}

}
