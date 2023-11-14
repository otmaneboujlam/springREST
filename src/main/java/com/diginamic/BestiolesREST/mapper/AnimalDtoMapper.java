package com.diginamic.BestiolesREST.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.dto.AnimalDto;
import com.diginamic.BestiolesREST.entity.Animal;

@Service
public class AnimalDtoMapper {

	public AnimalDto toDto(Animal animal) {
		
		AnimalDto dto = new AnimalDto(
				animal.getId(),
				animal.getName(),
				animal.getSpecies().getCommonName(),
				animal.getColor(),
				animal.getPersons().stream().map((person) -> person.getLastname().toUpperCase()+" "+person.getFirstname()).collect(Collectors.joining(" ; "))
				);
		
		return dto;
		
	}
	
}
