package com.webwork.online.examination.dao;

import java.util.List;

import com.webwork.online.examination.model.Subject;

public interface SubjectDao {

	List<Subject> getAllSubject();
	
	boolean setSubject(Subject subject);
	
	Subject getSubject(String subject);
}
