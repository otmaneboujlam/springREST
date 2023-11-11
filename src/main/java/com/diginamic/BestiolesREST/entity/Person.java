package com.diginamic.BestiolesREST.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(length = 11, columnDefinition = "integer default NULL")
	private Integer age;
	
	@Column(length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String firstname;
	
	@Column(length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String lastname;

	@ManyToMany
	@JoinTable(
		name = "person_animals",
		joinColumns = @JoinColumn(name = "person_id")
			)
	private List<Animal> animals = new ArrayList<Animal>();

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}