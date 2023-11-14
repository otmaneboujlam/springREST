package com.diginamic.BestiolesREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.BestiolesREST.dto.PersonDto;
import com.diginamic.BestiolesREST.entity.Person;
import com.diginamic.BestiolesREST.service.PersonService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
	

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public Person createPerson(@RequestBody @Valid Person personToCreate) {
		return personService.create(personToCreate);
	}
	
	@PutMapping
	public Person updatePerson(@RequestBody @Valid Person updatedPerson) {
		return personService.update(updatedPerson);
	}
	
	@GetMapping
	public Page<PersonDto> findAll(@PathParam("pageable") Pageable pageable) {
		return personService.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Person findOne(@PathVariable("id") Integer id) {
		return personService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable("id") Integer id) {
		personService.deleteById(id);
	}
	
}
