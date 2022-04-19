package com.sip.ams.entities;

public class Etudiant {
	private String name;
	private Integer age;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Etudiant(String name, Integer age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public Etudiant() {

	}

}
