package com.diginamic.BestiolesREST.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.BestiolesREST.dto.AnimalDto;
import com.diginamic.BestiolesREST.entity.Animal;
import com.diginamic.BestiolesREST.service.AnimalService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/rest/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@PostMapping
	public Animal createAnimal(@RequestBody @Valid Animal animalToCreate) {
		return animalService.create(animalToCreate);
	}
	
	@PutMapping
	public Animal updateAnimal(@RequestBody @Valid Animal updatedAnimal) {
		return animalService.update(updatedAnimal);
	}
	
	@GetMapping
	public Page<AnimalDto> findAll(@PathParam("pageable") Pageable pageable) {
		return animalService.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Animal findOne(@PathVariable("id") Integer id) {
		return animalService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable("id") Integer id) {
		animalService.deleteById(id);
	}
	
}
