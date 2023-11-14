package com.diginamic.BestiolesREST.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.entity.Animal;
import com.diginamic.BestiolesREST.exception.EntityToCreateHasAnIdException;
import com.diginamic.BestiolesREST.exception.EntityToUpdateHasNoIdException;
import com.diginamic.BestiolesREST.repository.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;

	public Animal create(@Valid Animal animalToCreate) {
		if(animalToCreate.getId() != null) {
			throw new EntityToCreateHasAnIdException("Entity To Create Has An Id");
		}
		return this.animalRepository.save(animalToCreate);
	}
	
	public Animal update(@Valid Animal updatedAnimal) {
		if(updatedAnimal.getId() == null) {
			throw new EntityToUpdateHasNoIdException("Entity To Update Has No Id");
		}
		Optional<Animal> animalOpt = animalRepository.findById(updatedAnimal.getId());
		if(animalOpt.isEmpty()) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		return this.animalRepository.save(updatedAnimal);
	}
	
	public Page<Animal> findAll(Pageable pageable) {
		return this.animalRepository.findAll(pageable);
	}
	
	public Animal findById(Integer id) {
		return this.animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
	}
	
	public void deleteById(Integer id) {
		Optional<Animal> animalOpt = animalRepository.findById(id);
		if(animalOpt.isEmpty()) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		animalRepository.deleteById(id);
	}
	
}
