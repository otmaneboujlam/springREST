package com.diginamic.BestiolesREST.dto;

import java.util.List;

public class PersonDto {
	
	private Integer id;
	private String name;
	private Integer age;
	private List<String> animal;
	
	public PersonDto(Integer id, String name, Integer age, List<String> animal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.animal = animal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<String> getAnimal() {
		return animal;
	}

	public void setAnimal(List<String> animal) {
		this.animal = animal;
	}

}
