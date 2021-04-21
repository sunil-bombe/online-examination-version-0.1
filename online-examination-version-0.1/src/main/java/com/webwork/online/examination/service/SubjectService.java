package com.webwork.online.examination.service;

import java.util.List;

import com.webwork.online.examination.model.Subject;

public interface SubjectService {
	
	List<Subject> getAllSubject();
	
	boolean setSubject(Subject subject);
}
