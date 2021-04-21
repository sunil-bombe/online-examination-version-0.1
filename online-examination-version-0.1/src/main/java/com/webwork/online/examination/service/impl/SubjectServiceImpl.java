package com.webwork.online.examination.service.impl;

import java.util.List;

import com.webwork.online.examination.dao.SubjectDao;
import com.webwork.online.examination.dao.impl.SubjectDaoImpl;
import com.webwork.online.examination.model.Subject;
import com.webwork.online.examination.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private SubjectDao subjectDao = new SubjectDaoImpl();

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectDao.getAllSubject();
	}

	@Override
	public boolean setSubject(Subject subject) {
		// TODO Auto-generated method stub
		
		return subjectDao.setSubject(subject);
	}

}
