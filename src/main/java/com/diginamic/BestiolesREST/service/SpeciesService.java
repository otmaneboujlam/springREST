package com.diginamic.BestiolesREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diginamic.BestiolesREST.entity.Species;
import com.diginamic.BestiolesREST.exception.EntityToCreateHasAnIdException;
import com.diginamic.BestiolesREST.exception.EntityToUpdateHasNoIdException;
import com.diginamic.BestiolesREST.repository.SpeciesRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository speciesRepository;

	public Species create(@Valid Species speciesToCreate) {
		if(speciesToCreate.getId() != null) {
			throw new EntityToCreateHasAnIdException("Entity To Create Has An Id");
		}
		return this.speciesRepository.save(speciesToCreate);
	}
	
	public Species update(@Valid Species updatedSpecies) {
		if(updatedSpecies.getId() == null) {
			throw new EntityToUpdateHasNoIdException("Entity To Update Has No Id");
		}
		if(!speciesRepository.existsById(updatedSpecies.getId())) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		return this.speciesRepository.save(updatedSpecies);
	}
	
	public Page<Species> findPage(Pageable pageable) {
		return this.speciesRepository.findAll(pageable);
	}
	
	public List<Species> findAll() {
		return this.speciesRepository.findAll();
	}
	
	public Species findById(Integer id) {
		return this.speciesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
	}
	
	public void deleteById(Integer id) {
		if(!speciesRepository.existsById(id)) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		speciesRepository.deleteById(id);
	}
	
}
