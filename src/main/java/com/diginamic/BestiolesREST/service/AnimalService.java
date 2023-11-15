package com.diginamic.BestiolesREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.dto.AnimalDto;
import com.diginamic.BestiolesREST.entity.Animal;
import com.diginamic.BestiolesREST.exception.EntityToCreateHasAnIdException;
import com.diginamic.BestiolesREST.exception.EntityToUpdateHasNoIdException;
import com.diginamic.BestiolesREST.mapper.AnimalDtoMapper;
import com.diginamic.BestiolesREST.repository.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalDtoMapper animalDtoMapper;
	
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
		if(!animalRepository.existsById(updatedAnimal.getId())) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		return this.animalRepository.save(updatedAnimal);
	}
	
	public Page<AnimalDto> findPage(Pageable pageable) {
		return animalRepository.findAll(pageable).map((animal) -> animalDtoMapper.toDto(animal));
	}
	
	public List<AnimalDto> findAll() {
		return animalRepository.findAll().stream().map((animal) -> animalDtoMapper.toDto(animal)).toList();
	}
	
	public Animal findById(Integer id) {
		return this.animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
	}
	
	public void deleteById(Integer id) {
		if(!animalRepository.existsById(id)) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		animalRepository.deleteById(id);
	}
	
}
