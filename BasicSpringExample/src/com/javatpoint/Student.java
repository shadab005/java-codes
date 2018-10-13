package com.javatpoint;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String name;

	@Autowired
	private Subject subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void displayInfo() {
		System.out.println("Hello: " + name);
	}
	
	public Subject getSubject() {
		return subject;
	}
}