package com.diginamic.BestiolesREST.dto;

public class AnimalDto {
	
	private Integer id;
	private String name;
	private String species;
	private String Color;
	private String persons;
	
	public AnimalDto(Integer id, String name, String species, String color, String persons) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
		Color = color;
		this.persons = persons;
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getPersons() {
		return persons;
	}

	public void setPersons(String persons) {
		this.persons = persons;
	}

}
