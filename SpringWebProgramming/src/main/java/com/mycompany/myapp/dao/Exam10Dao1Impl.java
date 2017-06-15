package com.mycompany.myapp.dao;

import org.springframework.stereotype.Component;

@Component
public class Exam10Dao1Impl implements Exam10Dao1{
	
	public void insert() {
		System.out.println("Exam10Dao1Impl - insert()");
	}
	
		
	public void select() {
		System.out.println("Exam10Dao1Impl - select()");
	}
}
