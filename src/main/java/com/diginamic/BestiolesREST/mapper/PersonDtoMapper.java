package com.diginamic.BestiolesREST.mapper;

import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.dto.PersonDto;
import com.diginamic.BestiolesREST.entity.Person;

@Service
public class PersonDtoMapper {

	public PersonDto toDto(Person person) {
		
		PersonDto dto = new PersonDto(
				person.getId(),
				person.getLastname().toUpperCase()+" "+person.getFirstname(),
				person.getAge(),
				person.getAnimals().stream().map((animal) -> animal.getName()+"("+animal.getSpecies().getCommonName()+")").toList()
				);
		
		return dto;
	}
	
}
