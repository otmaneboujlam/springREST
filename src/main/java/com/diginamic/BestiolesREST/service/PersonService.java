package com.diginamic.BestiolesREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.entity.Person;
import com.diginamic.BestiolesREST.repository.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person create(@Valid Person personToCreate) {
		return this.personRepository.save(personToCreate);
	}
	
	public Person update(@Valid Person updatedPerson) {
		return this.personRepository.save(updatedPerson);
	}
	
	public Page<Person> findAll(Pageable pageable) {
		return this.personRepository.findAll(pageable);
	}
	
	public Person findById(Integer id) {
		return this.personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void deleteById(Integer id) {
		personRepository.deleteById(id);
	}
	
}
