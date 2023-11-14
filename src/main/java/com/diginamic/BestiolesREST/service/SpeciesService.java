package com.diginamic.BestiolesREST.service;

import java.util.Optional;

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
		Optional<Species> speciesOpt = speciesRepository.findById(updatedSpecies.getId());
		if(speciesOpt.isEmpty()) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		return this.speciesRepository.save(updatedSpecies);
	}
	
	public Page<Species> findAll(Pageable pageable) {
		return this.speciesRepository.findAll(pageable);
	}
	
	public Species findById(Integer id) {
		return this.speciesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
	}
	
	public void deleteById(Integer id) {
		Optional<Species> speciesOpt = speciesRepository.findById(id);
		if(speciesOpt.isEmpty()) {
			throw new EntityNotFoundException("Entity Not Found");
		}
		speciesRepository.deleteById(id);
	}
	
}
