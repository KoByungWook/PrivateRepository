package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;

@Component
public class Exam10Service2Impl implements Exam10Service2{
	
	private Exam10Dao1 exam10Dao;	
	@Autowired
	public void setExam10Dao(Exam10Dao1 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}

	@Override
	public void join() {
		System.out.println("Exam10Service2Impl - join()");
		exam10Dao.insert();
	}
	
	@Override
	public void login() {
		System.out.println("Exam10Service2Impl - login()");
		exam10Dao.select();
	}
}
