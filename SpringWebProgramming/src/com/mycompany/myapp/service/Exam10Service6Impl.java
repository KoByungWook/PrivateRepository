package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

@Component
public class Exam10Service6Impl implements Exam10Service6{
//	@Autowired - type을 기준
//	private Exam10Dao3 exam10Dao3;
	@Resource(name="exam10Dao3ImplA")
	private Exam10Dao3 exam10Dao3;
	

	@Override
	public void join() {
		System.out.println("Exam10Service6Impl - join()");
		exam10Dao3.insert();
	}
	
	@Override
	public void login() {
		System.out.println("Exam10Service6Impl - login()");
		exam10Dao3.select();
	}
}
