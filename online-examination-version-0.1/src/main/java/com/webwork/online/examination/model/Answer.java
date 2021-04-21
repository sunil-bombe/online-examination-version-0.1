package com.webwork.online.examination.model;

public class Answer {
	private int userId;
	private int questionId;
	private String answer;
	private String subject;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Answer [userId=" + userId + ", questionId=" + questionId + ", answer=" + answer + ", subject=" + subject
				+ "]";
	}
	

}
