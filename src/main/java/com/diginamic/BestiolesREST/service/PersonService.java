package com.diginamic.BestiolesREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.dto.PersonDto;
import com.diginamic.BestiolesREST.entity.Person;
import com.diginamic.BestiolesREST.exception.EntityToCreateHasAnIdException;
import com.diginamic.BestiolesREST.exception.EntityToUpdateHasNoIdException;
import com.diginamic.BestiolesREST.mapper.PersonDtoMapper;
import com.diginamic.BestiolesREST.repository.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {
	
	@Autowired
	private PersonDtoMapper personDtoMapper; 
	
	@Autowired
	private PersonRepository personRepository;

	public Person create(@Valid Person personToCreate) {
		if(personToCreate.getId() != null) {
			throw new EntityToCreateHasAnIdException("Entity To Create Has An Id");
		}
		return this.personRepository.save(personToCreate);
	}
	
	public Person update(@Valid Person updatedPerson) {
		if(updatedPerson.getId() == null) {
			throw new EntityToUpdateHasNoIdException("Entity To Update Has No Id");
		}
		if(!personRepository.existsById(updatedPerson.getId())) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		return this.personRepository.save(updatedPerson);
	}
	
	public Page<PersonDto> findPage(Pageable pageable) {
		return personRepository.findAll(pageable).map((person) -> personDtoMapper.toDto(person));
	}
	
	public List<PersonDto> findAll() {
		return personRepository.findAll().stream().map((person) -> personDtoMapper.toDto(person)).toList();
	}
	
	public Person findById(Integer id) {
		return this.personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
	}
	
	public void deleteById(Integer id) {
		if(!personRepository.existsById(id)) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		personRepository.deleteById(id);
	}
	
}
