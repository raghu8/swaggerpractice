package com.raghu.swaggerapp.swaggerpractice.model;

import org.springframework.stereotype.Service;

@Service
public class Person {
	private String name;
	private int age;
	private String profession;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
