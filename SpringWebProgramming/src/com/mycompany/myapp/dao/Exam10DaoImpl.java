package com.mycompany.myapp.dao;

import org.springframework.stereotype.Component;

@Component
public class Exam10DaoImpl implements Exam10Dao{
	
	public void insert() {
		System.out.println("insert()");
	}
	
		
	public void select() {
		System.out.println("select()");
	}
}
